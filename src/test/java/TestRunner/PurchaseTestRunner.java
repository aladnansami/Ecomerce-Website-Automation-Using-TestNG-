package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Pages.PurchasePage;
import Utils.Utils;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;

//public class OrderTestRunner extends Setup {
    public class PurchaseTestRunner {


    Setup setup=new Setup();
    Utils utils;
    LoginPage loginPage;

    PurchasePage orderPage;

   /* @Test(priority = 1,description = "User can not search invalid product")
    public void searchInvalidProduct() {

        orderPage=new PurchasePage(setup.driver);
        String res= orderPage.searchInvalidProduct("dess");
        Assert.assertTrue(res.contains("No results were found for your search "));
        Allure.description("User can not search invalid product");
    }*/
    @Test(priority = 1,description = "User can search product")
    public void searchProduct() {

        orderPage=new PurchasePage(setup.driver);
        String res= orderPage.searchProduct("dress");
        Assert.assertTrue(res.contains("results have been found"));
        Allure.description("User can search product successfully");
    }
    @Test(priority = 2, description = "User can choose product")
    public void chooseProduct(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.chooseProduct();
        Assert.assertTrue(found);
         Allure.description("User can choose product from the product list");
    }
    @Test(priority = 3, description = "User can add cart successfully")
    public void addToCart(){
        orderPage=new PurchasePage(setup.driver);
        Allure.description("User added the product into card");

        String found= orderPage.addToCart();
        Assert.assertTrue(found.contains("Printed Dress"));
    }
    @Test(priority = 4, description = "User can see product summary")
    public void checkProductSumary(){
        orderPage=new PurchasePage(setup.driver);
        String summaryText= orderPage.checkProductSumary();
        Assert.assertTrue(summaryText.contains("SHOPPING-CART SUMMARY"));
        Allure.description("User can view product summary before checkout");
    }

    @Test(priority = 5, description = "User is able to checkout from the summary page")
    public void checkDeliveryAddress(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.secProceedtoCheckout();
        Assert.assertTrue(found);
         Allure.description("User checkout from product summary");
    }

    @Test(priority = 6, description = "User is able to checkout from the summary page")
    public void checkShippingOption(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.checkShippingOption();
        Assert.assertTrue(found);
         Allure.description("User checkout from product summary");
    }

    @Test(priority = 7,description = "User is able to checkout from the summary page")
    public void acceptingTermsAndServices(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.clickOnTermsCheck();
        Assert.assertTrue(found);
         Allure.description("User checkout from product summary");
    }

    @Test(priority = 8, description = "User is able to checkout from the summary page")
    public void doneWithShipping(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.thirdProceedToCheckout();
        Assert.assertTrue(found);
        Allure.description("User checkout from product summary");
    }


    @Test(priority = 9,description = "User is able to checkout from the summary page")
    public void doneWithPayment(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.PaymentMethod();
        Assert.assertTrue(found);
        Allure.description("User checkout from product summary");
    }

    @Test(priority = 10,description = "User is able to checkout from the summary page")
    public void doneWithOrder(){
        orderPage=new PurchasePage(setup.driver);
        boolean found= orderPage.ConfirmingOrder();
        Assert.assertTrue(found);
        Allure.description("User checkout from product summary");
    }


}
