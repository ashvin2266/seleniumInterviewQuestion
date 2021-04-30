package tooltipInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLin2TaborWindow {
    /*
    when we open one URL by driver.get method after we need to open other URL in browser
    normally when you use other URL its open in browser but first application url is
     replace with second url
     But our requirement is open both URL in diff tab or browser window

     Question
     How to open URL’s in a multiple tabs & Windows?
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
//        normally its open in one tab so first application url replaced with second url
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.get("https://www.opencart.com/");
//      How to open URL’s in a multiple tabs & Windows?
        driver.get("http://www.indeed.co.uk/");
//        we need to use switch to new window method and give window type Tab its open in diff tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.opencart.com/");
//        if you want to open url in diff browser window use windowtype.window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.co.uk/");
    }
}
