package mouseOperationBySeleniumActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DoubleClickByMouse {
//    How to perform double click in selenium
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement doubleclickButton=
            driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
    Actions act=new Actions(driver);
    act.doubleClick(doubleclickButton).perform();
}
}
