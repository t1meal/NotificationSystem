package ru.fcahp.system.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fcahp.system.entity.Notification;
import ru.fcahp.system.repository.NotificationRepository;
import ru.fcahp.system.repository.specification.NotificationSpecification;

import java.util.Optional;
@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Page<Notification> getAll(String searchString, int pageIndex, int pageSize) {
        return notificationRepository.findAll(
                NotificationSpecification.createSpecByFilter(searchString),
                PageRequest.of(pageIndex - 1, pageSize));
    }

    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification id: " + id + " not found"));
    }

    public void create(Notification input) {
        notificationRepository.save(input);
    }

    @Transactional
    public void update(Notification input) {
        Optional<Notification> entity = notificationRepository.findById(input.getId());
        if (entity.isPresent()) {
            notificationRepository.save(input);
        } else {
            throw new ResourceNotFoundException("Update entity. Notification with id " + input.getId() + " is not exist!");
        }
    }

    public void deleteById(Long id) {
        Optional<Notification> deletedProduct = notificationRepository.findById(id);
        if (deletedProduct.isPresent()) {
            notificationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Delete entity. Notification with id " + id + " is not exist!");
        }
    }
}
