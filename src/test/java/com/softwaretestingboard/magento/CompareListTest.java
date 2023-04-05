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

public class CompareListTest {
    @Test
    public void compareListTest() {
        System.out.println("Starting Test");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // maximize browser window
        driver.manage().window().maximize();
        //LoginPage
        String url = "https://magento.softwaretestingboard.com/customer/account/login";
        driver.get(url);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("abcdef@123");


//		click signin button
        WebElement signin = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signin.click();


//		open test page
        String url1 = "https://magento.softwaretestingboard.com/gear/watches.html";
        driver.get(url1);
        System.out.println("Page is opened.");
        WebElement item1 = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/2a213d0c937b30e310c8ee797a880cef/w/g/wg03-gr-0.jpg']"));
        item1.click();
        WebElement compare = driver.findElement(By.xpath("//a[@class='action tocompare']"));
        compare.click();
        String url2 = "https://magento.softwaretestingboard.com/gear/watches.html";
        driver.get(url2);
        WebElement item2 = driver.findElement(By.xpath("//img[@src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/2a213d0c937b30e310c8ee797a880cef/w/g/wg02-bk-0.jpg']"));
        item2.click();
        WebElement compare2 = driver.findElement(By.xpath("//a[@class='action tocompare']"));
        compare2.click();

        //Verification

        // Close browser
        driver.quit();


    }
}
