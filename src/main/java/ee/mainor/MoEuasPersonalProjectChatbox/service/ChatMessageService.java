package ee.mainor.MoEuasPersonalProjectChatbox.service;

import ee.mainor.MoEuasPersonalProjectChatbox.model.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import ee.mainor.MoEuasPersonalProjectChatbox.mapper.ChatMessageMapper;
import ee.mainor.MoEuasPersonalProjectChatbox.repository.ChatMessageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatMessageMapper chatMessageMapper;

    public List<ChatMessage> getChatHistory(String senderId, String receiverId) {
        return chatMessageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    public ChatMessageDTO sendMessage(ChatMessageDTO messageDto) {
        ChatMessage message = chatMessageRepository.save(chatMessageMapper.toChatMessageEntity(messageDto));
        return chatMessageMapper.toChatMessageDto(message);
    }

    public List<ChatMessageDTO> getAllMessages() {
        List<ChatMessage> messages = (List<ChatMessage>) chatMessageRepository.findAll();
        return chatMessageMapper.toChatMessageDtoList(messages);
    }

    public ChatMessageDTO getMessageById(Long messageId) {
        ChatMessage message = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new EntityNotFoundException("Message not found with id: " + messageId));
        return chatMessageMapper.toChatMessageDto(message);
    }

    public ChatMessageDTO updateMessage(Long messageId, ChatMessageDTO messageDto) {
        // Check if the message with the given ID exists
        ChatMessage existingMessage = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new EntityNotFoundException("Message not found with id: " + messageId));

        // Update the existing message
        ChatMessage updatedMessage = chatMessageMapper.toChatMessageEntity(messageDto);
        updatedMessage.setId(messageId); // Set the ID to ensure update instead of insert
        chatMessageRepository.save(updatedMessage);

        return chatMessageMapper.toChatMessageDto(updatedMessage);
    }

    public void deleteMessage(Long messageId) {
        chatMessageRepository.deleteById(messageId);
    }
}
