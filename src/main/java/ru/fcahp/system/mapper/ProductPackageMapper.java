package ru.fcahp.system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.fcahp.system.common.MetricUnit;
import ru.fcahp.system.dto.ProductPackageDto;
import ru.fcahp.system.entity.ProductPackage;

@Mapper (componentModel = "spring")
public interface ProductPackageMapper {
    @Mapping(target = "metricUnit", source = "metricUnit.caption")
    ProductPackageDto toDto (ProductPackage productPackage);
    @Mapping(target = "metricUnit", source = "metricUnit", qualifiedByName = {"castMetricUnit"})
    ProductPackage fromDto(ProductPackageDto dto);

    @Named("castMetricUnit")
    default MetricUnit castMetricUnit(String caption){
        return MetricUnit.fromCaption(caption);
    }
}
