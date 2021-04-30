package tooltipInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationAndSizeOfElement {
    /*
    How to find location and size of web Element ?
    by using getLocation() method and GetSize() method is first approach and
    second approach using getRect() method
    getLocation----returns Point object in x and y co ordinate
    getSize gives width and height of elements
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");
        driver.manage().window().maximize();
//        how to find Location of amazon logo
//        by using 1st method
       WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
      Point locationOfLogo= logo.getLocation();
        System.out.println("Location of logo element----"+locationOfLogo);
//        if you want seperate x and y cordinate use this method
        System.out.println("location of logo (x)---"+logo.getLocation().getX());
        System.out.println("location of logo (y)---"+logo.getLocation().getY());
        System.out.println("******Second method********");
//        2nd method
        System.out.println("Location of logo element----"+logo.getRect().getPoint());
        System.out.println("location of logo (x)---"+logo.getRect().getX());
        System.out.println("location of logo (y)---"+logo.getRect().getY());
//      How to find size means width and height of elements
//        first method
        System.out.println("******Find the Size of element********");
        System.out.println("Size(Width,Height) of logo element----"+logo.getSize());
        System.out.println("Size(Width) of logo ---"+logo.getSize().getWidth());
        System.out.println("Size(Height) of logo ---"+logo.getSize().getHeight());
//        second method
        System.out.println("******Second method********");
        System.out.println("Size(Width,Height) of logo element----"+logo.getRect().getDimension());
        System.out.println("Size(Width) of logo ---"+logo.getRect().getDimension().getWidth());
        System.out.println("Size(Height) of logo ---"+logo.getRect().getDimension().getHeight());


    }
}
