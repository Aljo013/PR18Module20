package pages;

import helper.Endpoint;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;


public class ApiPage {

    String setURL, global_id;

    Response res;
    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = Endpoint.DELETE_USERS;
                break;
            case "UPDATE_USERS":
                setURL = Endpoint.UPDATE_USERS;
                break;
            default:
        }
    }

    public void hitApiGetUser(){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitApiGetUserById(){
        res = getListUsersById(setURL, "6801402");
        System.out.println(res.getBody().asString());
    }

    public void validateStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validateResponseBodyGetDataUser(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validateResponseBodyGetDataUserById(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void validateResponseJsonWithJSONSchema(String Filename){
        File JSONFile = Utility.getJsonSchemaFile(Filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitApiCreatePostNewUser(){
        res = postCreateNewUsers(setURL);
        System.out.println(res.getBody().asString());
    }

    public void hitApiDeleteUser(){
        res = deleteUsers(setURL, global_id);
    }

    public void hitApiUpdateUser(){
        res = updateUsers(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void hitApiGetUnavailableUser(){
        res = getListUsersById(setURL, global_id);
        System.out.println(res.getBody().asString());
    }

    public void hitApiCreatePostInappropriateUser(){
        res = postCreateInappropriateUsers(setURL);
        System.out.println(res.getBody().asString());
    }
}
