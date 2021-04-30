package MouseOperationBySeleniumActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropInSelenium {
//    how to perform drag and drop in selenium

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement washingtonElement=driver.findElement(By.id("box3"));
        WebElement usaTrgetElement=driver.findElement(By.id("box103"));
        Actions act=new Actions(driver);
        act.dragAndDrop(washingtonElement,usaTrgetElement).perform();

    }
}
