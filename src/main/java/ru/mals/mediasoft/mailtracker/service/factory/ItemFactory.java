package ru.mals.mediasoft.mailtracker.service.factory;

import org.springframework.stereotype.Component;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.entity.enums.ItemType;

@Component
public class ItemFactory {
    public Item build(String identifier, ItemType type, long recipientIndex, String recipientAddress, String recipientName) {
        return new Item(identifier, type, recipientIndex, recipientAddress, recipientName);
    }
}

