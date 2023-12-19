package ru.fcahp.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fcahp.system.entity.ProductPackage;
import ru.fcahp.system.repository.ProductPackageRepository;

import java.util.Optional;

@Service
public class ProductPackageService {

    @Autowired
    private ProductPackageRepository productPackageRepository;

    public ProductPackage getById(Long id) {
        return productPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product package id: " + id + " not found"));
    }

    public void create(ProductPackage input) {
//        validator.validate(input);
        productPackageRepository.save(input);
    }

    @Transactional
    public void update(ProductPackage input) {
        Optional<ProductPackage> entity = productPackageRepository.findById(input.getId());
        if (entity.isPresent()){
//            validator.validate(input);
        } else {
            throw new ResourceNotFoundException("Update entity. Product package with id " + input.getId() + " is not exist!");
        }
        productPackageRepository.save(input);
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
