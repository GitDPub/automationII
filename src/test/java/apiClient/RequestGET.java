package apiClient;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestGET implements  IRequest {
    @Override
    public Response send(String url) {

        Response response = given()
                            .when()
                            .get(url);
        return response;
    }
}
