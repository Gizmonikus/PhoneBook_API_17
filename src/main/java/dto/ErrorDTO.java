package dto;

//{
//        "timestamp": "2023-01-31T16:19:20.744Z",
//        "status": 0,
//        "error": "string",
//        "message": {},
//        "path": "string"
//        }

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ErrorDTO {

    int status;
    String error;
    String message;


}
