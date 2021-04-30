package HandleDatePicker;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePickerPractice {
    /*
    SDET VEDIO PART 22
    Date picker is customise element because date picker not same for every application
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
//      I want to pick date is 25/07/2021
        String month="July";
        String year="2022";
        String date="32";


        while (true){
           String monthYear= driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
           String []arr=monthYear.split(" ");
           String Month=arr[0];
           String Year=arr[1];
            if (Month.equalsIgnoreCase(month)&& Year.equalsIgnoreCase(year))
            break;
            else
                driver.findElement(By.xpath("//button[text()='>']")).click();
        }
//          picking date now
      List<WebElement>totalDates= driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

         for (WebElement dt:totalDates){
            String Date= dt.getText();
            if (Date.equalsIgnoreCase(date)){
                dt.click();
                break;
            }
         }

     }
}
