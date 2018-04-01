(ns publicator.use-cases.interactors.user.register
  (:require
   [publicator.use-cases.abstractions.storage :as storage]
   [publicator.use-cases.abstractions.user-queries :as user-q]
   [publicator.use-cases.services.user-session :as user-session]
   [publicator.domain.aggregates.user :as user]
   [darkleaf.either :as e]
   [clojure.spec.alpha :as s]
   [publicator.ext :as ext]))

(s/def ::params (ext/only-keys :req-un [::user/login
                                        ::user/full-name
                                        ::user/password]))

(defn- check-logged-out= []
  (if (user-session/logged-out?)
    (e/right)
    (e/left {:type ::already-logged-in})))

(defn- check-params= [params]
  (if-let [exp (s/explain-data ::params params)]
    (e/left {:type ::invalid-params, :explain-data exp})
    (e/right)))

(defn- check-not-registered= [params]
  (if (user-q/get-by-login (:login params))
    (e/left {:type ::already-registered})
    (e/right)))

(defn- create-user [params]
  (storage/tx-create (user/build params)))

(defn initial-params []
  @(e/let= [ok (check-logged-out=)]
     {:type ::initial-params, :initial-params {}}))

(defn process [params]
  @(e/let= [ok   (check-logged-out=)
            ok   (check-params= params)
            ok   (check-not-registered= params)
            user (create-user params)]
     (user-session/log-in! user)
     {:type ::processed :user user}))