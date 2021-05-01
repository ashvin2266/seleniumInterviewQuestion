package sliderHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {
//    SDET  bY pavan vedio 24
    /*
    What is the Difference Between Actions & Action?
    ====> Actions is a class and Action is a interface
    What is the Difference Between build() & perform()?
    ====>Build --create a action and its return Action
         Perform-- perform on this action
         if you use perform() method its internally called build method.so its better to use perform()method instead of
         build().perform() in thid build method called two times
     */
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver= new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().maximize();
//    here we use mouse hover action on women feature by build and perform method
    WebElement womenFeature=driver.findElement(By.xpath("//a[@title='Women']"));
    WebElement dressesFeature=driver.findElement(By.xpath("//a[@title='Dresses']"));

    Actions act=new Actions (driver);
    act.moveToElement(womenFeature).build().perform();
    Thread.sleep(3000);
    act.moveToElement(dressesFeature).click().perform();
    Thread.sleep(2000);
//    difference between Action and Actions
//    here build method return action so we store in action interface variable
    WebElement cart=driver.findElement(By.xpath("//b[normalize-space()='Cart']"));
    Action action=act.moveToElement(cart).build();
//    action use for perform
    action.perform();





}
}
