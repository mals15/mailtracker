package ru.mals.mediasoft.mailtracker.service.mapper;

import org.springframework.stereotype.Component;
import ru.mals.mediasoft.mailtracker.dto.TrackingCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingDTO;
import ru.mals.mediasoft.mailtracker.entity.ItemTracking;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemTrackingMapper {

    public TrackingDTO mapItemTrackingToItemTracingDTO(ItemTracking model) {
        return new TrackingDTO(
                model.getId(),
                model.getItem().getIdentifier(),
                model.getPostOffice().getName(),
                model.getStatus(),
                model.getCreatedDateStatus()
        );
    }

    public List<TrackingDTO> mapItemTrackingToItemTracingDTO(Collection<ItemTracking> model) {
        return model.stream()
                .map(this::mapItemTrackingToItemTracingDTO)
                .collect(Collectors.toList());
    }
}
