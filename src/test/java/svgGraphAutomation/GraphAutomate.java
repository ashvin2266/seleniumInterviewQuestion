package svgGraphAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaScriptExecutorInSelenium.JavaScriptUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GraphAutomate {
    /*
    This type of graph we need to automate we inspect the page and
    we see there is <svg> type attribute thats called svg element
    there normal xpath not worked so need to do svg xpath we done in this script
    when we need to capture tooltip text
    we need to inspect element go to source tab in dom
    then press F8 key so it pause debugger
    then move cusser to tooltip then run debugger by press f8 then find xpath
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavaScriptUtility.scrollPageDownByJs(driver);
        String columnBarElement="//div[@id='highcharts-sbaiy3x-4']//*[local-name()='svg'][1]/*[name()='rect'][2]";
        String verticalBar="//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
/*
xpath of round graph text 41..8 and 58.00*/
         String round="//*[local-name()='svg']//*[name()='g' and @class='highcharts-data-labels highcharts-series-0 highcharts-pie-series  highcharts-tracker                ']//*[name()='text']";
         List<WebElement>roundlist=driver.findElements(By.xpath(round));
        System.out.println("size of round bar"+roundlist.size());
       List<WebElement> barList= driver.findElements(By.xpath(verticalBar));
        System.out.println(barList.size());
        String tooltip="//*[local-name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']";
        Actions act = new Actions(driver);
        for (WebElement e:barList){
            act.moveToElement(e).perform();
            Thread.sleep(500);
           String toolTipText= driver.findElement(By.xpath(tooltip)).getText();
            System.out.println(toolTipText);


        }
        driver.close();
    }
}
