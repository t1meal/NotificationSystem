package ru.fcahp.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fcahp.system.entity.Notification;
import ru.fcahp.system.repository.NotificationRepository;
import ru.fcahp.system.specifications.NotificationSpecifications;

import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

//    public Specification<Notification> createSpecByFilters(Integer property, String title) {
//
//        Specification<Notification> spec = Specification.where(null);
//
//        if (property != null) {
//            spec = spec.and(NotificationSpecifications.priceGreaterOrEqualsThan(property));
//        }
//        if (title != null) {
//            spec = spec.and(NotificationSpecifications.titleLike(title));
//        }
//        return spec;
//    }

    public Page<Notification> getAll(Specification<Notification> spec, int pageIndex, int pageSize) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return notificationRepository.findAll(spec , PageRequest.of(pageIndex - 1, pageSize));
    }

    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification id: " + id + " not found"));
    }

    public void create(Notification input) {
//        validator.validate(input);
        notificationRepository.save(input);
    }

    @Transactional
    public void update(Notification input) {
        Optional<Notification> entity = notificationRepository.findById(input.getId());
        if (entity.isPresent()){
//            validator.validate(input);
        } else {
            throw new ResourceNotFoundException("Update entity. Notification with id " + input.getId() + " is not exist!");
        }
        notificationRepository.save(input);
    }

    public void deleteById(Long id) {
        Optional<Notification> deletedProduct = notificationRepository.findById(id);
        if (deletedProduct.isPresent()){
            notificationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Delete entity. Notification with id " + id + " is not exist!");
        }
    }
}
