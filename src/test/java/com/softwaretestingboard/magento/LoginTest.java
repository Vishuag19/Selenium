package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void loginTest(){
        System.out.println("Starting LoginTest");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // sleep for 3 seconds
        sleep(3000);

        // maximize browser window
        driver.manage().window().maximize();

//		open test page
        String url = "https://magento.softwaretestingboard.com/customer/account/login";
        driver.get(url);
        System.out.println("Page is opened.");

        // sleep for 2 seconds
        sleep(2000);

//		enter user details
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("abcdef@123");


//		click signin button
        WebElement signin = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signin.click();

//		 succesful message
        WebElement successMessage = driver.findElement(By.xpath("//h1[@class='page-title']"));
        String expectedMessage = "My Account";
        String actualMessage = successMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not the same as expected");


        // Close browser
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


