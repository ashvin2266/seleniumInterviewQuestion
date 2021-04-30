package SeleniumInterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementVsFindElements {
    /* vedio of SDET VEDIO 6
    What is the difference between find element and find elements method
    scenario                                  find element()                         find elements()
    1. single web element present------>Returns single web element  ----- Returns single webelement
    2.multiple web element present-----Returns first element-----        Returns all of web elements
    3.element not present---   Gives no such element exception--------does not give any exception but returns zero element
    4.Return type-------------Returns single web element------------Return list< Web element>elements list
    5.Access                          direct access on element      we need to iterate elements by loop and then access on element
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");

//        scenario 1.using find element()

       WebElement searchEle= driver.findElement(By.xpath("//input[@id='small-searchterms']"));
       searchEle.sendKeys("computers");
//       using find elements
       List<WebElement>listOfSearchElement= driver.findElements(By.xpath("//input[@id='small-searchterms']"));
        System.out.println(listOfSearchElement.size());
//        scenario 2 having multiple webElement on page
//        find element method find first element present on page and find elements gives all webelement list
       WebElement footerLink= driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(footerLink.getText());

       List<WebElement> linkList=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("total webelement present on footer is----->"+linkList.size());

//        scenario 2 About exception eg. given xpaistth is not available find element gives no such element exception and
//        find elements does not throw any exception it gives zero
        System.out.println("find elements does not throw exception its give zero output");
        List<WebElement> linkList2=driver.findElements(By.xpath("//div[@class='footer-upper']//h1"));
        System.out.println("find elements does not throw exception its give zero output----->"+ linkList2.size());
     /*   System.out.println("find element  throw exception No such element present");
        WebElement linkelement=driver.findElement(By.xpath("//div[@class='footer-upper']//h1"));*/

//        scenario 4 access
        List<WebElement> footerLinkList=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println("total webelement present on footer is----->"+footerLinkList.size());
        for (WebElement link:footerLinkList){
            System.out.println( link.getText());
        }

    }
}
