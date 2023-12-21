INSERT INTO notifications (sender, recipient, cargo_arrival_date, status, crossing_point, extra_info)
VALUES ('ООО Гига', 'ИП Курсанов', '2023-12-22', 'CREATED', 'WEST', 'Бокс'),
       ('ООО Гига', 'Дикси', '2023-12-23', 'ORDERED', 'EAST', 'Увеличенный бокс'),
       ('ПАО Авалон', 'Дикси', '2023-12-30', 'CREATED', 'MAIN', 'Увеличенный бокс'),
       ('ОАО Интракс', 'ИП Курсанов', '2023-12-30', 'ORDERED', 'MAIN', 'Увеличенный бокс'),
       ('ОАО Интракс', 'ИП Курсанов', '2023-12-29', 'ORDERED', 'NORTH', 'Увеличенный бокс'),
       ('ИП Николаев', 'ИП Курсанов', '2023-12-15', 'CLOSED', 'NORTH', 'Бокс обычный');