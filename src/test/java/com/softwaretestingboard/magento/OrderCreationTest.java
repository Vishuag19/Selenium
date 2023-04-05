package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderCreationTest {
    @Test
    public void orderCreationTesting() {
        System.out.println("Starting Test");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // maximize browser window
        driver.manage().window().maximize();

//		open test page
        String url = "https://magento.softwaretestingboard.com/customer/account/login";
        driver.get(url);
        System.out.println("Page is opened.");


//		enter user details
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("abcdef@123");


      //click signin button
        WebElement signin = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signin.click();

        //Product details
        String url1 = "https://magento.softwaretestingboard.com/gear/watches.html";
        driver.get(url1);
        System.out.println("Page is opened.");
        WebElement item = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/2a213d0c937b30e310c8ee797a880cef/m/g/mg02-bk-0.jpg']"));
        item.click();

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        WebElement addtocart = driver.findElement(By.id("product-addtocart-button"));
        addtocart.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("shopping cart")));
        WebElement cart = driver.findElement(By.linkText("shopping cart"));
        cart.click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-cart-btn-checkout")));
        WebElement ProceedTocCheckout = driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
        ProceedTocCheckout.click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("radio")));
        //Add address
     //   WebElement firstname = driver.findElement(By.name("firstname"));
     //   firstname.sendKeys("");
    //    WebElement lastname = driver.findElement(By.name("lastname"));
    //    lastname.sendKeys("");
    //    WebElement address = driver.findElement(By.id("WR8NY68"));
    //    address.sendKeys("12/15 Avenue Street");
    //    WebElement city = driver.findElement(By.name("city"));
    //   city.sendKeys("New York City");
    //    WebElement state = driver.findElement(By.name("region_id"));
    //    state.sendKeys("New York");
   //     WebElement code = driver.findElement(By.id("D2T5T2D"));
    //    code.sendKeys("46620");
     //   WebElement phone = driver.findElement(By.id("JMYJU7D"));
     //   phone.sendKeys("7500194755");

        WebElement shipping = driver.findElement(By.className("radio"));
        shipping.click();
        WebElement nextButton = driver.findElement(By.xpath("//button[@class='button action continue primary']"));
        nextButton.click();
//explecit wait
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='action primary checkout']")));
        //Place order
      sleep(5000);
        WebElement placeButton = driver.findElement(By.xpath("//div[@id='checkout-payment-method-load']//div[@class='payment-group']/div[2]//button[@title='Place Order']/span[.='Place Order']"));
        placeButton.click();

        //Verification
        sleep(10000);
        WebElement successMessage = driver.findElement(By.xpath("/html//main[@id='maincontent']//span[@class='base']"));
        String expectedMessage = "Thank you for your purchase!";
        String actualMessage = successMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not the same as expected");

        // close browser
        driver.quit();
    }
    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
