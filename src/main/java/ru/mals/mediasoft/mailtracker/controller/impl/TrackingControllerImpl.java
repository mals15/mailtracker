package ru.mals.mediasoft.mailtracker.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mals.mediasoft.mailtracker.controller.TrackingController;
import ru.mals.mediasoft.mailtracker.dto.TrackingCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingDTO;
import ru.mals.mediasoft.mailtracker.service.ItemTrackingService;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class TrackingControllerImpl implements TrackingController {

    private final ItemTrackingService itemTrackingService;

    @Override
    public ResponseEntity<Object> addItemTracking(TrackingCreateDTO trackingCreateDTO) {
        itemTrackingService.createItemTracking(trackingCreateDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TrackingDTO>> getItemTrackingHistory(String itemIdentifier) {
        List<TrackingDTO> trackingDTOList = itemTrackingService.getItemTrackingHistory(itemIdentifier);
        return ResponseEntity.ok(trackingDTOList);

    }
}
