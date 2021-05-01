package sliderHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Slider {

    /*SDET By Pavan Vedio 24
    How To Handle Slider?
How To Find Location & Size of the Web Element?
What is the Difference Between Actions & Action?
What is the Difference Between build() & perform()?
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement lowerSliderEle=driver.findElement(By.xpath("//span[1]"));
        WebElement upperSliderEle=driver.findElement(By.xpath("//span[2]"));
//        we capture the location and size of the slider
        System.out.println("Location of the Lower slider is----->" +lowerSliderEle.getLocation());
        System.out.println("Height and width  of the Lower slider is----->" +lowerSliderEle.getSize());
        System.out.println("Location of the Upper slider is----->" +upperSliderEle.getLocation());
        System.out.println("Height and width  of the Upper slider is----->" +upperSliderEle.getSize());
//       now we move slider by drag and drop method
        Actions act=new Actions(driver);
        act.dragAndDropBy(lowerSliderEle,80, 0).perform();
        System.out.println( "loser slider location -----"+lowerSliderEle.getLocation());
        act.dragAndDropBy(upperSliderEle,-100,0).perform();
        System.out.println( "upper slider location -----"+upperSliderEle.getLocation());

    }
}
