package svgGraphAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CovidCasesGraph {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com/search?q=covid+cases+in+uk&sxsrf=" +
                "AOaemvLrwZy7wPgU73MG7iKvIz2TUOfpLw%3A1631813010409&ei=kn1DYfXFGIeeUKPfkYAG&oq=" +
                "covid+cases+in+uk&gs_lcp=Cgdnd3Mtd2l6EAMyCAgAEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyCAg" +
                "AEIAEEMkDMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgcIABBHELADOgcIABCwAxBDOgoIABCwAxDJ" +
                "AxBDOgQIIxAnOg0IABCABBCHAhCxAxAUOgsIABCABBCxAxCDAToHCAAQsQMQQzoLCAAQgAQQsQMQyQM6BQgAEJIDOgQIABBDOg0IABCx" +
                "AxCDARDJAxBDSgQIQRgAUIPFAVjt1gFgnt0BaAFwAngAgAHYAogB_wuSAQcwLjMuMy4xmAEAoAEByAEKwAEB&sclient=" +
                "gws-wiz&ved=0ahUKEwj11syWgYTzAhUHDxQKHaNvBGAQ4dUDCA4&uact=5");
        driver.findElement(By.cssSelector("button#L2AGLb")).click();
        List<WebElement>listOfEleme=driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg']//*[name()='g'])[1]//*[name()='rect']"));
        Actions act=new Actions(driver);
        for (WebElement e:listOfEleme){
            act.moveToElement(e).perform();
            String text=driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
            System.out.println(text);


        }
    }
}
