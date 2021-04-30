package HandleIframeAndFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerIframe {
    /*
    here one frame is inside another frame its called innerframe
    Here this type of frame when we switch to one frame to another frame no need to
    driver.switchTo().defaultContent()
    Here we dont have any name or id of iframe we passed the webElement instead of name or id
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
        WebElement outerframe=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
        driver.switchTo().frame(outerframe);//here we pass webelement of iframe
        WebElement innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerframe);//here we didnt use default content method for switching frame
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");
    }
}
