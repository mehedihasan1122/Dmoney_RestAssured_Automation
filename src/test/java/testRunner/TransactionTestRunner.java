package testRunner;

import config.Setup;
import controller.TransactionController;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransactionTestRunner extends Setup {

    @Test(priority = 1, description = "Transaction 2000tk From System to agent ")

    public void depositFromSystemToAgent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.depositFromSystemToAgent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Deposit successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }
    @Test(priority = 2,description = "deposit 1500tk Agent to Customer 1")
    public void depositAgentToCustomer1() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.depositAgentToCustomer1();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Deposit successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 3,description = "deposit 1500tk Agent to Customer 1")
    public void withdrawCustomer1ToAgent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.withDrawCustomer1toAgent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Withdraw successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 4,description = "deposit 1500tk Agent to Customer 1")
    public void sendMoneyCustomer1ToCustomer2() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.sendMoneyCustomer1ToCustomer2();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Send money successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }

    @Test(priority = 5,description = "deposit 1500tk Agent to Customer 1")
    public void paymentCustomer2ToMarchent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.paymentToAnMarchent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Payment successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 6, description = "Check customer balance")
    public void checkCustomerBalance() throws IOException, ParseException, InterruptedException {
        TransactionController transactionController = new TransactionController(prop);
        Response res = transactionController.checkCustomer2Balance();
        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="User balance";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }
    @AfterMethod
    public void delay() throws InterruptedException {
        Thread.sleep(2000);
    }













}
