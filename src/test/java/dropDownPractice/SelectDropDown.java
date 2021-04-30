package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectDropDown {
    /* SDET by Pavan Vedio-8
    Select drop down option by usin select class and select class have a three method to use to select option
    1.selectByVisibleText()
    2.selectByValue()
    3.selectByIndex()
     */
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();
        driver.get("https://www.startours.co.uk/" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement holidayEle= driver.findElement(By.id("cphBody_HolidaySearchBanner_ddlHolidayWhere"));
       Select holidayname=new Select(holidayEle);
//        holidayname.selectByVisibleText("UK Holidays");
//        holidayname.selectByIndex(3);
//        holidayname.selectByValue("WI-Duration-12-Days-Plus")
//        how you can select without using this method
        List<WebElement>optionElement=holidayname.getOptions();
        for (WebElement option:optionElement){
            if (option.getText().equals("UK Holidays")){
                option.click();
                break;
            }
        }





    }
}
