package HandleLinkAndBrokenLink;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleLinkAndBrokenLinks {
//    SDET By Pavan Vedio 16
    /*
     How To Locate links in Selenium WebDriver?
     ---> all links is represented by anchor tag "a" attribute in html
     What is the difference between LinkText() and PartialLinkText()?
     ---->in link text you need to give full text  but in partial link you can provide part of link text
     How to capture all the links from Web Page?
     -----> driver.findElements(BY.tagname("a"));its returns  all link present in page in List of webelements
     What is Broken Link? How to check it?
     ----->we find all link --->capture link which have href attribute
     --->then check its give 200ok response code
     */
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.amazon.co.uk/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();

//    locate link by link text or partial link text
//    driver.findElement(By.linkText("Customer Service")).click();
//    driver.findElement(By.partialLinkText("Orders")).click();

//    How to capture all links present on page
   List<WebElement> linkLists=driver.findElements(By.tagName("a"));
    System.out.println("total link present on page: "+ linkLists.size());
//    how to print on console
    for (int i=0;i<linkLists.size();i++){
//        System.out.println(linkLists.get(i).getText());
        System.out.println(linkLists.get(i).getAttribute("href"));
    }
}
}
