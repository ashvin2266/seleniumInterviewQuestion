package SeleniumCodChalangesByNaveen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day1Chalange {
    static WebDriver driver;
    /*
    Selenium Coding Challenge # Day 1

Open chrome/firefox browser
Launch the URL : https://www.worldometers.info/world-population/

Keep getting the count of:
- Current World Population
- Today:  Births, Deaths and population growth today
- This Year:  Births, Deaths and population growth today

while(true){

 keep getting the element text using selenium
 print it on console

 //break the loop after few secs (20 secs)
}

submit the assignment :
Send your source code and screenshot of the console output.
mail me at : naveenanimation20@gmail.com

===========================
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.worldometers.info/world-population/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        1.Count current world population
      /*  String currentPop="//div[@class='maincounter-number']";
      String currentPopulation= driver.findElement(By.xpath(currentPop)).getText();
        System.out.println("Current population ---"+currentPopulation);
      2.- Today:  Births, Deaths and population growth today
        String birthTodayXpath="//div[@class='col1in']//div[2]//div[2]";
        String birthTodayCount=driver.findElement(By.xpath(birthTodayXpath)).getText();
        System.out.println("Today birth count---"+birthTodayCount);
        String deathTodayXpath="//div[@class='col1in']//div[3]//div[2]";
        String deathToday=driver.findElement(By.xpath(deathTodayXpath)).getText();
        System.out.println("Today death count---"+deathToday);
        String popGrowthTodayXpath="//div[@class='col1in']//div[@class='sec-box-last']//div[@class='sec-counter']";
        String popGrowthToday=driver.findElement(By.xpath(deathTodayXpath)).getText();
        System.out.println("Today pop growth count---"+popGrowthToday);
=======================================================================================================
*/
        String currentPopXpath = "//div[@class='maincounter-number']//span[@class='rts-counter']";
        String today_xpath="//div[text()='Today']//parent::div//span[@class='rts-counter']";
        String year_xpath="//div[text()='This year']//parent::div//span[@class='rts-counter']";
        String today_And_ThisYearXpath="//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
        int count=1;
        while(count<=20){
            System.out.println(count+" Second");
            if (count==21)break;
            System.out.println("================CURRENT POPULATION DATA==========");
          printPopulationData(currentPopXpath);
//            System.out.println("================ TODAY POPULATION DATA==========");
//            printPopulationData(today_xpath);
//            System.out.println("================THIS YEAR POPULATION DATA==========");
//          printPopulationData(year_xpath);
             System.out.println("=================TODAY AND THIS YEAR POPULATION COUNT");
            printPopulationData(today_And_ThisYearXpath);

            System.out.println("*********************************************");

            Thread.sleep(1000);
            count++;
          }

        }

    public static void printPopulationData(String locator) throws InterruptedException {
           List<WebElement> currentPopele = driver.findElements(By.xpath(locator));
            for (WebElement currentPop : currentPopele) {
                System.out.println(currentPop.getText());

            }
                    }


}
