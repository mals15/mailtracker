package ru.mals.mediasoft.mailtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mals.mediasoft.mailtracker.entity.PostOffice;
import java.util.Optional;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

    Optional<PostOffice> findByName(String postOfficeName);
}
