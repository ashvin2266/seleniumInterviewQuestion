package screenShotHandleInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShot {
    /*
    SDET By Pavan Vedio 26
    How to capture Screenshot of Full Page?
    How to capture Screenshot of Section of  a Web Page?
    How to capture Screenshot of an Element on a  Web Page?

     */
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
//        Capture full page screenshot
  /*      here we using takesscreenshot interface and getscreenshot method
        here we typecast driver because webDriver also another interface so
        this driver can not hold takesscreenshot interface variable
        but if we use chromedriver driver=new chromedriver we no need to typecast
        because chromdriver extends remotewebdriver class and
        remote webdriver implements both webdriver and a takesscreenshot interface*/
        TakesScreenshot ts=(TakesScreenshot)driver;
         File src=ts.getScreenshotAs(OutputType.FILE);
         File trg= new File("ScreenShot//homepage.png");
        FileUtils.copyFile(src,trg);
//        capture screenshot of the section of page
        /* here we not using takeascreenshot interface because
        WebElement have getScreenshot method itself this is from selenium 4
                 */
        WebElement featuredProduct=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
         File srcFile=featuredProduct.getScreenshotAs(OutputType.FILE);
         File targetFile= new File("ScreenShot//featuredProduct.png");
         FileUtils.copyFile(srcFile,targetFile);
//         Capture screenshot of webElements is similar to section
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourceFile=logo.getScreenshotAs(OutputType.FILE);
        File trgFile=new File("ScreenShot//logo.png");
        FileUtils.copyFile(sourceFile,trgFile);
    }
}
