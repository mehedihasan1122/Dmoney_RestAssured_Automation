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

    @Test(priority = 1, description = "Transaction 2000tk From System to agent")

    public void depositFromSystemToAgent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.depositFromSystemToAgent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Deposit successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }
    @Test(priority = 2,description = "Deposit 1500 tk to a customer from the agent account")
    public void depositAgentToCustomer1() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.depositAgentToCustomer1();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Deposit successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 3,description = " Withdraw 500 tk by the customer to the agent")
    public void withdrawCustomer1ToAgent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.withDrawCustomer1toAgent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Withdraw successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 4,description = "Send money 500 tk to another customer")
    public void sendMoneyCustomer1ToCustomer2() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.sendMoneyCustomer1ToCustomer2();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Send money successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }

    @Test(priority = 5,description = "Payment 100 tk to any merchant by the recipient customer")
    public void paymentCustomer2ToMarchent() throws IOException, ParseException {

        TransactionController transactionController = new TransactionController(prop);
        Response res= transactionController.paymentToAnMarchent();

        System.out.println(res.asString());

        JsonPath jsonPath = res.jsonPath();
        String messageActual = jsonPath.get("message");
        String messageexpected ="Payment successful";
        Assert.assertTrue(messageActual.contains(messageexpected));
    }


    @Test(priority = 6, description = "Check balance of the recipient customer")
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
