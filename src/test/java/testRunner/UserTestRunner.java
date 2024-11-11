package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import controller.UserController;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner extends Setup {

        @Test(priority = 1,description = "user login")
        public void login() throws ConfigurationException {
        UserController userController = new UserController(prop);
        Response res = userController.login();
        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token");
        System.out.println(token);

        Utils.setEnvVariable("token",token);

    }

        @Test(priority = 2,description = "create Customer 1")
        public void createUser() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker =new Faker();

        String name = faker.name().firstName();
        String email =faker.internet().emailAddress().toLowerCase();
        String password = "1234";
        String phoneNumber = "01644"+ Utils.generateRandomId(100000,999999);
        String nid ="121232324242";
        String role ="Customer";

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);


        Response res = userController.createUser(userModel);
        System.out.println(res.asString());

      //  JsonPath jsonPath = res.jsonPath();

        //save users to users.json
        JSONObject userObj = new JSONObject();

        userObj.put("name",name);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        userObj.put("nid",nid);
        userObj.put("role",role);

        Utils.saveUsers("./src/test/resources/users.json", userObj);



    }

        @Test(priority = 3,description = "create Customer 2")
        public void createUser2() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker =new Faker();

        String name = faker.name().firstName();
        String email =faker.internet().emailAddress().toLowerCase();
        String password = "1234";
        String phoneNumber = "01644"+ Utils.generateRandomId(100000,999999);
        String nid ="121232324242";
        String role ="Customer";

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);


        Response res = userController.createUser(userModel);
        System.out.println(res.asString());


        JSONObject userObj = new JSONObject();

        userObj.put("name",name);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        userObj.put("nid",nid);
        userObj.put("role",role);

        Utils.saveUsers("./src/test/resources/users.json", userObj);



    }

        @Test(priority = 4,description = "create Agent")
        public void createUser3() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker =new Faker();

        String name = faker.name().firstName();
        String email =faker.internet().emailAddress().toLowerCase();
        String password = "1234";
        String phoneNumber = "01644"+ Utils.generateRandomId(100000,999999);
        String nid ="121232324242";
        String role ="Agent";

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phoneNumber);
        userModel.setNid(nid);
        userModel.setRole(role);


        Response res = userController.createUser(userModel);
        System.out.println(res.asString());


        //save users to users.json
        JSONObject userObj = new JSONObject();

        userObj.put("name",name);
        userObj.put("email",email);
        userObj.put("password",password);
        userObj.put("phoneNumber",phoneNumber);
        userObj.put("nid",nid);
        userObj.put("role",role);

        Utils.saveUsers("./src/test/resources/users.json", userObj);



    }
}
