package ru.mals.mediasoft.mailtracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post_offices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @Column(nullable = false, unique = true)
    private long index;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_tracking",
            joinColumns = @JoinColumn(name = "post_office_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> item;

}
