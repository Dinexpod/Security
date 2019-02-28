package mate.academy.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mate.academy.spring.model.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationInput {
    private String email;
    private String username;
    private String name;
    private String lastName;
    private String password;

    public User toUser() {
        return User.builder()
                .email(email)
                .username(username)
                .name(name)
                .lastName(lastName)
                .password(password)
                .build();
    }
}
