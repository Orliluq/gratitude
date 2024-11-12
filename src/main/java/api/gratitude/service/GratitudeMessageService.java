package api.gratitude.service;

import api.gratitude.model.GratitudeMessage;
import api.gratitude.repository.GratitudeMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.gratitude.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class GratitudeMessageService {

    private final GratitudeMessageRepository repository;

    @Autowired
    public GratitudeMessageService(GratitudeMessageRepository repository) {
        this.repository = repository;
    }

    public GratitudeMessage createMessage(GratitudeMessage message) {
        message.setDateCreated(LocalDateTime.now());
        return repository.save(message);
    }

    public List<GratitudeMessage> getAllMessages(String order, String direction) {
        List<GratitudeMessage> messages = repository.findAll();
        if ("popularity".equalsIgnoreCase(order)) {
            messages.sort(Comparator.comparingInt(GratitudeMessage::getPopularityScore).reversed());
        } else {
            if ("desc".equalsIgnoreCase(direction)) {
                messages.sort(Comparator.comparing(GratitudeMessage::getDateCreated).reversed());
            } else {
                messages.sort(Comparator.comparing(GratitudeMessage::getDateCreated));
            }
        }
        return messages;
    }

    public void deleteMessage(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Message not found");
        }
        repository.deleteById(id);
    }
}