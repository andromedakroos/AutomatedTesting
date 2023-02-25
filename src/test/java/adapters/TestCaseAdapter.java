package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.TestCase;
import models.TestCasesToMove;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestCaseAdapter extends BaseAdapter {
    public TestCase add(TestCase testCase) {
        return given()
                .pathParam("section_id", testCase.getSectionId())
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase get(int caseId) {
        return given()
                .pathParam("case_id", caseId)
                .when()
                .get(Endpoints.GET_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class, ObjectMapperType.GSON);
    }

    public TestCase update(TestCase testCase) {
        return given()
                .pathParam("case_id", testCase.getId())
                .body(testCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(TestCase.class, ObjectMapperType.GSON);
    }

    public void move(TestCasesToMove testCasesToMove) {
        given()
                .pathParam("section_id", ReadProperties.getMoveToSelectId())
                .body(gson.toJson(testCasesToMove))
                .when()
                .post(Endpoints.MOVE_TESTCASES)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void delete(int caseId) {
        given()
                .pathParam("case_id", caseId)
                .when()
                .post(Endpoints.DELETE_TESTCASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}