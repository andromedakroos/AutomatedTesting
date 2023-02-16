package tests.api;

import baseEntities.BaseApiGSONTest;
import baseEntities.BaseApiTest;
import com.google.common.reflect.TypeToken;
import configuration.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.*;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestRailApiTest2 extends BaseApiGSONTest {
    @Test
    public void getUser(){
        int userId = 1;
        String endpoint = "index.php?/api/v2/get_user/{user_id}";
        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .role("Lead")
                .roleId(1)
                .build();

        User actualUser = given()
                .pathParam("user_id", userId)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class, ObjectMapperType.GSON);
        System.out.println(actualUser);
        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser1(){
        int userId = 1;
        String endpoint = "index.php?/api/v2/get_user/{user_id}";
        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(true)
                .role("Lead")
                .roleId(1)
                .build();

        Response response = given()
                .pathParam("user_id", userId)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        User actualUser = gson.fromJson(response.getBody().asPrettyString(), User.class);
        System.out.println(actualUser);
//        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getUser2(){
        int userId = 1;
        String endpoint = "index.php?/api/v2/get_user/{user_id}";
        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko@gmail.com")
                .isActive(true)
                .isAdmin(false)
                .role("Lead")
                .roleId(1)
                .build();

        User actualUser = given()
                .pathParam("user_id", userId)
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);
        System.out.println(actualUser);
        System.out.println(expectedUser);
        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test
    public void getAllUsers2(){
        String endpoint = "/index.php?api/v2/get_users";
       Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        User[] actualUserList = gson.fromJson(response.getBody().asPrettyString(), User[].class);
        System.out.println(actualUserList.length);
        System.out.println(actualUserList[0]);
        System.out.println(actualUserList[1]);
    }

    @Test
    public void getAllUsers3(){
        String endpoint = "/index.php?api/v2/get_users";
        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();

        List<User> actualUserList = actualUserList = gson.fromJson(response.getBody().asPrettyString(), listType);

//        User[] actualUserList = gson.fromJson(response.getBody().asPrettyString(), User[].class);
        System.out.println(actualUserList.size());
        System.out.println(actualUserList.get(0));
        System.out.println(actualUserList.get(1));
    }
}
