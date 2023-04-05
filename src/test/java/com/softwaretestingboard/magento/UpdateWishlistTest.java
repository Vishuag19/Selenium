package com.softwaretestingboard.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UpdateWishlistTest {
    @Test
    public void updateWishlist() {
        System.out.println("Starting UpdateWishlistTest");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://magento.softwaretestingboard.com/wishlist";
        driver.get(url);
        System.out.println("Page is opened.");

      // Login Details
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("abcdef@123");

        //click signin button
        WebElement signin = driver.findElement(By.xpath("//button[@class='action login primary']"));
        signin.click();


        // maximize browser window
        driver.manage().window().maximize();

        //Updating wishlist
        WebElement edit = driver.findElement(By.xpath("//a[@class='action edit']"));
        edit.click();


        //close browser
        driver.quit();
    }
}
