package synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWaitExample {
    /*
    Fluent wait is similar type of web driver wait but more flexibility  in poling time and
    ignoring exceptions

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //        Fluent wait declairing
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
//        fluent wait using in script
        WebElement selenium=wait.until(new Function<WebDriver, WebElement>() {
                                           public WebElement apply(WebDriver webDriver) {
                                               return driver.findElement(By.xpath("//h3[text()='SeleniumHQ Browser Automation']"));
                                           }
                                       });
        selenium.click();
//        driver.findElement(By.xpath("//h3[text()='SeleniumHQ Browser Automation']")).click();

    }
}
