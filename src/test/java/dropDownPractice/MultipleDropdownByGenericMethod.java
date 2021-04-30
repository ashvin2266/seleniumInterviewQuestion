package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleDropdownByGenericMethod {
//    SDET by Pavan Vedio 8
//    How to select option in multiple drop down by option method using generic method"
     static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        WebElement noOfEmpEle=driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
        selectOptionFromDropdown(noOfEmpEle,"51 - 75");
        WebElement IndustryEle=driver.findElement(By.id("Form_submitForm_Industry"));
        selectOptionFromDropdown(IndustryEle,"Retail / Wholesale");
        WebElement countryEle=driver.findElement(By.id("Form_submitForm_Country"));
        selectOptionFromDropdown(countryEle,"Argentina");
    }
    public static void selectOptionFromDropdown(WebElement element,String value){
        Select select=new Select(element);
        List<WebElement>optionList=select.getOptions();
        for (WebElement option:optionList){
            if (option.getText().equals(value)){
                option.click();
            }
        }
    }
}
