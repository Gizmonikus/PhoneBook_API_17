package contact_ok;
//8db96892-b22c-4bd1-83b3-de3c56686917
//        john919@mail.com
//055666777919

import com.google.gson.Gson;
import dto.ResponseMessageDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkDeleteById {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYm9iaW5zYW4yMEB5YW5kZXgucnUiLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY3NTc4NjE5NiwiaWF0IjoxNjc1MTg2MTk2fQ.-S9ws5wht6-gb6ifCMZdX3lFs6mYSZMqte3W7XWHFhE";
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();


    String id = "8db96892-b22c-4bd1-83b3-de3c56686917";

    @Test
    public void deliteById() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/" + id)
                .addHeader("Authorization", token)
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        ResponseMessageDto messageDto = gson.fromJson(response.body().string(), ResponseMessageDto.class);
        String message = messageDto.getMessage();
        System.out.println(message);
    }
}
