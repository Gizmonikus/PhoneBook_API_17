package dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//{
//        "token": "string"
//        }
@Setter
@Getter
@Builder
@ToString

public class AuthResponseDTO {
    String token;
}