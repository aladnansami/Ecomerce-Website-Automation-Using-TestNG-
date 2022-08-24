package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utils;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

public class LoginTestRunner  {


    Setup setup=new Setup();
    LoginPage loginPage;
    Utils utils;
    @Test(priority=4,description = "User can login with valid username and password")
    public void doLoginWithValidCred () throws IOException, ParseException, InterruptedException {
        //driver.get("http://automationpractice.com/");
        utils=new Utils();
        utils.readUserCredentials(utils.getUserCount());
        loginPage=new LoginPage(setup.driver);
        boolean isLogoutFound= loginPage.doLoginWithValidCred(utils.getEmail(), utils.getPassword());
        //Thread.sleep(1000);
        Assert.assertEquals(isLogoutFound,true);
        //loginPage.linkLogout.click();
        Allure.description("User can successfully login in the website with valid username and password");

    }

    @Test(priority = 3, description = "User can not login with invalid username and password")
    public void doLoginWithInvalidCredBoth () throws IOException, ParseException {

        utils=new Utils();
        utils.readUserCredentials(2);
        loginPage=new LoginPage(setup.driver);
        String validationMessage= loginPage.doLoginWithInvalidCredUsername(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Invalid email address."));
        Allure.description("User can not login in the website with invalid username and password");

    }

    @Test(priority = 2,description = "User can not login with invalid username")
    public void doLoginWithInvalidCredUsername () throws IOException, ParseException {

        utils=new Utils();
        utils.readUserCredentials(1);
        loginPage=new LoginPage(setup.driver);
        String validationMessage= loginPage.doLoginWithInvalidCredUsername(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("Invalid email address."));
        Allure.description("User can not login in the website with invalid username");

    }
    @Test(priority = 1,description = "User can not login with invalid password")
    public void doLoginWithInvalidCredPassword () throws IOException, ParseException {

        utils=new Utils();
        utils.readUserCredentials(0);
        loginPage=new LoginPage(setup.driver);
        String validationMessage= loginPage.doLoginWithInvalidCred(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(validationMessage.contains("failed."));
        Allure.description("User can not login in the website with invalid password");

    }
}
