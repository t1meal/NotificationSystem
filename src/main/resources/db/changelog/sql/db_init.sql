CREATE TABLE metric_units
(
    id      bigint primary key not null,
    caption varchar(100)
);

CREATE TABLE crossing_points
(
    id      bigint primary key not null,
    caption varchar(100)
);

CREATE TABLE notifications
(
    id                bigint primary key not null,
    sender            varchar(100),
    recipient         varchar(100),
    cargoArrivalDate  timestamp with time zone,
    status            varchar(10),
    crossing_point_id bigint references crossing_points (id),
    created_at        timestamp with time zone default current_timestamp,
    extra_info        varchar(256)
);

CREATE TABLE product_packages
(
    id              bigint primary key not null,
    caption         varchar(100),
    capacity        numeric(8, 2),
    notification_id bigint references notifications (id),
    metric_unit_id  bigint references metric_units (id)
);




