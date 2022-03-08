package ru.mals.mediasoft.mailtracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mals.mediasoft.mailtracker.entity.enums.ItemType;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(nullable = false)
    private ItemType type;

    @Column(nullable = false)
    private long recipientIndex;

    @Column(nullable = false)
    private String recipientAddress;

    @Column(nullable = false)
    private String recipientName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_tracking",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "post_office_id")
            )
    private List<PostOffice> history;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    public Item(String identifier, ItemType type, long recipientIndex, String recipientAddress, String recipientName) {
        this.identifier = identifier;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}
