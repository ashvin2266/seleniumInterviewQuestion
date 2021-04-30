package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutocompleteGoogleDropdown {
//    SDET BY PAVAN VEDIO NO 13

    /* Autocompelete google dropdown you not inspect choice option from dom thats
    why we need to down arrow method use
    and then get attribute value from field box and use if text is equal and then enter it.
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.twoplugs.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
       WebElement dropfield= driver.findElement(By.cssSelector("#autocomplete"));
       dropfield.clear();
       Thread.sleep(3000);
       dropfield.sendKeys("London");
       Thread.sleep(2000);
       String text;
       do {
           dropfield.sendKeys(Keys.ARROW_DOWN);
           text=dropfield.getAttribute("value");
           System.out.println(text);
           if (text.equalsIgnoreCase("London, OH, USA")){
               Thread.sleep(3000);
               dropfield.sendKeys(Keys.ENTER);
               break;
           }
       }
       while (!text.isEmpty());


    }
}
