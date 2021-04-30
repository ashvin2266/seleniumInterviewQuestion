package webTableHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableHandling {
//    SDET By Pavan Vedio no 20
    /*Question about web table handling
    1. How to find how many raws in table
    2. How many column present in table
    3. How to retrieve the specific raw or column data
    4. How to retrieve all the data from table
    5. How to print Release date, version no of Java language of selenium from table

    */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

//        1. How to find the total raw in table
        List<WebElement> rawElement = driver.findElements(By.xpath("//table[@class='data-list']//tbody//tr"));
        System.out.println("Total raw available in a table= " + rawElement.size());

//        2. How to find the total column in table
        List<WebElement> columnElement = driver.findElements(By.xpath("//table[@class='data-list']//thead//tr//th"));
        System.out.println("Total column is available in table is  " + columnElement.size());

//        3. How to retrieve the specific raw and table data
//         I want to retrive the data from second raw 1st and 2nd column its should be java language
//         and 3.141.59 version data
        WebElement languageJava = driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr[2]//td[1]"));
        System.out.println("Data from 2nd raw and first column is----->" + languageJava.getText());
        WebElement versionJava=driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr[2]//td[2]"));
        System.out.println("Data from 2nd raw and second  column is----->" + versionJava.getText());
//        4. How to retrieve the all data from table

        for (int i=1;i<=rawElement.size();i++){
            for (int j=1;j<=columnElement.size();j++){
                WebElement data=driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr["+i+"]//td["+j+"]"));
                System.out.print("    "+data.getText()+"    ");
            }
            System.out.println();
        }
//       5. How to print Release date, version no of Java language of selenium from table
        for (int r=1;r<=rawElement.size();r++){
            WebElement languageElement=driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr["+r+"]//td[1]"));
            String language=languageElement.getText();
            if (language.equals("Java")){
                WebElement versionNo=driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr["+r+"]//td[2]"));
                WebElement releaseDate=driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr["+r+"]//td[3]"));
                System.out.println(language+"      "+versionNo.getText()+"     "+releaseDate.getText());
            }
        }
    }
}