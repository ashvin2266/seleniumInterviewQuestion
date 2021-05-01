package handleJavaAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUps {
    /* vedio 17
    How to handles authentication popups

    its handle by entering the username and password with URL
     syntex=http://username:password@the-internet.herokuapp.com/
           http://admin:admin@the-internet.herokuapp.com/
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
//        to solve this type of pop up we need to enter usename and password with url like
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
