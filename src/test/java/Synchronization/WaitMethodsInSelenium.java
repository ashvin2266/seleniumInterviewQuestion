package Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class WaitMethodsInSelenium {
//    SDET bY PAVAN VEDIO 19
    /*In this tutorial, you will learn about Implicitly Wait and Explicit Wait in Selenium WebDriver. How Synchronization works in WebDriver.

======================================================
Implicit Wait:
•During Implicit wait if the Web Driver cannot find it immediately because of its availability,
 it will keep polling the DOM to get the element.
•If the element is not available within the specified Time an NoSuchElementException will be raised.
•The default setting is zero.
•Once we set a time, the Web Driver waits for the period of the WebDriver object instance.

======================================================

Explicit Wait:
•There can be instance when a particular element takes more than a minute to load.
•In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same time for every element.
•To avoid that situation you can simply put a separate time on the required element only.
•By following this your browser implicit wait time would be short for every element and it would be large for specific element.
 ======================================================
 Question on wait
 What is Synchronization problem in Automation?
 What are the different types of waits available in Selenium WebDriver?
 What is difference between implicitywait and explicit wait

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
//        Implicit wait provide globally its used for all element present in script
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//h3[text()='SeleniumHQ Browser Automation']")).click();
    }
}
