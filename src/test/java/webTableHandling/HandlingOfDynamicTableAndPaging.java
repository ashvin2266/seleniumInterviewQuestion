package webTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingOfDynamicTableAndPaging {
//    SDET BY PAVAN VEDIO 21
// How to handle dynamic webtable with pagination in selenium?

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement username=driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");
        WebElement password=driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
//        1. how to find total no. of pages in table
//        there is two method
//        1. click last pages arrow and then grab last page locator
       /* driver.findElement(By.xpath("//a[normalize-space()='>|']")).click();
      String totalnoofPages=  driver.findElement(By.xpath("//span[normalize-space()='427']")).getText();
        System.out.println("Total number of pages in web table is--->"+totalnoofPages);*/
//       2. grabe the text showing total no of pages message
//        first grab the text showing in page ---->  Showing 1 to 20 of 8528 (427 Pages)
        /*
        text=Showing 1 to 20 of 8528 (427 Pages)
        we need to capture the 427 only by using diff string method
        we find index of "(" and "Pages) then we use substring method and pass starting index value and
        finish index value
        indexOf();
        subString();
         */
      String text=  driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();
        System.out.println(text);
       int indexOfStart= text.indexOf("(");
       int indexofEnd=text.indexOf("Pages)");
       String Page=text.substring(indexOfStart+1,indexofEnd-1);
//       here value comes in string but we need integer so convert string to integer
        int totalPage=Integer.valueOf(Page);
        System.out.println("Total pages in web table is------>"+totalPage);
//        2nd task capture how many raw in each page in webTable
//        here data is too much for 427 page thats why i given only for 4 page otherwise
//        for(int p=1;p<=totalPage;p++)
        for (int p=1;p<=4;p++){
            WebElement activePage=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
            String  active_Page=activePage.getText();
            activePage.click();
            System.out.println("Active page is----"+active_Page);
           int row=    driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Total row present in page no "+active_Page+"---->"+row);
//            how many column in webtable
            int column=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[1]//td")).size();
            System.out.println("Total column present in webtable= "+column);
//            3. how to read all row from each page
           /*this is for all row and all column use this for loop
            for (int r=1;r<=row;r++){

                for (int c=2;c<column;c++){
                    String coloumName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']" +
                            "//tbody//tr["+r+"]//td["+c+"]")).getText();
                    System.out.print(coloumName+"    ");
//                    Thread.sleep(2000);
                }
                System.out.println();
                */
           for (int r=1;r<=row;r++){
               String cusromerId=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']" +
                       "//tbody//tr["+r+"]//td[2]")).getText();
               String customer=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']" +
                       "//tbody//tr["+r+"]//td[3]")).getText();
               String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']" +
                       "//tbody//tr["+r+"]//td[4]")).getText();
               if (status.equals("Pending")) {
                   System.out.println(cusromerId + "       " + customer + "             " + status);
               }
           }
            String pageNo=Integer.toString(p+1);
            driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageNo+"']")).click();

      }














        driver.close();
    }
}
