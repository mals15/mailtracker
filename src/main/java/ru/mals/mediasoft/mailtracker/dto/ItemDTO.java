package ru.mals.mediasoft.mailtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.mals.mediasoft.mailtracker.entity.enums.ItemType;

@Getter
@AllArgsConstructor
public class ItemDTO {

    private final long id;
    private final String identifier;
    private final ItemType type;
    private final long recipientIndex;
    private final String recipientAddress;
    private final String recipientName;

}
