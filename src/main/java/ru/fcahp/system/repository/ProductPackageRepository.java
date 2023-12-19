package ru.fcahp.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fcahp.system.entity.ProductPackage;

@Repository
public interface ProductPackageRepository extends JpaRepository<ProductPackage, Long> {
}
