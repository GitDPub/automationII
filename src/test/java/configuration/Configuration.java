package configuration;

public class Configuration {
    public static final String HOST = "https://todo.ly/";
    // BASIC_AUTHENTICATION que solia usarse ahora se genera a partir de USER_EMAIL y USER_PASSWORD
    // La clase BasicAuthHelper con el metodo GenerateAuth(USER_EMAIL, USER_PASSWORD)
    public static final String USER_EMAIL = "publicpracticas@gmail.com";
    public static final String USER_PASSWORD = "123todo";
    public static final String BASIC_AUTHENTICATION_HEADER = "Authorization";
    public static final String TOKEN_AUTHENTICATION_HEADER = "Token";
}
