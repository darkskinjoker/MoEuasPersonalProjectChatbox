package ee.mainor.MoEuasPersonalProjectChatbox.service;

import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import ee.mainor.MoEuasPersonalProjectChatbox.mapper.ChatMessageMapper;
import ee.mainor.MoEuasPersonalProjectChatbox.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ChatMessageService {
    @Service
    @Transactional
    @RequiredArgsConstructor
    public static class ChatMessageServiceLayer {

        private final ChatMessageRepository chatMessageRepository;
        private final ChatMessageMapper chatMessageMapper;

        public List<ChatMessage> getChatHistory(String senderId, String receiverId) {
            return chatMessageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        }

        public ChatMessageDTO sendMessage(ChatMessageDTO messageDto) {
            ChatMessage message = chatMessageRepository.save(chatMessageMapper.toChatMessageEntity(messageDto));
            return chatMessageMapper.toChatMessageDto(message);
        }

    }
}
