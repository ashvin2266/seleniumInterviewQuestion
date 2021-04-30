package SeleniumInterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunceBrowser {
    public static void main(String[] args) {
//        SDET BY PAVAN VEDIO 3
        /* Interview question
        1. How to launch browser in web driver ?
        2. How to open URL in browser ?
        3. How to capture the title of the page ?
        4. How to capture the page source of the page ?


        we need to download browser driver
        for chrome driver ----chromedriver.exe file
        for firefox driver-----geckodriver.exe file
        for edge driver------edgedriver.exe file and then need to use S
        System.setProperty("webdriver.chrome.driver","give the path of chromedriver.exe file"
        then
        use WebDriver driver= new ChromeDriver();
        HERE webdriver is an interface and chromedriver is a class
        here driver is a variable reference of chromedriver

         */

//     1. How to launch browser in web driver ?
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        //     2. How to open URL in browser ?
        driver.get("http://automationpractice.com/index.php?");
//        3. How to capture the title of the page ?
       String pageTitle= driver.getTitle();
        System.out.println("Page title of the page---->"+pageTitle);
//          4. How to capture the page source of the page ?
        System.out.println("Page source of the page is-------->"+driver.getPageSource());

    /* System.setProperty("webdriver.chrome.driver","C:\\Users\\ashvi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
     WebDriver driver =new ChromeDriver();
     driver.get("http://automationpractice.com/index.php?");

     */
      }
}