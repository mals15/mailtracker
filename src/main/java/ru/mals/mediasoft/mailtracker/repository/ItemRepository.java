package ru.mals.mediasoft.mailtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mals.mediasoft.mailtracker.entity.Item;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsItemByIdentifier(String ident);
    Optional<Item> findByIdentifier(String identifier);


}
