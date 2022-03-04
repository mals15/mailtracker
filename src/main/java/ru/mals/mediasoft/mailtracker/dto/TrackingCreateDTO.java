package ru.mals.mediasoft.mailtracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.mals.mediasoft.mailtracker.entity.enums.TrackingStatus;

@Getter
public class TrackingCreateDTO {

    private final String itemIdentifier;
    private final String postOfficeName;
    private final TrackingStatus status;

    public TrackingCreateDTO(@JsonProperty("itemIdentifier") String identifier,
                             @JsonProperty("postOfficeName") String name,
                             @JsonProperty("status") TrackingStatus status) {
        this.itemIdentifier = identifier;
        this.postOfficeName = name;
        this.status = status;
    }



}
