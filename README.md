# Практикум SDET: задание UI

### Задание

1. Составить подробные тест-кейсы по чек-листу из 3 кейсов, описанному далее.
2. На языке программирования Java (версия 11 или 17) или Python (версия 3.10) создать проект UI-автотестов по тест-кейсам. Кейсы также прикрепить в данный проект (в формате текстового файла с использованием Markdown).
3. В проекте использовать:
    * Selenium Webdriver (желательно использовать браузер Chrome)
    * Один из тестовых фреймворков:
        * Java - TestNG, JUnit 4/5
        * Python - pytest
    * Один из сборщиков (для Java): Maven, Gradle.
4. Результаты на проверку оформить в виде Merge Request/Pull Request (!!!) ветки, в которой вы вели разработку, в главную на Gitlab/GitHub.
5. **Дополнительное задание №1:** Реализовать формирование отчетов Allure.
6. **Дополнительное задание №2:** Реализовать параллельный запуск тестов.
7. **Дополнительное задание №3:** Реализовать запуск в системе CI/CD.

### Чек-лист

**Объект тестирования:**

https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager

**Чек-лист:**

1. **Создание клиента (Add Customer)**

    * При создании тестовых данных для полей Post Code и First Name необходимо:
        * **1.1** Для поля Post Code сгенерировать номер из 10 цифр.
        * **1.2** Для поля First Name сгенерировать имя на основе Post Code согласно следующей логике:
            1) Post Code условно разбиваем на двузначные цифры (получится 5 цифр).
            2) Каждую цифру преобразовываем в букву английского алфавита по порядку от 0 до 25.
            3) Если цифра больше 25, то начинаем с 26 как с 0. Т.е. 0 - a, 26 - тоже a, 52 – тоже a, и т.д.

    **Пример:** 0001252667 = abzap

2. **Сортировка клиентов по имени (First Name)**

3. **Удаление клиента:**

    * При поиске клиента на удаление необходимо:
        1) Получить из таблицы Customers список имен.
        2) Узнать длину каждого имени.
        3) Найти среднее арифметическое получившихся длин.
        4) Удалить клиента с тем именем, у которого длина будет ближе к среднему арифметическому (для Java требуется использовать Stream API).

    **Пример:**

    * Список имен - Albus, Neville, Voldemort.
    * Длины имен – 5, 7, 9 соответственно.
    * Среднее арифметическое длин – 7.
    * Удаляем имя Neville.
	
# Тест-кейсы

## Тест-кейс № 01. "Создание клиента (Add Customer)"

### Описание

Этот тест-кейс проверяет возможность создания нового клиента.

### Шаги

1. Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust
2. В поле "First Name" ввести имя клиента.
3. В поле "Last Name" ввести фамилию клиента.
4. В поле "Post Code" ввести почтовый индекс клиента.
5. Нажать кнопку "Add Customer".

### Ожидаемый результат

* Появляется браузерное всплывающее сообщение "Customer added successfully with customer id :_".
* В разделе "Customers" появляется новая запись с данными введенного клиента.

### Постусловие

1. Нажать кнопку "Ok" во всплывающем окне.

### Дополнительные условия

* для поля Post Code сгенерировать номер из 10 цифр
* для поля First Name сгенерировать имя на основе Post Code согласно следующей логике:
    1. Post Code условно разбиваем на двузначные цифры (получится 5 цифр)
    2. Каждую цифру преобразовываем в букву английского алфавита по порядку от 0 до 25. Если цифра больше 25, то начинаем с 26 как с 0. Т.е. 0 - a, 26 - тоже a, 52 – тоже a, и т.д
	

## Тест-кейс № 02. "Сортировка клиентов по имени (First Name)"

### Описание

Этот тест-кейс проверяет возможность сортировки клиентов по имени в афлавитном порядке.

### Шаги

1. Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
2. Нажать на заголок столбца таблицы "First Name" первый раз.
3. Нажать на заголок столбца таблицы "First Name" второй раз

### Ожидаемый результат

* При первом нажатии таблица отсортируется в алфавитном убывающем порядке
* При втором нажатии таблица отсортируется в алфавитном возрастающем порядке

## Тест-кейс № 03. "Удаление клиента"

### Описание

Этот тест-кейс проверяет возможность удаления желаемого клиента из таблицы.

### Шаги

1. Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
2. Найти нужного пользователя
3. Нажать на кнопку "Delete" в последней ячейки строки данного пользователя

### Ожидаемый результат

* Строка с выбранным пользователем пропадает из таблицы

### Дополнительные условия

 * Получить из таблицы Customers список имен.
 * Узнать длину каждого имени, затем найти среднее
арифметическое получившихся длин и удалить клиента с тем именем, у которого длина будет ближе
к среднему арифметическому (для Java требуется использовать Stream API).
* Пример: список имен - Albus, Neville, Voldemort. Длины имен – 5, 7, 9 соответственно.
Среднее арифметическое длин – 7, удаляем имя Neville.

## Отчёты Allure
![Screen1](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen1.JPG)

![Screen2](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen2.JPG)

![Screen3](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen3.JPG)

![Screen4](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen4.JPG)

![Screen5](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen5.JPG)

![Screen6](https://github.com/Cloud146/SDET-Practicum-Task-1/blob/master/allureScreens/AllureScreen6.JPG)





