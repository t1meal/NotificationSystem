package ru.fcahp.system.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.fcahp.system.common.CrossingPoint;
import ru.fcahp.system.common.NotificationStatus;
import ru.fcahp.system.dto.NotificationDto;
import ru.fcahp.system.entity.Notification;


@Mapper(componentModel = "spring", uses = ProductPackageMapper.class)
public interface NotificationMapper {

    @Mapping(target = "status", source = "status.caption")
    @Mapping(target = "crossingPoint", source = "crossingPoint.caption")
    NotificationDto toDto(Notification entity);

    @Mapping(target = "status", source = "status", qualifiedByName = {"castStatus"})
    @Mapping(target = "crossingPoint", source = "crossingPoint", qualifiedByName = {"castCrossingPoint"})
    Notification fromDto(NotificationDto dto);

    @Named("castStatus")
    default NotificationStatus castStatus(String caption){
        return NotificationStatus.fromCaption(caption);
    }
    @Named("castCrossingPoint")
    default CrossingPoint castCrossingPoint(String caption){
        return CrossingPoint.fromCaption(caption);
    }
}
