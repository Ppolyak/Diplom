package models;

import lombok.Builder;
import lombok.Data;
import org.testng.annotations.DataProvider;

@Data
@Builder
public class User {

    private String email;
    private String password;


}
