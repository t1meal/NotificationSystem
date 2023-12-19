package ru.fcahp.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fcahp.system.common.NotificationStatus;
import ru.fcahp.system.entity.Notification;
import ru.fcahp.system.repository.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Specification<Notification> createSpecByFilter(NotificationStatus searchString) {
        Specification<Notification> spec = Specification.where(null);
        if (searchString != null) {
            spec = spec.and(
                    ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(searchString.toString()), searchString))
            );
//            spec = spec.or(
//                    ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("status"), String.format("%%%s%%", searchString)))
//            );
        }
        return spec;
    }

    public Page<Notification> getAll(NotificationStatus searchString, int pageIndex, int pageSize) {
        return notificationRepository.findAll(
                createSpecByFilter(searchString),
                PageRequest.of(pageIndex - 1, pageSize));
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
