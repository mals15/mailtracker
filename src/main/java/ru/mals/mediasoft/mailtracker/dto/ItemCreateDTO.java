package ru.mals.mediasoft.mailtracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.mals.mediasoft.mailtracker.entity.enums.ItemType;

@Getter
public class ItemCreateDTO {

    private final String identifier;
    private final ItemType type;
    private final long recipientIndex;
    private final String recipientAddress;
    private final String recipientName;

    public ItemCreateDTO(@JsonProperty("identifier") String identifier,
                         @JsonProperty("type") ItemType type,
                         @JsonProperty("recipientIndex") long recipientIndex,
                         @JsonProperty("recipientAddress") String recipientAddress,
                         @JsonProperty("recipientName") String recipientName) {
        this.identifier = identifier;
        this.type = type;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }
}
