package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(className ="login")
    public
    WebElement linkLogin;
    @FindBy (id="email")
    WebElement txtEmail;
    @FindBy(id="passwd")
    WebElement txtPassword;
    @FindBy(id="SubmitLogin")
    WebElement btnSubmit;
    @FindBy(className = "logout")
    public
    WebElement linkLogout;

    @FindBy (xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement lblAuthError;

    @FindBy (xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement lblAuthErrorAnother;
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;

        //static_class_pagefactory
        PageFactory.initElements(driver,this);
    }

    public boolean doLoginWithValidCred(String email,String password)
    {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return linkLogout.isDisplayed();
    }
    public String doLoginWithInvalidCred(String email,String password)
    {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblAuthError.getText();
    }
    public String doLoginWithInvalidCredUsername(String email,String password)
    {
        linkLogin.click();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return lblAuthErrorAnother.getText();
    }
}
