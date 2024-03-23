Feature: Test Automation Rest Api

    @api
    Scenario: Test get list data users normal
        Given prepare url for "GET_LIST_USERS"
        And hit api get user
        Then validate status code is equals 200
        Then validate response body get data user
        Then validate response json with JSONSchema "get_list_users_normal.json"

    @api
    Scenario: Test get list data users by id
        Given prepare url for "GET_LIST_USERS"
        And hit api get user by id
        Then validate status code is equals 200
        Then validate response body get data user by id


    @api
    Scenario: Test create post new users
        Given prepare url for "CREATE_NEW_USERS"
        And hit api create post new user
        Then validate status code is equals 201
        Then validate response body get data user by id
        Then validate response json with JSONSchema "post_create_new_users_normal.json"

    @api
    Scenario: Test delete users
        Given prepare url for "DELETE_USERS"
        And hit api create post new user
        Then validate status code is equals 201
        Then validate response body get data user by id
        And hit api delete user
        Then validate status code is equals 204

    @api
    Scenario: Test update users
        Given prepare url for "UPDATE_USERS"
        And hit api create post new user
        Then validate status code is equals 201
        Then validate response body get data user by id
        And hit api update user
        Then validate status code is equals 200
        Then validate response body get data user by id

    @api
    Scenario: Test get unavailable users
        Given prepare url for "CREATE_NEW_USERS"
        And hit api create post new user
        Then validate status code is equals 201
        Then validate response body get data user by id
        And hit api delete user
        Then validate status code is equals 204
        And hit api get unavailable user
        Then validate status code is equals 404

    @api
    Scenario: Test create post inappropriate users
        Given prepare url for "CREATE_NEW_USERS"
        And hit api create post inappropriate user
        Then validate status code is equals 422
