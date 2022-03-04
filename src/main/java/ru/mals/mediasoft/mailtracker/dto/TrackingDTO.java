package ru.mals.mediasoft.mailtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.mals.mediasoft.mailtracker.entity.enums.TrackingStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TrackingDTO {

    private final long id;
    private final String itemIdentifier;
    private final String postOfficeName;
    private final TrackingStatus status;
    private final LocalDateTime createdDateStatus;
}
