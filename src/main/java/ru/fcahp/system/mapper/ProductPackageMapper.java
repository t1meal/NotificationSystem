package ru.fcahp.system.mapper;

import org.mapstruct.Mapper;
import ru.fcahp.system.dto.ProductPackageDto;
import ru.fcahp.system.entity.ProductPackage;

@Mapper (componentModel = "spring")
public interface ProductPackageMapper {
    ProductPackageDto toDto (ProductPackage productPackage);
    ProductPackage fromDto(ProductPackageDto dto);
}
