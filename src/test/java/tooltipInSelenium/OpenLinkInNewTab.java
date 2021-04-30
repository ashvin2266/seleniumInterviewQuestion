package tooltipInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenLinkInNewTab {
    /*
    SDET By Pavan vedio 27
    when we click any link in page normaly it open in place of first screen so requirement is
    When you click link on page its open in new tabs
    We need to use Keys class and use chord() method
    How to open a link in new tab?
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
//        now i need to click on register link and its should open in new tab
       String tab= Keys.chord(Keys.CONTROL,Keys.RETURN);
       driver.findElement(By.linkText("Register")).sendKeys(tab);

    }
}
