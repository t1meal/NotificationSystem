package ru.fcahp.system.mapper;


import org.mapstruct.Mapper;
import ru.fcahp.system.dto.NotificationDto;
import ru.fcahp.system.entity.Notification;


@Mapper(componentModel = "spring", uses = ProductPackageMapper.class)
public interface NotificationMapper {

    NotificationDto toDto(Notification entity);

    Notification fromDto(NotificationDto dto);

}
