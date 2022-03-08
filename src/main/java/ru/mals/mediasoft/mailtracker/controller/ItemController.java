package ru.mals.mediasoft.mailtracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mals.mediasoft.mailtracker.dto.ItemCreateDTO;

@Tag(name = "Items controller", description = "Item controller description")
@RequestMapping("/items")
public interface ItemController {

    @Operation(
            summary = "Creating item",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            description = "Allows you to create a item"
    )
    @PostMapping("/create")
    ResponseEntity<Object> createItem(
            @RequestBody @Parameter(description = "ItemCreateDTO", required = true) ItemCreateDTO itemCreateDTO);
}
