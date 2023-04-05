package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistTest {
    @Test
    public void wishlistTest() {
        System.out.println("Starting WishlistTest");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // maximize browser window
        driver.manage().window().maximize();

//		open test page
        String url = "https://magento.softwaretestingboard.com/gear/watches.html";
        driver.get(url);
        System.out.println("Page is opened.");
        WebElement item = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/2a213d0c937b30e310c8ee797a880cef/w/g/wg02-bk-0.jpg']"));
        item.click();
        WebElement wishlist = driver.findElement(By.xpath("//a[@class='action towishlist']"));
        wishlist.click();

        //LoginPage
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("abcdef@123");


//		click signin button
        WebElement signin = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signin.click();

        //Verification
        WebElement successMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String expectedMessage = "Didi Sport Watch has been added to your Wish List.";
        String actualMessage = successMessage.getText();
        //Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Actual message does not contain expected message.\nActual Message: " + actualMessage
                        + "\nExpected Message: " + expectedMessage);
        // Close browser
        driver.quit();


    }
}
