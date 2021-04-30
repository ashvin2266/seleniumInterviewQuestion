package browserWindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {
//    SDET By Pavan Vedio 15
    /*INTERVIEW QUESTION
    1) How To Handle Browser Windows in Selenium WebDriver?
    we handle browser window in selenium by using getWindowHandle() and getWindowHandles() method
    2) What is the Difference between getWindowHandle() & getWindowHandles() methods?
    getWindowHandle()----returns a single window Id
    getWindowHandles()---returns multiple window Id

    3) How To Switch between Multiple Browser Windows?
    By using driver.switchTo()window(childWindowId);
    4) What is the difference between close() and quite() methods?
    driver.close()----close the browser which is in  focus
    driver.quite()-----close the all open  browsers
    5) How to close All browser Windows?
    By using driver.quite() method
    6) How To close Specific Browser Window by choice?
    By using driver.close() method

     */
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://demo.nopcommerce.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
//    driver.getWindowHandle()
   String windowID= driver.getWindowHandle();
    System.out.println(windowID);//CDwindow-0CA31D0F0EE9B0DA0274FCA7C6122531 its give diff everytime
    System.out.println("Title of the parent window----"+driver.getTitle());
//    driver.getWindowHandles()
//    its return set of multiple window ids
    driver.findElement(By.xpath("//a[text()='Facebook']")).click();
    driver.findElement(By.xpath("//a[text()='Twitter']")).click();
    Set<String> windowIds=driver.getWindowHandles();
//   we need to iterate set object by diff method
//    1.By Iterator
  /*  Iterator<String>it =windowIds.iterator();
    String parentWindowId=it.next();
    System.out.println(parentWindowId);
    String childWindowId=it.next();
    System.out.println(childWindowId);
    String secondChildWindowid=it.next();
    System.out.println(secondChildWindowid);

//then switch to child window and get title of the page
    driver.switchTo().window(childWindowId);
    Thread.sleep(2000);
    System.out.println("Child window title is----"+driver.getTitle());
    driver.switchTo().window(secondChildWindowid);
    System.out.println("Second child window title is---"+driver.getTitle());
//    driver.close();//its close only current browser
    driver.quit();// its close all browser window

   */
//  2 nd method by using List
    List<String > windowIdlist=new ArrayList<String>(windowIds);
   /* String parentId=windowIdlist.get(0);
    System.out.println("parentID --"+parentId);
    String childId=windowIdlist.get(1);
    System.out.println("child id ---"+childId);
    String childId1=windowIdlist.get(2);
    System.out.println("child1 id---"+childId1);
    driver.switchTo().window(childId1);
    System.out.println("title of child1 window----"+driver.getTitle());
*/
   for (String winId:windowIdlist){
         String title= driver.switchTo().window(winId).getTitle();
       System.out.println("Title of window----"+title);
       Thread.sleep(2000);
   }
//   how to close specific browser window
    for (String winId:windowIdlist){
        String title= driver.switchTo().window(winId).getTitle();
        System.out.println("Title of window----"+title);
        if (title.equalsIgnoreCase("NopCommerce - Home | Facebook")){
            driver.close();
            break;
        }
        Thread.sleep(2000);
    }

}
}
