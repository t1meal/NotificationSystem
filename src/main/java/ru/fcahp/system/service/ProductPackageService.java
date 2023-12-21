package ru.fcahp.system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fcahp.system.entity.ProductPackage;
import ru.fcahp.system.repository.ProductPackageRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductPackageService {

    private final ProductPackageRepository productPackageRepository;

    public ProductPackage getById(Long id) {
        return productPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product package id: " + id + " not found"));
    }

    public void create(ProductPackage input) {
        productPackageRepository.save(input);
    }

    @Transactional
    public void update(ProductPackage input) {
        Optional<ProductPackage> entity = productPackageRepository.findById(input.getId());
        if (entity.isPresent()){
            productPackageRepository.save(input);
        } else {
            throw new ResourceNotFoundException("Update entity. Product package with id " + input.getId() + " is not exist!");
        }
    }

    public void deleteById(Long id) {
        Optional<ProductPackage> deletedProduct = productPackageRepository.findById(id);
        if (deletedProduct.isPresent()){
            productPackageRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Delete entity. Product package with id " + id + " is not exist!");
        }
    }
}
