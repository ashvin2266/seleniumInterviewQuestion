package MouseOperationBySeleniumActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ImageDragAndDropInSelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement frameEle=driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(frameEle);
        WebElement image1=driver.findElement(By.xpath("//li[1]"));
        WebElement image2=driver.findElement(By.xpath("//li[2]"));
        WebElement image3=driver.findElement(By.xpath("//li[3]"));
        WebElement image4=driver.findElement(By.xpath("//li[4]"));
        Thread.sleep(2000);
        WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));
        Actions act =new Actions(driver);
        act.dragAndDrop(image1,trash).perform();
        act.dragAndDrop(image2,trash).perform();
        Thread.sleep(2000);
        act.dragAndDrop(image3,trash).perform();
        act.dragAndDrop(image4,trash).perform();

    }
}
