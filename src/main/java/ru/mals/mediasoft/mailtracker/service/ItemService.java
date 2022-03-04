package ru.mals.mediasoft.mailtracker.service;

import ru.mals.mediasoft.mailtracker.dto.ItemCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.ItemDTO;

public interface ItemService {

    ItemDTO createItem(ItemCreateDTO itemCreateDTO);

}
