package seleniumInterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToCheckElementDisplayedEnableSelected {
//    SEE SDET BY PAVAN VEDIO NO 4
/*    Question
    1.How to check webElement is Displayed,Enable and Selected ?
    By using isDisplayed(),isEnabled() and isSelected() method available in selenium webdriver
    we also called as conditional command
   Difference between isDisplayed(), isEnabled() and isSelected() Methods in Selenium WebDriver:

1. isDisplayed() is the method used to verify the presence of a web element within the web page.
 The method returns a “true” value if the specified web element is present on the web page
 and a “false” value if the web element is not present on the webpage.
2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
4. isEnabled() is primarily used with buttons.
5. isSelected() is the method used to verify if the web element is selected or not. 6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes.
 */
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver =new ChromeDriver();
    driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
//    isDisplayed() method and isEnabled()method
    WebElement loginElement=driver.findElement(By.linkText("Log in"));
    System.out.println("Status of login element is displayed-----"+loginElement.isDisplayed());
    System.out.println("Status of login element is enabled or not-----"+loginElement.isEnabled());

// isSelected() method ---radiobutton,checkbox,dropdown
    WebElement malegenderElement=driver.findElement(By.id("gender-male"));
    WebElement femaleElement=driver.findElement(By.id("gender-female"));
    System.out.println("Status of Male Radiobutton selected or not-----" +malegenderElement.isSelected() );
    System.out.println("Status of female Radiobutton selected or not-----" + femaleElement.isSelected() );
    malegenderElement.click();
    System.out.println("Status of Male Radiobutton selected or not-----" +malegenderElement.isSelected() );
    System.out.println("Status of female Radiobutton selected or not-----" +femaleElement.isSelected() );
    femaleElement.click();
    System.out.println("Status of Male Radiobutton selected or not-----" +malegenderElement.isSelected() );
    System.out.println("Status of female Radiobutton selected or not-----" +femaleElement.isSelected() );
}

}
