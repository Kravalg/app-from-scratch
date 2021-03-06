# Объектно-ориентированное проектирование

Перед тем как двигаться дальше, важно понять как Clojure соотносится с наработками
в области объектно-ориентированного проектирования.

В книге ["Совершенный код"](https://www.ozon.ru/context/detail/id/138437220/) есть мысль:

> Как сказал Дэвид Грайс, подход к программированию не должен определяться используемыми инструментами.
> В связи с этим он проводит различие между программированием *на* языке (programming *in* language)
> и программированием *с использованием* языка (programming *into* language). Разработчики,
> программирующие "на" языке, ограничивают свое мышление конструкциями, непосредственно поддерживаемыми
> языком. Если предоставляемые языком средства примитивны, мысли программистов будут
> столь же примитивными.
>
> Разработчики, программирующие "с использованием" языка, сначала решают,
> какие мысли они хотят выразить, после чего определяют,
> как выразить их при помощи конкретного языка.

В книге ["Приемы объектно-ориентированного проектирования. Паттерны проектирования"](https://www.ozon.ru/context/detail/id/2457392/)
есть абзац,
показывающий связь между парадигмой языка и способностью реализовывать паттерны:

> Выбор языка программирования безусловно важен. В наших паттернах подразумевается использование
> возможностей Smalltalk и C++, и от этого зависит, что реализовать легко, а что - трудно.
> Если бы мы ориентировались на процедурные языки, то включили бы паттерны
> **наследование**, **инкапсуляция** и **полиморфизм**. Некоторые из наших паттернов напрямую
> поддерживаются менее распространенными языками.


В книге [Clean Architecture](https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164) дается определение объектно-ориентированному проектированию(OO):

> What is OO? There are many opinions and many answers to this question. To the software architect, however, the answer is clear: OO is the ability, through the use of polymorphism, to gain absolute control over every source code dependency in the system. It allows the architect to create a plugin architecture, in which modules that contain high-level policies are independent of modules that contain low-level details. The low-level details are relegated to plugin modules that can be deployed and developed independently from the modules that contain high-level policies.

Clojure имеет поддержку динамического полиморфизма по определению,
т.к. Clojure - динамический язык. Кроме этого он имеет концепции мультиметодов и протоколов,
с которыми мы познакомились ранее. И тот факт, что Clojure функциональный язык,
не должен мешать применять подходы объектно-ориентированного проектирования.
