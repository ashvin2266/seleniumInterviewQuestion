package HandleJavaAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PermissionAlertPopUP {
    /*vedio 17
    This type pop up comes with browser so we can handle by using Options class like
    chromeOptions,firefoxOptions
     */
    public static void main(String[] args) {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.redbus.in/");

    }
}
