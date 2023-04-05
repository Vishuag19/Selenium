package com.softwaretestingboard.magento;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void signUpTest(){
        System.out.println("Starting SignUpTest");

//		Create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // sleep for 3 seconds
        sleep(3000);

        // maximize browser window
        driver.manage().window().maximize();

//		open test page
        String url = "https://magento.softwaretestingboard.com/customer/account/create";
        driver.get(url);
        System.out.println("Page is opened.");

        // sleep for 2 seconds
        sleep(2000);

//		enter user details
        WebElement firstname = driver.findElement(By.id("firstname"));
        firstname.sendKeys("Andrew");
        WebElement lastname = driver.findElement(By.id("lastname"));
        lastname.sendKeys("Symonds");
        WebElement email = driver.findElement(By.id("email_address"));
        email.sendKeys("andrewzyxwcvb@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abcdef@123");
        WebElement confirmpassword = driver.findElement(By.id("password-confirmation"));
        confirmpassword.sendKeys("abcdef@123");

//		click create an account button
        WebElement createaccount = driver.findElement(By.xpath("//button[@class='action submit primary']"));
        createaccount.click();

//		 succesful message
        WebElement successMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        String expectedMessage = "Thank you for registering with Fake Online Clothing Store.";
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
