package helpers;

import java.util.Base64;

import static configuration.Configuration.USER_EMAIL;
import static configuration.Configuration.USER_PASSWORD;

public class BasicAuthHelper {

    public static String GenerateAuth(String email, String pwd) {
        String userCredential = USER_EMAIL + ":" + USER_PASSWORD;
        return "Basic " + new String(Base64.getEncoder().encode(userCredential.getBytes()));
    }
}
