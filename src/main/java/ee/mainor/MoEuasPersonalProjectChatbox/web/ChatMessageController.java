package ee.mainor.MoEuasPersonalProjectChatbox.web;
import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessageDTO;
import ee.mainor.MoEuasPersonalProjectChatbox.service.ChatMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("chat")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @GetMapping("history") // Define the complete path for the endpoint
    public List<ChatMessageDTO> getChatHistory(
            @RequestParam("senderId") String senderId,
            @RequestParam("receiverId") String receiverId) {
        return chatMessageService.getChatHistory(senderId, receiverId);
    }

    @GetMapping("{id}")
    public ChatMessageDTO getMessageById(@PathVariable Long id) {
        return chatMessageService.getMessageById(id);
    }

    @GetMapping("all")
    public List<ChatMessageDTO> getAllMessages() {
        return chatMessageService.getAllMessages();
    }

    @PostMapping("send")
    public ChatMessageDTO sendMessage(@Valid @RequestBody ChatMessageDTO messageDto) {
        return chatMessageService.sendMessage(messageDto);
    }

    @PutMapping("{id}")
    public ChatMessageDTO updateMessage(@PathVariable Long id, @Valid @RequestBody ChatMessageDTO messageDto) {
        return chatMessageService.updateMessage(id, messageDto);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable Long id) {
        chatMessageService.deleteMessage(id);
    }
}
