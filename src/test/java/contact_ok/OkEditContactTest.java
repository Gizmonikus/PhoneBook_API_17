package contact_ok;

//34fc50de-f65f-456a-b933-1f19cdcc1538
//        john1358@mail.com
//0556667771358

import com.google.gson.Gson;
import dto.ContactDto;
import dto.ResponseMessageDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkEditContactTest {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYm9iaW5zYW4yMEB5YW5kZXgucnUiLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY3NTc4NjE5NiwiaWF0IjoxNjc1MTg2MTk2fQ.-S9ws5wht6-gb6ifCMZdX3lFs6mYSZMqte3W7XWHFhE";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    ContactDto contact = ContactDto.builder()
            .id("34fc50de-f65f-456a-b933-1f19cdcc1538")
            .name("John1358")
            .lastName("Edited")
            .email("john1358@mail.com")
            .phone("0556667771358")
            .address("Haifa, Herzel, 1358")
            .description("friend")

            .build();

    @Test
    public void editById() throws IOException {
        RequestBody requestBody = RequestBody.create(gson.toJson(contact), JSON);


        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/")
                .addHeader("Authorization", token)
                .put(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDto messageDto = gson.fromJson(response.body().string(), ResponseMessageDto.class);
        String message = messageDto.getMessage();
        System.out.println(message);
    }
}


