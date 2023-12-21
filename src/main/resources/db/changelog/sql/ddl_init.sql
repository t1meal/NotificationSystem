-- CREATE TABLE metric_units
-- (
--     id      bigserial primary key not null,
--     caption varchar(100)
-- );

CREATE TABLE notifications
(
    id                 bigserial primary key not null,
    sender             varchar(100),
    recipient          varchar(100),
    cargo_arrival_date date,
    status             varchar(20),
    crossing_point     varchar(20),
    created_at         timestamp with time zone default now(),
    extra_info         varchar(256)
);

CREATE TABLE product_packages
(
    id              bigserial primary key not null,
    caption         varchar(100),
    capacity        numeric(8, 2),
    notification_id bigint references notifications (id),
    metric_unit     varchar(20)
);




