# Travel Cost

Расчёт стоимости поездки на одного человека / на компанию

Меню:
1. Добавить поездку из статей расходов{Название, стоимость, валюта-конст(выбранная)}
    Список статей расходов из класса статья расходов, 
    подкласс готовых расчётов статей расходов: 
    - [1] Жильё (цена за 1 человека или полностью за жильё)
    - [2] Проезд (общественный транспорт /
      машина (учесть, вместимость 5 человек), будет ли использование платных дорог)
    - [3] Будете ли использовать городской транспорт
    - [4] Питание (Будете питаться в общепите / сами готовить(средняя стоимость закупки продуктов на неделю и на сколько человек, что
          чтоб расчитать, стоимость питания одного дня))
    - [5] Средняя цена экскурсии, количество экскурсий
    - [7] Другие развлечения
    - [e] добавить свою статью расходов
    - изменить статью
    - удалить статью
      
2. Посмотреть поездки
    - Вывести все поездки {номер, название стоимость общая, и за одного человека}
    - Посмотреть одну поездку:
        Вывести список поездок на экран 
    и выбрать, которая интересует 
    - в главное меню
3. Внести изминения в поездку
4. Удалить поездку
5. Сравнить поездки (только встроеные основные пункты) ? фича
6. О програме
7. Выйти из программы 

**Файлы**  
- Main (запуск программы)
- GoTravel (Основной код программы)
- Trips - этот кдасс выполняе функцию:
    - Вывод на экран всех поездок и одной
    - Редактирование поездки (изменить / удалить строку)
    - Удалить поездку
    - Сравниваем все поездки по базовым статьям расходов 
- TripCreator (Созданеи поездок из названия и списка статей расходов Expense)
    - Appart (жильё)
    - Transfer (расчёт проезда)
    - LocalTransport (местный транспорт, не обязательный, будем спрашивать )
    - Food(затраты на еду)
    - Excursion (затраты на экскурсию)
    - Entertainment(развлечения, не обязательный, будем спрашивать )
- Expense (конструктор статьи расходов) дочерние статьи:

