#language: ru
Функционал: Ипотека

    @Test
    Сценарий: Ипотечный калькулятор
        * подтвержден регион
        * выбран пункт меню "Ипотека"
        * выбран подпункт меню "Ипотечный калькулятор"
        * проеверен "Заголовок" - "Ипотечный калькулятор"
        * выпадающий список "Город" заполняется значением "Москва"
        * отмечен чекбокс - "Знаю свою ипотечную программу"
        * выпадающий список "Вид ипотечной программы" заполняется значением "Квартира на вторичном рынке"
        * выпадающий список "Я являюсь" заполняется значением "Новый клиент"