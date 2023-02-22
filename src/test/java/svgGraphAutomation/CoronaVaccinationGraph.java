package svgGraphAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CoronaVaccinationGraph {

    public static void main(String[] args) throws ParseException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.co.uk/search?q=covid+cases" +
                "+in+uk&sxsrf=AOaemvJaotHDrsywE6rs4ISRUNlkVZC75Q%3A1632864609734&source=hp&ei=" +
                "YYlTYaaXKq_DlwSynLMw&iflsig=ALs-wAMAAAAAYVOXcW4hN97Q_VYs-XeWKfYJVOXcQVnP&oq=" +
                "covid+cases+in+uk&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyCAgAEIAEELEDMgUIABCABDIFCAAQg" +
                "AQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6EQguEIAEELEDEMcBEKMC" +
                "EJMCOg4ILhCABBCxAxDHARCjAjoICC4QsQMQgwE6CwgAEIAEELEDEIMBOgsIABCABBCxAxDJAzoFCAAQkg" +
                "M6CAgAELEDEIMBOggIABCABBDJA1DnyA5Y7fAOYI-JD2gAcAB4AIABU4gB0AiSAQIxN5gBAKABAQ&sclient" +
                "=gws-wiz&ved=0ahUKEwjmy5vYzqLzAhWv4YUKHTLODAYQ4dUDCAk&uact=5");
        driver.findElement(By.cssSelector("button#L2AGLb")).click();
        driver.manage().window().maximize();
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,2800)");

        WebElement graphEle=driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[4]"));

        int topLeftY=(graphEle.getSize().getHeight()/2)-(graphEle.getSize().getHeight());
        int topLeftX=(graphEle.getSize().getWidth()/2)-(graphEle.getSize().getWidth());

        String start_date="13-12-2020";
        SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
        Date d1=sdf.parse(start_date);
        Date d2=new Date();
        long diffInDays= TimeUnit.MILLISECONDS.toDays(d2.getTime()-d1.getTime());
        System.out.println(diffInDays);

        Actions act =new Actions(driver);
        for (int i=0;i<diffInDays;i++) {
            act.moveToElement(graphEle, topLeftX+i, topLeftY).perform();
            String data=driver.findElement(By.xpath("//table[@class='F9Gkq']/tbody")).getText();
            System.out.println(data);
        }


    }
}
