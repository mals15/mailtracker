package ru.mals.mediasoft.mailtracker.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mals.mediasoft.mailtracker.dto.ItemCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingCreateDTO;
import ru.mals.mediasoft.mailtracker.dto.TrackingDTO;

import java.util.List;

@Tag(name = "Tracking controller", description = "Tracking controller description")
@RequestMapping("/tracking")
public interface TrackingController {

    @Operation(
            summary = "Add tracking item",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            description = "Allows you to create a item"
    )
    @PostMapping("/create")
    ResponseEntity<Object> addItemTracking(
            @RequestBody @Parameter(description = "TrackingCreateDTO", required = true) TrackingCreateDTO trackingCreateDTO);

    @Operation(
            summary = "Finding item history",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Bad request")
            },
            description = "Allows you to find item history"
    )
    @GetMapping("/{itemIdentifier}")
    ResponseEntity<List<TrackingDTO>> getItemTrackingHistory(
            @PathVariable(value = "itemIdentifier") String itemIdentifier);

}
