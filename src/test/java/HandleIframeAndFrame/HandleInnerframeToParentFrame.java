package HandleIframeAndFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerframeToParentFrame {
    /*
    Here we first going to outer frame and then inner frame then we capture text from inner frame
    then we come back to outer frame and capture the text present in outer frame
    we used one more syntax for swithto frame
    driver.switchTo().parentFrame();
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");//passed id of outer frame
        driver.switchTo().frame(0);//passed indexof inner frame
       String innerframeText= driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Inner frame text-----"+innerframeText);
        driver.switchTo().parentFrame();//here switch back to outer frame
       String outerframeText=
               driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to spe')]")).getText();
        System.out.println("outer frame or parentframe text----"+outerframeText);

      }
}
