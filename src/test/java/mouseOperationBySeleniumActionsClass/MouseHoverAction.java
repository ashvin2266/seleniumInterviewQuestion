package mouseOperationBySeleniumActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseHoverAction {
//    how to perform mouseHover action in Selenium
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://demo.opencart.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement desktopEle=driver.findElement(By.xpath("//a[text()='Desktops']"));
    WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
    Actions act=new Actions(driver);
    act.moveToElement(desktopEle);
    act.moveToElement(mac).click().perform();
    Thread.sleep(2000);
    WebElement component=driver.findElement(By.xpath("//a[normalize-space()='Components']"));
    WebElement scanner=driver.findElement(By.xpath("//a[normalize-space()='Scanners (0)']"));
    act.moveToElement(component).moveToElement(scanner).click().perform();

}
}
