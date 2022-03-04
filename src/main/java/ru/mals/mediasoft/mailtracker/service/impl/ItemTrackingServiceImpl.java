package ru.mals.mediasoft.mailtracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mals.mediasoft.mailtracker.dto.TrackingCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingDTO;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.entity.ItemTracking;
import ru.mals.mediasoft.mailtracker.entity.PostOffice;
import ru.mals.mediasoft.mailtracker.exteptions.NotFoundException;
import ru.mals.mediasoft.mailtracker.repository.ItemRepository;
import ru.mals.mediasoft.mailtracker.repository.ItemTrackingRepository;
import ru.mals.mediasoft.mailtracker.repository.PostOfficeRepository;
import ru.mals.mediasoft.mailtracker.service.ItemTrackingService;
import ru.mals.mediasoft.mailtracker.service.factory.ItemTrackingFactory;
import ru.mals.mediasoft.mailtracker.service.mapper.ItemTrackingMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemTrackingServiceImpl implements ItemTrackingService {

    private final ItemRepository itemRepository;
    private final ItemTrackingFactory itemTrackingFactory;
    private final PostOfficeRepository postOfficeRepository;
    private final ItemTrackingRepository itemTrackingRepository;
    private final ItemTrackingMapper itemTrackingMapper;

    @Transactional
    @Override
    public void createItemTracking(TrackingCreateDTO trackingCreateDTO) {
        Item item = itemRepository.findByIdentifier(trackingCreateDTO.getItemIdentifier()).orElseThrow(
                () ->new NotFoundException("Item cannot be found for item identifier: " + trackingCreateDTO.getItemIdentifier())
        );
        PostOffice postOffice = postOfficeRepository.findByName(trackingCreateDTO.getPostOfficeName()).orElseThrow(
                () -> new NotFoundException("Post office cannot for post office name: " + trackingCreateDTO.getPostOfficeName())
        );
        ItemTracking itemTracking = itemTrackingFactory.build(item, postOffice, trackingCreateDTO.getStatus());
        itemTrackingRepository.saveAndFlush(itemTracking);
    }

    @Override
    public List<TrackingDTO> getItemTrackingHistory(String itemIdentifier) {
        Item item = itemRepository.findByIdentifier(itemIdentifier).orElseThrow(
                () ->new NotFoundException("Item cannot be found for item identifier: " + itemIdentifier)
        );
        List<ItemTracking> itemTrackingList = itemTrackingRepository.findAllByItemOrderByCreatedDateStatus(item);
        return itemTrackingMapper.mapItemTrackingToItemTracingDTO(itemTrackingList);
    }
}
