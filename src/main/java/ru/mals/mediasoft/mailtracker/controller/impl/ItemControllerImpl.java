package ru.mals.mediasoft.mailtracker.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mals.mediasoft.mailtracker.controller.ItemController;
import ru.mals.mediasoft.mailtracker.dto.ItemCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.ItemDTO;
import ru.mals.mediasoft.mailtracker.service.ItemService;

@RestController
@RequiredArgsConstructor

public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @Override
    public ResponseEntity<Object> create(ItemCreateDTO itemCreateDTO) {
        ItemDTO itemDto = itemService.createItem(itemCreateDTO);
        return new ResponseEntity<>(itemDto, HttpStatus.OK);
    }
}
