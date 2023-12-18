package ee.mainor.MoEuasPersonalProjectChatbox;

import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import ee.mainor.MoEuasPersonalProjectChatbox.mapper.ChatMessageMapper;
import ee.mainor.MoEuasPersonalProjectChatbox.model.ChatMessage;
import ee.mainor.MoEuasPersonalProjectChatbox.repository.ChatMessageRepository;
import ee.mainor.MoEuasPersonalProjectChatbox.service.ChatMessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MoEuasPersonalProjectChatboxApplicationTests {

	@Mock
	private ChatMessageRepository chatMessageRepository;

	@InjectMocks
	private ChatMessageService chatMessageService;

	@Test
	public void testSendMessage() {
		// Mock behavior for ChatMessageMapper
		ChatMessageDTO messageDto = new ChatMessageDTO(/* Set properties */);
		ChatMessage chatMessageEntity = new ChatMessage(/* Set properties */);

		when(ChatMessageMapper.toChatMessageEntity(messageDto)).thenReturn(chatMessageEntity);

		// Call the method being tested
		ChatMessageDTO result = chatMessageService.sendMessage(messageDto);

		// Add assertions here to verify the behavior of the service method
		// For example:
		assertNotNull(result);
		// Add more assertions based on your expected behavior
	}
}
