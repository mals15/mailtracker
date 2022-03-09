package ru.mals.mediasoft.mailtracker.service.mapper;

import org.springframework.stereotype.Component;
import ru.mals.mediasoft.mailtracker.dto.ItemDTO;
import ru.mals.mediasoft.mailtracker.entity.Item;

@Component
public class ItemMapper {

    public ItemDTO mapItemToItemDTO(Item item) {
        return new ItemDTO(
                item.getId(),
                item.getIdentifier(),
                item.getType(),
                item.getRecipientIndex(),
                item.getRecipientAddress(),
                item.getRecipientName(),
                item.getCreatedDate());
    }
}
