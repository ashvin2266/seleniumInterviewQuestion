package synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        By signInLocator=By.xpath("//a[normalize-space()='Sign in']");
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(signIn));
//        waitUntilElementToBeClickable(driver,signIn,10);
//        signIn.click();
        waitUntilElementPresence(driver,signInLocator,10).click();



    }
//    creating general method
    public static WebElement waitUntilElementPresence(WebDriver driver, By locator, int timeout){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);

    }




        public static void waitUntilElementToBeClickable(WebDriver driver, WebElement element, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }


}
