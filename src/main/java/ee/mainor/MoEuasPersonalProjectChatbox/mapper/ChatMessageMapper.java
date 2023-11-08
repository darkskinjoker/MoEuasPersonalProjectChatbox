package ee.mainor.MoEuasPersonalProjectChatbox.mapper;

import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageMapper {

    public ChatMessageDTO toChatMessageDto(ChatMessage chatMessage) {
        ChatMessageDTO dto = new ChatMessageDTO();
        dto.setSenderId(chatMessage.getSenderId());
        dto.setReceiverId(chatMessage.getReceiverId());
        dto.setMessage(chatMessage.getMessage());
        dto.setTimestamp(chatMessage.getTimestamp());
        return dto;
    }

    public ChatMessage toChatMessageEntity(ChatMessageDTO dto) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSenderId(dto.getSenderId());
        chatMessage.setReceiverId(dto.getReceiverId());
        chatMessage.setMessage(dto.getMessage());
        chatMessage.setTimestamp(dto.getTimestamp());
        return chatMessage;
    }
}
