INSERT INTO metric_units (caption)
VALUES ('м3'),
       ('cм3'),
       ('м2'),
       ('cм2'),
       ('шт');

INSERT INTO notifications (sender, recipient, cargo_arrival_date, status, crossing_point, extra_info)
VALUES ('ООО КНМ', 'Прокуратура МО', '2023-12-28', 'CREATED', 'WEST', 'type XL BOX'),
       ('ИП Андреев', 'Х5 Retail Group', '2023-12-24', 'ORDERED', 'EAST', 'type BOX'),
       ('ОАО Интракс', 'Пятерочка', '2023-12-31', 'CREATED', 'MAIN', 'large BOX'),
       ('ОАО Интракс', 'Магнит', '2023-12-30', 'ORDERED', 'MAIN', 'large BOX'),
       ('ОАО Интракс', 'Дикси', '2023-12-29', 'ORDERED', 'NORTH', 'large BOX'),
       ('ИП Николаев', 'Дикси', '2023-12-15', 'CLOSED', 'NORTH', 'BOX'),
       ('ИП Николаев', 'ИП Авдеев', '2023-12-15', 'CLOSED', 'NORTH', 'BOX');

INSERT INTO product_packages (caption, capacity, notification_id, metric_unit_id)
VALUES ('Штукатурка', 23.00, 1, 1),
       ('Половая плитка', 15.50, 1, 3),
       ('Ценные бумаги', 0.2, 2, 1),
       ('Чернила для принтера', 23.00, 2, 5),
       ('Бумага', 1.00, 3, 1),
       ('Песок', 50.20, 3, 5),
       ('Цемент', 15.10, 4, 5),
       ('Бумага', 1.00, 4, 1),
       ('Песок', 50.20, 4, 5),
       ('Цемент', 15.10, 4, 5),
       ('Бумага', 1.00, 5, 1),
       ('Песок', 50.20, 5, 5),
       ('Цемент', 15.10, 5, 5),
       ('Ценные вещи', 1.00, 6, 5),
       ('Ценные вещи', 1.00, 7, 5);