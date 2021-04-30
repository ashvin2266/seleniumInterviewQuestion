package KeyBoardActionByActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleKeysHandling {
//    SDET By Pavan vedio 25
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://text-compare.com/");
    driver.manage().window().maximize();
//    here we used following multiple key action like
//   control+a, control+c,then single key tab then control +v keys
    WebElement textBox1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
    WebElement textBox2=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
    textBox1.sendKeys("Welcome to Selenium");
//    CTRL+A
    Actions act=new Actions(driver);
    act.keyDown(Keys.CONTROL);
    act.sendKeys("a");
    act.keyUp(Keys.CONTROL);
    act.perform();
//    CTRL+C
    act.keyDown(Keys.CONTROL);
    act.sendKeys("c");
    act.keyUp(Keys.CONTROL);
    act.perform();
//    tab keys
    act.sendKeys(Keys.TAB).perform();
//    CTRL+V
    act.keyDown(Keys.CONTROL);
    act.sendKeys("v");
    act.keyUp(Keys.CONTROL);
    act.perform();
//    compare the bot textbox message
    if (textBox1.getAttribute("value").equals(textBox2.getAttribute("value")))
        System.out.println("Text is copied");
    else
        System.out.println("Text not copied");
}
}
