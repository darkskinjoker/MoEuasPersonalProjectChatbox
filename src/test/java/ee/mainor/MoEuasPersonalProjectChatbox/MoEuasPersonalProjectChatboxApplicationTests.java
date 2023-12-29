package ee.mainor.MoEuasPersonalProjectChatbox;

import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import ee.mainor.MoEuasPersonalProjectChatbox.mapper.ChatMessageMapper;
import ee.mainor.MoEuasPersonalProjectChatbox.model.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.repository.ChatMessageRepository;
import ee.mainor.MoEuasPersonalProjectChatbox.service.ChatMessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MoEuasPersonalProjectChatboxApplicationTests {

	@Mock
	private ChatMessageRepository chatMessageRepository;

	@Autowired // Inject ChatMessageMapper
	private ChatMessageMapper chatMessageMapper;

	@InjectMocks
	private ChatMessageService chatMessageService;

	@Test
	public void testSendMessage() {
		// Create a message DTO to be sent
		ChatMessageDTO messageDto = new ChatMessageDTO();
		messageDto.setSenderId("senderId");
		messageDto.setReceiverId("receiverId");
		messageDto.setMessage("Hello!");
		messageDto.setTimestamp(LocalDateTime.now());

		// Mock behavior for ChatMessageMapper to convert DTO to Entity
		ChatMessage chatMessageEntity = new ChatMessage();
		chatMessageEntity.setId(1L);
		chatMessageEntity.setSenderId(messageDto.getSenderId());
		chatMessageEntity.setReceiverId(messageDto.getReceiverId());
		chatMessageEntity.setMessage(messageDto.getMessage());
		chatMessageEntity.setTimestamp(messageDto.getTimestamp());

		when(chatMessageMapper.toChatMessageEntity(messageDto)).thenReturn(chatMessageEntity);

		// Mock behavior for chatMessageRepository's save method
		when(chatMessageRepository.save(chatMessageEntity)).thenReturn(chatMessageEntity);

		// Call the sendMessage method
		ChatMessageDTO result = chatMessageService.sendMessage(messageDto);

		// Validate that the returned DTO matches the sent message DTO
		assertNotNull(result);
		assertEquals(messageDto.getSenderId(), result.getSenderId());
		assertEquals(messageDto.getReceiverId(), result.getReceiverId());
		assertEquals(messageDto.getMessage(), result.getMessage());
		// add more assertions
	}
}
