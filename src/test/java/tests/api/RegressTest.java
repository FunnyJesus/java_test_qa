package tests.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

class RegressTest {

    private final static String URL = "https://reqres.in";

    @Test
    void checkAvatar() {
        List<UserData>  users = given().
                when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.stream().forEach(x -> assertThat(x.getAvatar()).contains(x.getId().toString()));

        assertThat(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in"))).isTrue();
    }
}
