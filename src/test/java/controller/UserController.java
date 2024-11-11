package controller;

import config.UserModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class UserController {
    Properties prop;
    public UserController(Properties prop){

        this.prop=prop;
        RestAssured.baseURI=prop.getProperty("baseUrl");
    }

    public Response login(){
        return given().contentType("application/json")
                .body("{\n" +
                        "    \"email\":\"admin@roadtocareer.net\",\n" +
                        "    \"password\":\"1234\"\n" +
                        "}").when().post("/user/login");
    }


    public Response createUser(UserModel userModel){
        return given().contentType("application/json")

                .header("Authorization","bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey"))
                .body(userModel)
                .when().post("/user/create");
    }



}
