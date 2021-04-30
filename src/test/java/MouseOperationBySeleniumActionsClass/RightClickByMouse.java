package MouseOperationBySeleniumActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RightClickByMouse {
    /*
    SDET By Pavan Vedio 23
    Interview question
    How To Perform Mouse Operations in Selenium WebDriver?
    How to Perform Right click Action?
     How to Perform Double click Action?
    How to Perform Drag and Drop Action?
    How to Perform Mouse Hover Action?
     */
    public static void main(String[] args) {
//        How to perform right click action?
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2019/12/right-click.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       WebElement contextField= driver.findElement(By.id("div-context"));
       Actions act=new Actions(driver);
       act.contextClick(contextField).perform();
    }
}
