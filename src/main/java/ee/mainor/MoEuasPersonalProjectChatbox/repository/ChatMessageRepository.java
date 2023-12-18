package ee.mainor.MoEuasPersonalProjectChatbox.repository;

import ee.mainor.MoEuasPersonalProjectChatbox.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndReceiverId(String senderId, String receiverId);
}
