package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownOptionSortedOrNot {
//    SDET by Pavan Vedio 11
//    we need to check the dropdown option is sorted or not sorted
    /*
    here we fetch the dropdown option and putin original list and templist
     then templist sorted and compare both list equal or not

    */
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.twoplugs.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
    driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
    driver.findElement(By.xpath("//div[contains(text(),'All')]")).click();
   WebElement dropdownele= driver.findElement(By.name("category_id"));
    Select selectOption=new Select(dropdownele);
//    selectOption.selectByVisibleText("Automobile");
   List<WebElement>optionListEle= selectOption.getOptions();
    System.out.println("total available option--->"+optionListEle.size());
    ArrayList originalList=new ArrayList();
    ArrayList tempOptionList= new ArrayList();
    for (WebElement option:optionListEle){
       String text= option.getText();
       originalList.add(text);
       tempOptionList.add(text);
    }
    System.out.println("Original option list is---"+ originalList);
    System.out.println("tempOptionList before sorted is----"+ tempOptionList);
    Collections.sort(tempOptionList);
    System.out.println("TempOption list after sorted---- "+tempOptionList);
    if (originalList.equals(tempOptionList)){
        System.out.println("Dropdown option is sorted ");
    }
    else{
        System.out.println("Dropdown option is Unsorted ");
    }
}

}
