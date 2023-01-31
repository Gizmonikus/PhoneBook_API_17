package contact_ok;

import com.google.gson.Gson;
import dto.ContactDto;
import dto.GetAllContactsDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkGetAllContacts {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYm9iaW5zYW4yMEB5YW5kZXgucnUiLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTY3NTc4NjE5NiwiaWF0IjoxNjc1MTg2MTk2fQ.-S9ws5wht6-gb6ifCMZdX3lFs6mYSZMqte3W7XWHFhE";

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    @Test
    public void getAllContacts() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts")
                .addHeader("Authorization", token)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());

        GetAllContactsDto contacts = gson.fromJson(response.body().string(), GetAllContactsDto.class);
        for(ContactDto contactDto : contacts.getContacts()){
            System.out.println(contactDto.getId());
            System.out.println(contactDto.getEmail());
            System.out.println(contactDto.getPhone());
            System.out.println("==========================");
        }


    }

}
