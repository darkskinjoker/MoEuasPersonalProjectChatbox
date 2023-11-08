package ee.mainor.MoEuasPersonalProjectChatbox.model;

import ee.mainor.MoEuasPersonalProjectChatbox.dto.ChatMessage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USERLIST")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String username;
    private String email;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<ChatMessage> receivedMessages;

    // Constructors, getters, and setters
}