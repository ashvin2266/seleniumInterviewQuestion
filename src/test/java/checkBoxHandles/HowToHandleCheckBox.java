package checkBoxHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HowToHandleCheckBox {
//    SDET  BY PAVAN VEDIO 14
    /* question
    1.how to select a specific checkbox?
    2.How to select all checkbox?
    3.How to select multiple checkbox by choice?
    4.How to select last 3 checkboxes?
    5.How to select first 3 checkboxes?
     */
    public static void main(String[] args) {
//        selectCheckbox();
        selectAllCheckbox();
//        selectLastCheckboxes();

    }

    public static void selectCheckbox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
//        1.how to select a specific checkbox e.g select Tuesday checkbox
        driver.findElement(By.xpath("//input[@id='tuesday']")).click();
        driver.close();
    }
    public static void selectAllCheckbox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
//        driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
    List<WebElement> allCheckBoxElement=   driver.findElements(By.xpath("//input[contains(@id,'day')]"));

        /* select all checkbox use this
        for (WebElement allCheckbox:allCheckBoxElement){
        allCheckbox.click();
        driver.close();*/
//     3. how to select multiple checkboxes of your choice like to select monday and friday
        for (WebElement checkbox:allCheckBoxElement)  {
            String checkboxName=checkbox.getAttribute("id");
            if (checkboxName.equals("monday")||checkboxName.equals("friday")){
                checkbox.click();
            }
        }
        }
        public static void selectLastCheckboxes()
        {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.get("https://itera-qa.azurewebsites.net/home/automation");
            driver.manage().window().maximize();
            List<WebElement> allCheckBoxElement=   driver.findElements(By.xpath("//input[contains(@id,'day')]"));
/*           how to select last 3 checkbox use this
             total no.checkbox-no.of checkbox to select =start index
            here 7-3=4
            for (int i=allCheckBoxElement.size()-3;i<=allCheckBoxElement.size();i++){
                allCheckBoxElement.get(i).click();*/

//             how to select first 3 checkbox

            for (int i=0;i<allCheckBoxElement.size();i++) {
                if (i < 3) {
                    allCheckBoxElement.get(i).click();
                }
            }



        }
}
