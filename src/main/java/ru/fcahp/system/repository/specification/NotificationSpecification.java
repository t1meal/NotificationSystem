package ru.fcahp.system.repository.specification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import ru.fcahp.system.common.NotificationStatus;
import ru.fcahp.system.entity.Notification;
import ru.fcahp.system.entity.ProductPackage;
@Slf4j
public class NotificationSpecification {
    public static Specification<Notification> createSpecByFilter(String searchString) {
        Specification<Notification> spec = Specification.where(null);
        if (searchString != null) {
            spec = spec.and(
                    ((root, query, criteriaBuilder) ->
                            criteriaBuilder.like(
                                    root.get(Notification.Fields.productPackages)
                                            .get(ProductPackage.Fields.caption), String.format("%%%s%%", searchString))
                    )
            );
            try {
                NotificationStatus status = NotificationStatus.fromCaption(searchString);
                spec = spec.or(
                        ((root, query, criteriaBuilder) -> criteriaBuilder.equal(
                                root.get(Notification.Fields.status), status))
                );
            } catch (IllegalArgumentException e){
                log.warn("Unknown status name {}", searchString);
            }
        }
        return spec;
    }
}
