package handleIframeAndFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HowToHandleIframe {
   /* SDET By Pavan Vedio 18
   Interview Question
   1) What is the difference between frame and iframe?
  - A frame is used to divide a page into multiple sections, with new content on each section.
   -An iFrame is used to embed the content of the external websites into the web page,
   in order to avoid cross-site scripting issues.
    -An iFrame is considered to be less secure than a frame,
     as iFrame allows developers to embed content from the third party websites.
     Thus, an iframe requires a developer to trust the content which he has embedded in the iframe.
   --Most of the web applications being developed today do not use frames to divide the page,
    rather they use iframes to embed external content such as advertisements within the web page.
   2) How To Handle iframes in Selenium WebDriver?
   3) How To Switch between multiple iFrames?
   4) How To Work with Inner iFrames?

   We ccan switch iframe by three flavour
1. driver.switchTo().frame(frame name or frame id)
2. driver.swtichTo().frame(frame index)
3. driver.switchTo().frame(webElement)
    */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?index-all.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        i need to click on org.openqa.selenium link but its give no such element exception
//        because of element present in iframe so first we need to switch iframe and then element click
//        driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
//        frist switch to 1st iframe
        driver.switchTo().frame("packageListFrame");// iframe by iframe name
        driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
        driver.switchTo().defaultContent();
//        switch to 2ne iframe
        Thread.sleep(2000);
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
        driver.switchTo().defaultContent();
//        switch to 3rd iframe
        Thread.sleep(5000);
        driver.switchTo().frame("classFrame");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Package']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Help']")).click();
    }

}
