package electronics;

import utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ElectronicsTest extends Utility {


        String baseUrl = "https://demowebshop.tricentis.com/";

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }


        @Test
        public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

            // 1.1 Mouse Hover on the “ELECTRONICS” Tab
            mouseToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));

            // 1.2 Mouse Hover on the “Cell phones” and click
            mouseHoverAndClick(By.partialLinkText("Cell"));

            // 1.3 Verify the text “Cell phones
            assertMethod("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        }


        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {

            //  2.1 Mouse Hover on the “ELECTRONICS” Tab
            mouseToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));

            // 2.2 Mouse Hover on the “Cell phones” and click
            mouseHoverAndClick(By.partialLinkText("Cell"));

            // 2.3 Verify the text “Cell phones”
            assertMethod("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

            // 2.4 Select View as option ‘List’
            selectFromDropDown(By.xpath("//select[@id='products-viewmode']"), "List");

            // 2.5 Click on the product name “Smartphone” link
            clickOnElement(By.xpath("//a[normalize-space()='Smartphone']"));

            // 2.6 Verify the text “Smartphone”
            assertMethod("Smartphone", By.xpath("//h1[normalize-space()='Smartphone']"));

            // 2.7 Verify the price “100.00”
            assertMethod("100.00", By.xpath("(//span[@class='price-value-43'])[1]"));

            // 2.8 Change the quantity to 2
            WebElement qty = driver.findElement(By.xpath("(//input[@id='addtocart_43_EnteredQuantity'])[1]"));
            qty.clear();
            qty.sendKeys("2");

            // 2.9 Click on the “Add to cart” tab
            clickOnElement(By.xpath("(//input[@id='add-to-cart-button-43'])[1]"));

            // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
            assertMethod("The product has been added to your shopping cart", By.xpath("(//p[@class='content'])[1]"));

            // 2.11 After that close the bar by clicking on the cross button.
            clickOnElement(By.xpath("//span[@title='Close']"));

            // 2.12 Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
            mouseToElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));

            // 2.13 Verify the message "Shopping cart"
            assertMethod("Shopping cart", By.xpath("//span[normalize-space()='Shopping cart']"));

            // 2.14 Verify the quantity is 2
            // assertMethod("2", By.cssSelector(".qty-input"));

            // 2.15 Verify the Total “200.00”
            //  assertMethod("200.00", By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'200.00')]"));

            // 2.16 click on the checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));

            // 2.17 Click on the “Checkout” button
            clickOnElement(By.xpath("//button[@id='checkout']"));

            // 2.18 Verify the Text “Welcome, Please Sign In!”
            assertMethod("Welcome, Please Sign In!", By.tagName("h1"));

            // 2.19 Click on the “Register” tab
            clickOnElement(By.xpath("//input[@value='Register']"));

            // 2.20 Verify the text “Register”
            assertMethod("Register", By.tagName("h1"));

            // 2.21 Select the Male radio button
            clickOnElement(By.xpath("//input[@id='gender-male']"));

            // 2.22 Enter the First name
            driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Prashant");

            // 2.23 Enter the Last name
            driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");

            // 2.24 Enter the Email
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("233prashant@gmail.com");

            // 2.25 Enter the Password
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

            // 2.26 Enter the Confirm password
            driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

            // 2.27 Click on the “Register” button
            clickOnElement(By.xpath("//input[@id='register-button']"));

            // 28 Verify the message “Your registration completed”
            assertMethod("Your registration completed", By.xpath("//div[@class='result']"));

            // 2.29 Click on the “Continue” button
            clickOnElement(By.xpath("//input[@value='Continue']"));

            // 2.30 Verify the text “Shopping cart”
            assertMethod("Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

            // 2.31 click on the checkbox “I agree with the terms of service”
            clickOnElement(By.xpath("//input[@id='termsofservice']"));

            // 2.32 Click on the “Checkout”
            clickOnElement(By.xpath("//button[@id='checkout']"));

            // 2.33 Select the Country “United Kingdom” using the select class
            selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");

            // 2.34 Enter the city
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");

            // 2.35 Enter the Address1
            driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])[1]")).sendKeys("17 Baker Street");

            // 2.36 Enter the Zip/Postal code
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("NW1 5AB");

            // 2.37 Enter the Phone number
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("071234567");

            // 2.38 Click on the “Continue” button
            clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

            // 2.39 Click on the “Continue” button
            clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

            // 2.40 Click on the Radio Button “2nd Day Air ($0.00)”
            clickOnElement(By.xpath("(//input[@id='shippingoption_2'])[1]"));

            // 2.41 Click on the “Continue” button
            clickOnElement(By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])[1]"));

            // 2.42 Select the Radio Button “Credit Card”
            clickOnElement(By.xpath("(//input[@id='paymentmethod_2'])[1]"));

            // 2.43 Click on the “Continue” button
            clickOnElement(By.xpath("(//input[@class='button-1 payment-method-next-step-button'])[1]"));

            // 2.44 Select the “Visa” From Select credit card dropdown
            selectFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

            // 2.45 Enter the Cardholder's name
            driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Prashant K");

            //  2.46 Enter the Card number
            driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("567583940349293");

            // 2.47 Select the Expiration date using the select class
            selectFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "07");
            selectFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");

            // 2.48 Enter the Card code
            driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("231");

            // 2.49 Click on the “Continue” button
            clickOnElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]"));

            // 2.50 Verify the “Payment Method” is “Credit Card”
            assertMethod("Credit Card", By.xpath("//li[@class='payment-method']"));

            // 2.51 Verify the “Shipping Method” is “2nd Day Air”
            assertMethod("2nd Day Air", By.xpath("//li[@class='shipping-method']"));

            // 2.52 Verify the Total is “200.00”
            assertMethod("200.00", By.cssSelector("span[class='product-price order-total'] strong"));

            // 2.53 Click on the “Confirm” button
            clickOnElement(By.xpath("//input[@value='Confirm']"));

            // 2.54 Verify the Text “Thank You”
            assertMethod("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

            // 2.55 Verify the message “Your order has been successfully processed!”
            assertMethod("Your order has been successfully processed!", By.tagName("strong"));

            // 2.56 Click on the “Continue” button
            clickOnElement(By.xpath("//input[@value='Continue']"));

            // 2.57 Verify the text “Welcome to our store”
            assertMethod("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));

            // 2.58 Click on the “Logout” link
            clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

            // 2.59 Verify the URL is “https://demowebshop.tricentis.com/”
            Assert.assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

        }

        @After
        public void tearDown() {
            closerBrowser();
        }
    }

