package api.gratitude.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class GratitudeMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Sender name cannot be empty")
    @Size(max = 100, message = "Sender name cannot be longer than 100 characters")
    private String senderName;

    @NotEmpty(message = "Message content cannot be empty")
    @Size(max = 500, message = "Message content cannot be longer than 500 characters")
    private String messageContent;

    @NotNull(message = "Date created cannot be null")
    private LocalDateTime dateCreated;

    private int popularityScore = 0;
}
