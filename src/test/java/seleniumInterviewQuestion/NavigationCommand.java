package seleniumInterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {
//    SDET BY PAVAN VEDIO NO 5
   /* Question for interview
   1. How to Navigate Back and Forward ?
   ----> by using navigate().forward(); and by using navigate().back(); method
   2. How to Refresh the page ?
   ----->By using navigate().refresh();method
   3. What is the difference between driver.get() and driver.navigate.to() method?
   ---->get()method ====>used to navigate to particular URL(website) and wait till page loaded
   ---->navigate().to()=====>used to navigate to particular URL(website) and does not wait to page loaded
   ---both method used for opening url in the browser there is no difference between them
   ---they are synonym for one another
   ----the only difference is that can be found in the parameter
   ====>get()method only accept one string parameter
   =====>navigate().to() method can accepts String parameter and URL instance as a parameter
   4. How to refresh the page without using navigate()method?
   5. How many ways to refresh the page ?

   we have four types of navigate method
   1.navigate().back();
   2.navigate().forward();
   3.navigate().refresh();
   4. navigate().to();






    */













    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.get("http://www.indeed.co.uk/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.get("http://automationpractice.com/index.php?");
        driver.navigate().to("http://www.indeed.co.uk/");
//        DIFF METHOD FOR REFRESH
//        1.USING KEYS WITHOUT navigate method
        driver.findElement(By.id("text-input-what")).sendKeys(Keys.F5);
//        2nd method
        driver.getCurrentUrl();
        driver.navigate().to(driver.getCurrentUrl());
        driver.navigate().refresh();
        driver.navigate().to("http://www.indeed.co.uk/");
        driver.close();

    }
}
