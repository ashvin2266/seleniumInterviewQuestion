package handleDatePicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalanderSelectByNaveen {
    /*
    Handle Calendar in Selenium WebDriver - Session - 16:

Steps to handle calendar in Selenium Webdriver:
 1- Click on calendar
 2- Get all td of tables using findElements method
 3- using for loop get text of all elements
 4- using if else condition we will check specific date
 5- If date is matched then click and break the loop.
 6- Handle NoSuchElementException in case of (31st day)
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
//        i want to select date is 05/07/2021
        String date="30-November-2021";
        String[] dateArr=date.split("-");
        String day=dateArr[0];
        String month=dateArr[1];
        String year=dateArr[2];
//        select month and year
        while (true) {
            String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            String arr[] = text.split(" ");
            String monthName = arr[0];
            String yearName = arr[1];
            if (monthName.equalsIgnoreCase(month)&&yearName.equalsIgnoreCase(year))
                break;
            else
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();



        }
//        now select the date
        List<WebElement> allday=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']" +
                "//table[@class='ui-datepicker-calendar']//td"));
        for (WebElement dt:allday){
           try {
               String actualday = dt.getText();

               if (actualday.equalsIgnoreCase(day)) {
                   dt.click();
                   break;
               }

           }catch (Exception e){

           }




        }
    }
}
