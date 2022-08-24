package Pages;

import Base.Setup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PurchasePage {
    @FindBy(id = "search_query_top")
    WebElement txtSearchItem;

    @FindBy(xpath = "//p[contains(text(),'No results were found for your search \"dess\"')]")
    WebElement lblInvalidProduct;
    @FindBy(name = "submit_search")
    WebElement submitSearchbtn;

    @FindBy(className = "heading-counter")
    WebElement lblResult;
    @FindBy(tagName = "img")
    List<WebElement> img;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement btnAddCart;

   @FindBy(xpath ="//span[contains(text(),'Printed Dress')]")
    WebElement lblAddToCart;

    @FindBy(css = "[title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    @FindBy(className = "page-heading")
    WebElement lblSummaryPage;
    @FindBy(css = "[title='Proceed to checkout']")
    List<WebElement> secProceedtoCheckoutbtn;

    @FindBy(xpath = "//h1[contains(text(),'Addresses')]")
    WebElement lblAddress;
    @FindBy(name = "processAddress")
    WebElement processAddress;

    @FindBy(xpath = "//h1[contains(text(),'Shipping')]")
    WebElement lblShipping;
    @FindBy(id = "cgv")
    WebElement checkbox;

    @FindBy(className= "checked")
    List<WebElement> checkboxChecked;
    @FindBy(name = "processCarrier")
    WebElement processCarrierButton;

    @FindBy(xpath = "//h1[contains(text(),'Please choose your payment method')]")
    WebElement lblPaymentMethodHeading;

    @FindBy(xpath = "//h1[contains(text(),'Order summary')]")
    WebElement lblOrderSummary;
    @FindBy(css = "[title='Pay by check.']")
    WebElement paymentByCheck;
    @FindBy(css = "[type='submit']")
    List<WebElement> confirmationBtn;

    @FindBy (xpath = "//p[contains(text(),'Your order on My Store is complete.')]")
    WebElement confirmationMsg;
    WebDriver driver;
    public PurchasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    /*public String searchInvalidProduct(String product){
        txtSearchItem.sendKeys(product);
        submitSearchbtn.click();
        return lblInvalidProduct.getText();

    }*/
    public String searchProduct(String product){
        /*Actions actions=new Actions(Setup.driver);
        actions.moveToElement(txtSearchItem).doubleClick().sendKeys(Keys.BACK_SPACE);*/
        txtSearchItem.sendKeys(product);
        submitSearchbtn.click();
        return lblResult.getText();

    }
    public Boolean chooseProduct(){
        img.get(14).click();
        return btnAddCart.isDisplayed();
    }
   /* public boolean addToCart(){
        btnAddCart.click();
        return proceedToCheckoutButton.isDisplayed();
    }*/

    public String addToCart(){
        btnAddCart.click();
       return lblAddToCart.getText();
    }
    public String checkProductSumary(){
        proceedToCheckoutButton.click();
        return lblSummaryPage.getText();

    }
    public boolean secProceedtoCheckout(){
        secProceedtoCheckoutbtn.get(1).click();
        return lblAddress.isDisplayed();

    }

    public boolean checkShippingOption(){
        processAddress.click();
        return lblShipping.isDisplayed();

    }

    public boolean clickOnTermsCheck(){
        checkbox.click();
        return checkboxChecked.get(1).isDisplayed();

    }
    public boolean thirdProceedToCheckout(){
        processCarrierButton.click();
        return lblPaymentMethodHeading.isDisplayed();

    }

    public boolean PaymentMethod(){
        paymentByCheck.click();
        return lblOrderSummary.isDisplayed();

    }

    public boolean ConfirmingOrder(){
        confirmationBtn.get(1).click();
        return confirmationMsg.isDisplayed();

    }


    /*public void orderProduct()
    {
       /* txtSearchItem.sendKeys("dress");
        submitSearchbtn.click();
        txtSearchItem.sendKeys("dress");
        submitSearchbtn.click();
        img.get(14).click();
        addCartButton.get(1).click();
        proceedToCheckoutButton.click();
        secProceedtoCheckoutbtn.get(1).click();//
        processAddress.click();
        checkbox.click();
        processCarrierButton.click();
        paymentByCheck.click();
        confirmationBtn.click();


    }
    */


}
