package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apipage;

    public ApiStep() {
        this.apipage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apipage.prepareUrlFor(url);
    }

    @And("hit api get user")
    public void hitApiGetUser() {
        apipage.hitApiGetUser();
    }

    @Then("validate status code is equals {int}")
    public void validateStatusCodeIsEquals(int status_code) {
        apipage.validateStatusCodeIsEquals(status_code);
    }

    @Then("validate response body get data user")
    public void validateResponseBodyGetDataUser() {
        apipage.validateResponseBodyGetDataUser();
    }

    @And("hit api get user by id")
    public void hitApiGetUserById() {
        apipage.hitApiGetUserById();
    }


    @Then("validate response body get data user by id")
    public void validateResponseBodyGetDataUserById() {
        apipage.validateResponseBodyGetDataUserById();
    }

    @Then("validate response json with JSONSchema {string}")
    public void validateResponseJsonWithJSONSchema(String Filename) {
        apipage.validateResponseJsonWithJSONSchema(Filename);
    }


    @And("hit api create post new user")
    public void hitApiCreatePostNewUser() {
        apipage.hitApiCreatePostNewUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apipage.hitApiDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apipage.hitApiUpdateUser();
    }

    @And("hit api get unavailable user")
    public void hitApiGetUnavailableUser() {
        apipage.hitApiGetUnavailableUser();
    }


    @And("hit api create post inappropriate user")
    public void hitApiCreatePostInappropriateUser() {
        apipage.hitApiCreatePostInappropriateUser();
    }
}
