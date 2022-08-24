package TestRunner;

import Utils.Utils;
import Base.Setup;
import Pages.LoginPage;
import Pages.SignupPage;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.IOException;

public class SignupTestRunner extends Setup {


    @Test(priority = 1,description ="User can not sign up into the website using wrong email format" )
    public void doSignupWithInvalidEmail() throws InterruptedException, IOException, ParseException {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.linkLogin.click();
            SignupPage signupPage = new SignupPage(driver);
            Utils utils = new Utils();
            utils.readUserCredentials(2);
            String validationMessage=signupPage.doSignupWithInvalidEmail(utils.getEmail());
            Assert.assertTrue(validationMessage.contains("Invalid email address."));
            Allure.description("User can not signup into the website by providing invalid email");



    }

    @Test(priority = 2,description ="User can not sign up into the website using the previous signed up email" )
    public void doSignupWithAlreadyUsedEmail() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        utils.readUserCredentials(5);
        String validationMessage=signupPage.doSignupWithAlreadyUsedEmail(utils.getEmail());
        Assert.assertTrue(validationMessage.contains("An account using this email address has already been registered. Please enter a valid password or request a new one."));
        Allure.description("User can not signup into the website by providing an already used email");



    }


  //@Test(priority = 3,description ="User can not sign up into the website using Invalid firstname format " )
     /* public void doSignupWithInvalidFirstname() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidFirstname(email, password, mobile);
        //Thread.sleep(1000);
        Assert.assertTrue(validationMessage.contains("firstname is required."));
        Allure.description("User can not signup into the website by providing invalid firstname");



    }

    @Test(priority = 4,description ="User can not sign up into the website using invalid lastname" )
    public void doSignupWithInvalidLastname() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidLastname(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("lastname is required."));
        Allure.description("User can not signup into the website by providing an invalid lastname");



    }

    @Test(priority = 5,description ="User can not sign up into the website using invalid password" )
    public void doSignupWithInvalidPassword() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidPassword(email,"1234", mobile);
        Assert.assertTrue(validationMessage.contains("passwd is invalid."));
        Allure.description("User can not signup into the website by providing an invalid password");



    }
    @Test(priority = 6,description ="User can not sign up into the website keeping address filed blank" )
    public void doSignupWithInvalidAddress() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidAddress(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("address1 is required."));
        Allure.description("User can not signup into the website by keeping address filed blank");



    }

    @Test(priority = 7,description ="User can not sign up into the website keeping city filed blank" )
    public void doSignupWithInvalidCity() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidCity(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("city is required."));
        Allure.description("User can not signup into the website by keeping city filed blank");



    }
    @Test(priority = 8,description ="User can not sign up into the website using invalid space in the state field" )
    public void doSignupWithInvalidState() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage= signupPage.doSignupWithInvalidState(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("This country requires you to choose a State."));
        Allure.description("User can not signup into the website by using invalid space in the state field");



    }
    @Test(priority = 9,description ="User can not sign up into the website by keeping the postal code field blank" )
    public void doSignupWithInvalidPostcode() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage= signupPage.doSignupWithInvalidPostcode(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
        Allure.description("User can not signup into the website by keeping the postal code field blank");



    }

    @Test(priority = 10,description ="User can not sign up into the website without selecting country" )
    public void doSignupWithInvalidCountry() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
        String validationMessage=signupPage.doSignupWithInvalidCountry(email, password, mobile);
        Assert.assertTrue(validationMessage.contains("Country is invalid"));
        Allure.description("User can not signup into the website without selecting country");



    }*/
    @Test(priority = 3,description ="User can not sign up into the website keeping the phone no field blank" )
    public void doSignupWithInvalidPhnno() throws InterruptedException, IOException, ParseException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        int emailUserAccount = utils.generateRandomNumber(9999, 1000);
        String email = "testautouser" + emailUserAccount + "@gmail.com";
        String password = utils.generateRandomPassword(8);
        String validationMessage=signupPage.doSignupWithInvalidPhnno(email, password,"");
        Assert.assertTrue(validationMessage.contains("You must register at least one phone number."));
        Allure.description("User can not signup into the website keeping the phone no field blank");



    }





    int count = 1;
    @Test(priority = 4, description = "User can sign up successfully")
    public void signup() throws InterruptedException, IOException, ParseException {
        while (count <= 2) {
           // driver.get("http://automationpractice.com/");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.linkLogin.click();
            SignupPage signupPage = new SignupPage(driver);
            Utils utils = new Utils();
            int emailUserAccount = utils.generateRandomNumber(9999, 1000);
            String email = "testautouser" + emailUserAccount + "@gmail.com";
            String password = utils.generateRandomPassword(8);
            String mobile = "175" + utils.generateRandomNumber(9999999, 1000000);
            signupPage.doRegistration(email, password, mobile);
            utils.writeUserInfo(email, password);
            //Thread.sleep(1000);
            loginPage.linkLogout.click();
            Allure.description("User can signup in the website by providing all necessary information");
            //Thread.sleep(1000);
            count++;

        }

    }

}
