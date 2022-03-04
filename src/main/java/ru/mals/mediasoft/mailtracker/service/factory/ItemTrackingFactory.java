package ru.mals.mediasoft.mailtracker.service.factory;

import org.springframework.stereotype.Component;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.entity.ItemTracking;
import ru.mals.mediasoft.mailtracker.entity.PostOffice;
import ru.mals.mediasoft.mailtracker.entity.enums.TrackingStatus;

@Component
public class ItemTrackingFactory {

    public ItemTracking build(Item item, PostOffice postOffice, TrackingStatus status) {
        return new ItemTracking(item, postOffice, status);
    }
}
