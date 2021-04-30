package HandleLinkAndBrokenLink;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HowToFindBrokenLink {
//    How to find broken link
public static void main(String[] args) throws MalformedURLException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();driver.get("http://www.deadlinkcity.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();


   List<WebElement> listOfLink=driver.findElements(By.tagName("a"));
   int brokenLink=0;
   for (WebElement element:listOfLink){
       String url=element.getAttribute("href");
       if (url==null ||url.isEmpty()){
           System.out.println("Url is null or IsEmpty ");
           continue;
       }
       URL Link= new URL(url);
       try {
//           Thread.sleep(3000);
           HttpURLConnection connection = ((HttpURLConnection) Link.openConnection());
           connection.connect();
           if (connection.getResponseCode() >= 400) {
               System.out.println(connection.getResponseCode() + url + " is " + " a BrokenLink");
               brokenLink++;
           } else {
               System.out.println(connection.getResponseCode() + url + " is " + " a Valid link");
           }
           connection.disconnect();
       }
      catch (IOException e) {
               e.printStackTrace();
           }


   }
    System.out.println("Total Broken link "+brokenLink);

}
}
