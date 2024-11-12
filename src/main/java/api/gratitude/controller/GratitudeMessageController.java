package api.gratitude.controller;

import api.gratitude.model.GratitudeMessage;
import api.gratitude.service.GratitudeMessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@Tag(name = "Gratitude Messages", description = "API for managing gratitude messages")
public class GratitudeMessageController {

    private final GratitudeMessageService service;

    public GratitudeMessageController(GratitudeMessageService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new gratitude message")
    public ResponseEntity<GratitudeMessage> createMessage(@Valid @RequestBody GratitudeMessage message) {
        return ResponseEntity.ok(service.createMessage(message));
    }

    @GetMapping
    @Operation(summary = "List all gratitude messages")
    public ResponseEntity<List<GratitudeMessage>> getAllMessages(
            @RequestParam(required = false, defaultValue = "date") String order,
            @RequestParam(required = false, defaultValue = "asc") String direction) {
        return ResponseEntity.ok(service.getAllMessages(order, direction));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a gratitude message by ID")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        service.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}