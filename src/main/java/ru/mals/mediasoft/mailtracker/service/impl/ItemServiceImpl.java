package ru.mals.mediasoft.mailtracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mals.mediasoft.mailtracker.dto.ItemCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.ItemDTO;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.repository.ItemRepository;
import ru.mals.mediasoft.mailtracker.service.ItemService;
import ru.mals.mediasoft.mailtracker.service.factory.ItemFactory;
import ru.mals.mediasoft.mailtracker.service.mapper.ItemMapper;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemFactory itemFactory;
    private final ItemMapper itemMapper;

    @Transactional
    @Override
    public ItemDTO createItem(ItemCreateDTO itemCreateDTO) {

//        if(itemRepository.existsItemByIdentifier(itemCreateDTO.getIdentifier())) {
//
//        }

        Item item = itemFactory.build(
                itemCreateDTO.getIdentifier(),
                itemCreateDTO.getType(),
                itemCreateDTO.getRecipientIndex(),
                itemCreateDTO.getRecipientAddress(),
                itemCreateDTO.getRecipientName());

        itemRepository.saveAndFlush(item);
        return  itemMapper.mapItemToItemDTO(item);

    }
}
