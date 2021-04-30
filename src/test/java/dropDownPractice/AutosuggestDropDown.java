package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.datatype.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutosuggestDropDown {
//    SDET VEDIO BY PAVAN NO 12
    /*How to handles Auto suggest Drop down in selenium
    auto suggest dropdown means when you type text  in input box its gives suggestion of
    choice option to select option from list
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
        Thread.sleep(3000);
        List<WebElement> optionElementlist=driver.findElements(By.xpath("//ul[@id='sa_ul']/li"));
        System.out.println(optionElementlist.size());
        for (WebElement text:optionElementlist){
            String optionCoiceText=text.getText();
            System.out.println(optionCoiceText);
            if (optionCoiceText.equalsIgnoreCase("selenium webdriver")){
                text.click();
                break;
            }
        }
    }
}
