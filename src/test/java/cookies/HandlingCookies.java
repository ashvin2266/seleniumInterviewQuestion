package cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public  class HandlingCookies {
    /*
    SDET By Pavan Vedio 29
    Cookies---cookies are a temporary file created by browser while visiting web pages
    Question
    Handling Cookies in Selenium WebDriver
-------
     How To capture cookies from browser?
     How To print cookies from browser?
     How To add Cookie to the browser?
     How To delete specific Cookie from the browser?
     How To delete all Cookies from the browser?
      we used following cookies method
      driver.manage().getCookies();
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
//        How To capture cookies from browser?
       Set<Cookie> cookies= driver.manage().getCookies();
        System.out.println("Size of cookies : "+cookies.size());
//      How To print cookies from browser?
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName()+" ===="+ cookie.getValue());}
//       How To add Cookie to the browser?
            Cookie cookiObj=new Cookie("My new cookies added","abcdqw123458 cookies added");
            driver.manage().addCookie(cookiObj);
            cookies=driver.manage().getCookies();
            System.out.println("Cookies Size After added cookies---->"+cookies.size());

    }
}
