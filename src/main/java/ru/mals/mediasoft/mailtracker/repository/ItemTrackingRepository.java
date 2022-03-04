package ru.mals.mediasoft.mailtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.entity.ItemTracking;

import java.util.List;

@Repository
public interface ItemTrackingRepository extends JpaRepository<ItemTracking, Long> {

    List<ItemTracking> findAllByItemOrderByCreatedDateStatus(Item item);
}
