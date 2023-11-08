package ee.mainor.MoEuasPersonalProjectChatbox.dto;

import ee.mainor.MoEuasPersonalProjectChatbox.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "CHAT_MESSAGES")
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    // Constructors, getters, and setters
}
