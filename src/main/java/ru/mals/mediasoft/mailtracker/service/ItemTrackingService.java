package ru.mals.mediasoft.mailtracker.service;

import ru.mals.mediasoft.mailtracker.dto.TrackingCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingDTO;

import java.util.List;

public interface ItemTrackingService {

    void createItemTracking(TrackingCreateDTO trackingDTO);
    List<TrackingDTO> getItemTrackingHistory(String itemIdentifier);
}
