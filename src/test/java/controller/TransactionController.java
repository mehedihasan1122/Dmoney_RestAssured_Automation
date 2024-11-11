package controller;

import config.TransactionModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TransactionController {
    Properties prop;

    public TransactionController(Properties prop){
        this.prop = prop;
        RestAssured.baseURI=prop.getProperty("baseUrl");

    }

    public Response depositFromSystemToAgent() throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        //get Agent info
        JSONObject userObj = (JSONObject) jsonArray.get(2);
        String agentNumber =(String) userObj.get("phoneNumber");
        System.out.println(agentNumber);
        int amount = 2000;

        TransactionModel transactionModel = new TransactionModel("SYSTEM",agentNumber,amount);

        return given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().post("/transaction/deposit");

    }


    public Response depositAgentToCustomer1() throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        //get Agent info
        JSONObject userObj = (JSONObject) jsonArray.get(2);
        String agentNumber =(String) userObj.get("phoneNumber");
        System.out.println(agentNumber);


        JSONObject userObj2 = (JSONObject) jsonArray.get(1);
        String Customer1 =(String) userObj2.get("phoneNumber");
        System.out.println(Customer1);





        int amount = 1500;

        TransactionModel transactionModel = new TransactionModel(agentNumber,Customer1,amount);

        return given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().post("/transaction/deposit");

    }


    public Response withDrawCustomer1toAgent() throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        //get Agent info
        JSONObject userObj = (JSONObject) jsonArray.get(2);
        String agentNumber =(String) userObj.get("phoneNumber");
        System.out.println(agentNumber);


        JSONObject userObj2 = (JSONObject) jsonArray.get(1);
        String Customer1 =(String) userObj2.get("phoneNumber");
        System.out.println(Customer1);

        int amount = 500;

        TransactionModel transactionModel = new TransactionModel(Customer1,agentNumber,amount);

        return given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().post("/transaction/withdraw");

    }



    public Response sendMoneyCustomer1ToCustomer2() throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        //get Agent info
        JSONObject userObj = (JSONObject) jsonArray.get(0);
        String customer2 =(String) userObj.get("phoneNumber");
        System.out.println(customer2);


        JSONObject userObj2 = (JSONObject) jsonArray.get(1);
        String Customer1 =(String) userObj2.get("phoneNumber");
        System.out.println(Customer1);

        int amount = 500;

        TransactionModel transactionModel = new TransactionModel(Customer1,customer2,amount);

        return given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().post("/transaction/sendmoney");

    }


    public Response paymentToAnMarchent() throws IOException, ParseException{

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        //get Agent info
        JSONObject userObj = (JSONObject) jsonArray.get(0);
        String customer2 =(String) userObj.get("phoneNumber");
        System.out.println(customer2);


        String merchantAccount = "01999583382";

        int amount = 100;

        TransactionModel transactionModel = new TransactionModel(customer2,merchantAccount,amount);

        return given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().post("/transaction/payment");

    }


    public Response checkCustomer2Balance() throws IOException, ParseException, InterruptedException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject userObj = (JSONObject) jsonArray.get(0);
        String customer2 =(String) userObj.get("phoneNumber");

        return given().contentType("application/json")
                .header("Authorization", "bearer "+prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY",prop.getProperty("secretKey")).when().get("/transaction/balance/"+customer2);

    }









}
