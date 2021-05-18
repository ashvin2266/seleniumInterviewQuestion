package uploadFileInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaScriptExecutorInSelenium.JavaScriptUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFile extends JavaScriptUtility{
    /*
    SDET by Pavan vedio 31
    How to upload the file in selenium WebDriver?
     sendKeys()
     Robot Class
     */
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // using send keys method
    /* 1.  driver.get("https://www.monsterindia.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='Click to upload your resume']")).click();
        Thread.sleep(2000)
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\ashvi\\Downloads\\samplepayslip.PDF");
      2 .
      driver.get("http://automationpractice.com/index.php?controller=contact");
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\Users\\ashvi\\Downloads\\samplepayslip.PDF");

      // using Robot class
        /*
        if type=file ---use send keys and if not type=file-----use robot class
        we click upload file new window open and kasser(mouse) is on file input box by default
        what we doing manually same thing we doing by robot class
        like
        1. copy the file path
        2.paste in the file input text box(Control +v)
        3. press enter
         */
        driver.get("https://www.monsterindia.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@title='Click to upload your resume']")).click();
        Thread.sleep(2000);
//        driver.findElement(By.id("fileUpload")).click();
       WebElement button= driver.findElement(By.xpath("//input[@id='file-upload']"));
       JavascriptExecutor js= (JavascriptExecutor)driver;
       js.executeScript("arguments[0].click();",button);
//        copy path to clipboard
        StringSelection ss=new StringSelection("C:\\Users\\ashvi\\Downloads\\samplepayslip.PDF");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Robot rb= new Robot();
        rb.delay(2000);
//        Control+v
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
//        release control+v keys
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
//        press enter keys by robot
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);



    }

}
