package javaScriptExecutorInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptPractice {
    /*  SDET BY Pavan vedio 28
    How To use JavaScriptExecutor in Selenium WebDriver?
--------
1) Flashing Element
2) Drawing border & take screenshot of the Element
3) Get the title of the page
4) Click action
5) Generate alert
6) Refreshing the page
7) Scrolling down page
8) Scroll up page
9) Zoom-In Zoom-Out page

     */
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
//        2) Drawing border & take screenshot of the Element
       WebElement logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
       JavaScriptUtility.drowAborder(logo,driver);
        TakesScreenshot ts =(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("ScreenShot/logoBorder.png");
        FileUtils.copyFile(src,trg);
//        3) Get the title of the page
        String titleOfPage=JavaScriptUtility.getTitleByJs(driver).toString();
        System.out.println("Title of page by js --"+titleOfPage);
//        4) Click action
      /*  WebElement login= driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
        JavaScriptUtility.clickElementByJs(login,driver);

       */
//      5) Generate alert
        JavaScriptUtility.generateAlert(driver,"Alert generated by js");
        Alert alert=driver.switchTo().alert();
        System.out.println("alert text is ----"+alert.getText());
        alert.dismiss();
//        6) Refreshing the page
        JavaScriptUtility.refreshBrowserByJs(driver);
//        7) Scrolling down page
//        8) Scroll up page
        JavaScriptUtility.scrollPageDownByJs(driver);
        Thread.sleep(4000);
        JavaScriptUtility.scrollPageUpByJs(driver);
//        9) Zoom-In Zoom-Out page
        JavaScriptUtility.zoomPageByJs(driver);
//      1) Flashing Element
       WebElement computer= driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
       JavaScriptUtility.flash(computer,driver);
    }

}