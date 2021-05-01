package handleDatePicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePickerDropDown {
    /*
    SDET Vedio part 22
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.id("dob")).click();
//         month and year selection by drop down
        Select monthDrp= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        monthDrp.selectByVisibleText("Jan");
       Select yearDrp= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
       yearDrp.selectByVisibleText("2000");

//       selection of date picker
        String date="25";

       List<WebElement> alldates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
       for (WebElement el:alldates){
           String dt=el.getText();
           if (dt.equalsIgnoreCase(date)){
               el.click();
               break;
           }
       }
    }
}
