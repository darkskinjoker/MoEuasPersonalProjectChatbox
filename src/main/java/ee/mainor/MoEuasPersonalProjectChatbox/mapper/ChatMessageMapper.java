package ee.mainor.MoEuasPersonalProjectChatbox.mapper;

import ee.mainor.MoEuasPersonalProjectChatbox.model.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ChatMessageDTO> toChatMessageDtoList(List<ChatMessage> chatMessages) {
        return chatMessages.stream()
                .map(this::toChatMessageDto)
                .collect(Collectors.toList());
    }

    public List<ChatMessage> toChatMessageEntityList(List<ChatMessageDTO> dtos) {
        return dtos.stream()
                .map(this::toChatMessageEntity)
                .collect(Collectors.toList());
    }
}
