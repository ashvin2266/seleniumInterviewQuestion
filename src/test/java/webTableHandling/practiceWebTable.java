package webTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class practiceWebTable {
    /*
    i want to go return item  web table and collect the data of   return id ,order id and customer from page 1 to page 5
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input#input-username")).clear();
        driver.findElement(By.cssSelector("input#input-username")).sendKeys("demo");
        driver.findElement(By.cssSelector("input#input-password")).clear();
        driver.findElement(By.cssSelector("input#input-password")).sendKeys("demo");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.findElement(By.cssSelector("#menu-sale")).click();
        driver.findElement(By.cssSelector("li[id='menu-sale'] li:nth-child(3)")).click();
        String pages=driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        System.out.println(pages);
        int totalStartPage=pages.indexOf("(");
        int endPage=pages.indexOf("Pages)");
        String totalPage=pages.substring(totalStartPage+1,endPage);
        System.out.println("Total pages of webTable is --->"+totalPage);
//    here total page is 1600 but we need to page upto 6 only
       List<WebElement>pageNavigation= driver.findElements(By.xpath("//ul[@class='pagination']/li"));
        System.out.println(pageNavigation.size());
        List<WebElement> totalRowElement = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"));
        System.out.println("Total row is ---->" + totalRowElement.size());
        List<WebElement> totalColumnElement = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead//td"));
        System.out.println("Total Column is ---->" + totalColumnElement.size());

        for (int p=0;p<10;p++) {
               WebElement activePageEle = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
                     activePageEle.click();
                System.out.println("Active page no is --->" + activePageEle.getText());
                for (int r=1;r<totalRowElement.size();r++){
                  String returnId= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[2]")).getText();
//                    System.out.println(returnId);
                  String orderId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[3]")).getText();
//                    System.out.println(orderId);
                  String  customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[4]")).getText();
                    System.out.println("  "+returnId+"       "+orderId+ "       "+ customer);
                }
//                String pageno=Integer.toString(p+1);
                driver.findElement(By.xpath("//a[normalize-space()='>']")).click();


        }

           }
}
