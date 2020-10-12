package apiClient;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RequestPOST implements  IRequest {
    @Override
    public Response send(String url) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response;
    }
}
