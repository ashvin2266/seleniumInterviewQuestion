package dropDownPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BootstrapDropdown {
//    SDET VEDIO BY PAVAN VEDIO 9
//    Bootstrap dropdown means its toggled by click method
//    looks like button there is no select tag in html
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.firefoxdriver().setup();
    WebDriver driver=new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement dropdownele = driver.findElement(By.id("dropdownMenuLink"));
    dropdownele.click();

    List<WebElement>optionElement=
            driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
    System.out.println("Total option in dropdown ;"+optionElement.size());
    for (WebElement option:optionElement){
        if (option.getText().equals("Something else here")){
            System.out.println(option.getText());
            Thread.sleep(2000);
            option.click();
            break;
        }
    }
    driver.get("https://www.hdfcbank.com/");
}
}

