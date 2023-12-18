package ee.mainor.MoEuasPersonalProjectChatbox.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime timestamp;

    public Long getId;


    // Constructors and other methods, if needed
}
