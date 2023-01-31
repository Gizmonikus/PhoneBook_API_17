package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "username": "string",
//        "password": "Rs: ^eTyV3UZcq)V[Q;m8#U"
//        }
@Setter
@Getter
@Builder
@ToString

public class AuthRequestDTO {
    String username;
    String password;
}
