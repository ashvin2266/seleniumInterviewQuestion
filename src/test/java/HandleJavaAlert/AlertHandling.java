package HandleJavaAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
//    SDET by Pavan vedio 17
    /*
    1) What is Java Script Alert?
    2) How To Handle Java Script Alerts?
    3) How To Handle Authentication Popup?
    4) How To Handle Permission Pop-ups?
    method is
    Alert alert=driver.switchTo().Alert();
    alert.accept();,alert.dismiss();,alert.getText();,alert.sendKeys();

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        String text=alert.getText();
        System.out.println("Message display in alert is--->"+text);
        alert.sendKeys("Welcome");
        Thread.sleep(2000);
        alert.accept();



        driver.close();

    }


}

