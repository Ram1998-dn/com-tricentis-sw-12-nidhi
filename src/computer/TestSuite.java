package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //  Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));

        // Click on the Desktop
        clickOnElement(By.linkText("Desktops"));

        //  Select Sort By option "Name: Z to A"
        selectFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on the COMPUTERS Menu.
        clickOnElement(By.xpath("(//a[normalize-space()='Computers'])[1]"));

        // 2.2 Click on the Desktop
        clickOnElement(By.linkText("Desktops"));

        // 2.3 Select Sort By option "Name: A to Z"
        selectFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");

        // 2.4 Click on the "Add To Cart" button of the product name ‘Build your own computer’
        clickOnElement(By.partialLinkText("Build your own computer"));

        // 2.5 Verify the Text "Build your own computer"
        assertMethod("Build your own computer",By.tagName("h1"));

        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        WebElement dropdownForProcessor = driver.findElement(By.xpath("(//select[@id='product_attribute_16_6_5'])[1]"));
        Select select1 = new Select(dropdownForProcessor);
        select1.selectByIndex(2);

        // 2.8 Select HDD radio button "400 GB [+$100.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_3_6_19'])[1]"));

        // 2.9 Select the OS radio button "Windows 10 [+$60.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_4_7_21'])[1]"));

        // 2.10 Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("(//input[@id='product_attribute_16_8_8_24'])[1]"));

        // 2.11 Verify the price "1200.00"
        assertMethod("1200.00",By.xpath("(//span[@class='price-value-16'])[1]") );

        // 2.12 Click on the "Add to card" Button
        clickOnElement(By.id("add-to-cart-button-16"));

        // 2.13 Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        assertMethod("The product has been added to your shopping cart",By.xpath("//p[@class='content']"));

        // 2.14 After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        // 2.15 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseToElement(By.xpath("//span[normalize-space()='Shopping cart']"));
        clickOnElement(By.xpath("//input[@value='Go to cart']"));

        // 2.16 Verify the message "Shopping cart"
        assertMethod("Shopping cart", By.xpath("(//h1[normalize-space()='Shopping cart'])[1]"));

        Thread.sleep(2000);
        // 2.17 Change the Qty to "2" and Click on "Update shopping cart"

        WebElement qty = driver.findElement(By.cssSelector(".qty-input"));
        qty.clear();
        qty.sendKeys("2");
        driver.findElement(By.name("updatecart")).click();

        // 2.18 Verify the Total "2,950.00"
        Thread.sleep(2000);
        assertMethod("2980.00", By.xpath("//span[@class='product-subtotal']"));

        //  2.19 click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  2.20 Click on “Checkout”
        clickOnElement(By.id("checkout"));

        // 2.21 Verify the Text “Welcome, Please Sign In!”
        assertMethod("Welcome, Please Sign In!", By.tagName("h1"));

        // 2.22 Click on the “Checkout as Guest” Tab
        clickOnElement(By.xpath("//input[@value='Checkout as Guest']"));

        // 2.23 Enter the First name
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Prashant");

        //  2.24 Enter the Last name
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Patel");

        // 2.25 Enter the email
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("patel123@gmail.com");

        // 2.26 Select the Country “United Kingdom” using the select class
        selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");

        // 2.27 Enter the city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");

        //  2.28 Enter the Address1
        driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])[1]")).sendKeys("Oxford Street");

        // 2.29 Enter the Zip/Postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("NA1 2AB");

        //  2.30 Enter the Phone number
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("079876543");

        // 2.31 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        // 2.32 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        // 2.33 Click on the Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //  2.34 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])[1]"));

        // 2.35 Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("(//input[@id='paymentmethod_2'])[1]"));

        // 2.36 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-method-next-step-button'])[1]"));

        // 2.37 Select “Master card” From the Select credit card dropdown using the Select class
        selectFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");

        // 2.38 Enter the Cardholder's name
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Prashant P");

        // 2.39 Enter the Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("567583940349293");

        // 2.40 Select the Expiration date using the select class
        selectFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "08");
        selectFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2029");

        // 2.41 Enter the Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("325");

        // 2.42 Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]"));

        // 2.43 Verify “Payment Method” is “Credit Card
        assertMethod("Credit Card", By.xpath("//li[@class='payment-method']"));

        // 2.44 Verify “Shipping Method” is “Next Day Air”
        assertMethod("Next Day Air", By.xpath("//li[@class='shipping-method']"));

        // 2.45 Verify Total is “2,950.0
        assertMethod("2980.00", By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'2980.00')]"));

        // 2.46 Click on the “Confirm” button
        clickOnElement(By.xpath("//input[@value='Confirm']"));

        // 2.47 Verify the Text “Thank You”
        assertMethod("Thank you", By.xpath("//h1[normalize-space()='Thank you']"));

        //  2.48 Verify the message “Your order has been successfully processed!”
        assertMethod("Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));

        // 2.49 Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        // 2.50 Verify the text &ldquo;Welcome to our store"
        assertMethod("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));

    }

    @After
    public void tearDown() {
        closerBrowser();
    }
}


