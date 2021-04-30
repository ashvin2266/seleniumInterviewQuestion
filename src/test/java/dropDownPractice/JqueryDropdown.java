package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JqueryDropdown {
//    SDET By Pavan VEDIO 10
//    how to select one option,multiple option and all option
//    here we giving string...value parameter means it hold one or multiple string parameter value
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
//    selectChoiceOfOption(driver,"choice 1");
//    selectChoiceOfOption(driver,"choice 2", "choice 2 3", "choice 5", "choice 6 2 2", "choice 6 2");
    selectChoiceOfOption(driver,"all");
}
public static void selectChoiceOfOption(WebDriver driver,String... value){
    List<WebElement> choiceList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
    System.out.println("total choice list ="+choiceList.size());
    if (!value[0].equalsIgnoreCase("all")) {
        for (WebElement choice : choiceList) {
            String text=choice.getText();
            for (String val:value){
                if (text.equalsIgnoreCase(val)){
                    choice.click();
                    break;
                }
            }
                    }

    }
    else{
        try {
            for (WebElement choice : choiceList) {
                choice.click();
            }
        }
        catch (Exception e){

        }



    }


}
}
