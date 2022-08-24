package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignupPage {
    @FindBy(id = "email_create")
    WebElement txtRegEmail;

    @FindBy(xpath = "//li[contains(text(),'Invalid email address.')]")
    WebElement lblErrorMsg;

    @FindBy(xpath = "//li[contains(text(),'An account using this email address has already been registered. Please enter a valid password or request a new one. ')]")
    WebElement lblErrorAuthMsg;

    @FindBy(xpath = "//li[contains(text(),' is invalid.')]")
    List<WebElement> lblErrorMsgLastname;

    @FindBy(xpath = "//li[contains(text(),' is invalid.')]")
    List<WebElement> lblErrorMsgFirstname;

    @FindBy(xpath = "//li[contains(text(),' is invalid.')]")
    List<WebElement> lblErrorMsgPassword;

    @FindBy(xpath = "//li[contains(text(),' is invalid.')]")
    List<WebElement> lblErrorMsgZipCode;

    @FindBy(xpath = "//li[contains(text(),'The Zip/Postal code you've entered is invalid. It must follow this format: 00000')]")
    WebElement lblErrorMsgBlankPostCode;

    @FindBy(xpath = "//li[contains(text(),'You must register at least one phone number.')]")
    WebElement lblErrorMsgPhnNo;

    @FindBy(xpath = "//li[contains(text(),' is required.')]")
    List<WebElement> lblErrorMsgAddress1;

    @FindBy(xpath = "//li[contains(text(),' is required.')]")
    List<WebElement> lblErrorMsgCity;

    @FindBy(xpath="//li[contains(text(),'Country is invalid')]")
    WebElement lblErrorMsgCountry;

    @FindBy(xpath = "//li[contains(text(),'This country requires you to choose a State.')]")
    WebElement lblErrorMsgState;

    @FindBy(xpath = "//li[contains(text(),' is required.')]")
    List<WebElement> lblErrorMsgAlias;
    @FindBy(id="SubmitCreate")
    WebElement btnSignup;
    @FindBy(id="id_gender2")
    WebElement rb1;
    @FindBy(id="customer_firstname")
    WebElement txtFirstName;
    @FindBy(id="customer_lastname")
    WebElement txtLastName;
    @FindBy(id="passwd")
    WebElement txtPassWord;
    @FindBy(id="days")
    WebElement cbDays;
    @FindBy(id="months")
    WebElement cbMonths;
    @FindBy(id="years")
    WebElement cbYears;
    @FindBy(id="address1")
    WebElement txtAddress1;
    @FindBy(id="city")
    WebElement txtCity;
    @FindBy(id="id_state")
    WebElement cbState;
    @FindBy(id="postcode")
    WebElement txtPostCode;
    @FindBy(id="id_country")
    WebElement cbCountry;
    @FindBy(id="phone_mobile")
    WebElement txtMobile;
    @FindBy(id="alias")
    WebElement txtReferenceAddress;
    @FindBy(id="submitAccount")
    WebElement btnRegister;

    WebDriver driver;
    public  SignupPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void doRegistration(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        Thread.sleep(1000);
    }


    public String doSignupWithInvalidEmail(String email)  {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        String errorMsg=lblErrorMsg.getText();
        return  errorMsg;

    }

    public String doSignupWithAlreadyUsedEmail(String email) {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        String errorMsg=lblErrorAuthMsg.getText();
        return  errorMsg;

    }

   /* public String doSignupWithInvalidFirstname(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("1234");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgFirstname.get(1).getText();
        return errorMsg;


    }

    public String doSignupWithInvalidLastname(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(2000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("1234");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgLastname.get(0).getText();
        return errorMsg;

    }
    public String doSignupWithInvalidPassword(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(2000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgPassword.get(2).getText();
        return errorMsg;
    }
    public String doSignupWithInvalidAddress(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(2000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgAddress1.get(1).getText();
        return errorMsg;
    }
    public String doSignupWithInvalidCity(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgCity.get(2).getText();
        return errorMsg;
    }
    public String doSignupWithInvalidState(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(2000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgState.getText();
        return errorMsg;
    }
    public String doSignupWithInvalidPostcode(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("7520");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgZipCode.get(3).getText();
        return errorMsg;
    }


    public String doSignupWithInvalidCountry(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgCountry.getText();
        return errorMsg;
    }
*/
    public String doSignupWithInvalidPhnno(String email,String password,String mobile) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtPassWord.sendKeys(password);
        Select days=new Select(cbDays);
        days.selectByValue("1");
        Select months=new Select(cbMonths);
        months.selectByValue("1");
        Select years=new Select(cbYears);
        years.selectByValue("2000");
        txtAddress1.sendKeys("1 Wasington Road, Newyork");
        txtCity.sendKeys("Newyork");
        Select state=new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("75201");
        Select country=new Select(cbCountry);
        country.selectByValue("21");
        txtMobile.sendKeys(mobile);
        txtReferenceAddress.sendKeys("Dallas");
        btnRegister.click();
        String errorMsg=lblErrorMsgPhnNo.getText();
        return errorMsg;
    }

}
