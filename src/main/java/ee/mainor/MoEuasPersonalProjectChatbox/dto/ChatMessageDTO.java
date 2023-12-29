package ee.mainor.MoEuasPersonalProjectChatbox.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {
    //private Long id;
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime timestamp;



    // Constructors and other methods, if needed
}
