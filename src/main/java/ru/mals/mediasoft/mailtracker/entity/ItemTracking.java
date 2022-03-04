package ru.mals.mediasoft.mailtracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mals.mediasoft.mailtracker.entity.enums.TrackingStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_tracking")
@Data
@NoArgsConstructor
public class ItemTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private PostOffice postOffice;

    @Column(nullable = false)
    private TrackingStatus status;

    @Column(updatable = false)
    private LocalDateTime createdDateStatus;

    public ItemTracking(Item item, PostOffice postOffice, TrackingStatus status) {
        this.item = item;
        this.postOffice = postOffice;
        this.status = status;
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdDateStatus = LocalDateTime.now();
    }

}
