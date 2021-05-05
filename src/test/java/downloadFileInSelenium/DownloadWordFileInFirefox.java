package downloadFileInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadWordFileInFirefox {
    /*
    In case of firefox browser we get one challenge is when you click download button
    its show the window in which file is open by default its not asking in chrome and edge
    browser for that we need to disable in setting by using firefox profile class and make some
    preferences.
     */
    public static void main(String[] args) {
        String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
        FirefoxProfile profile=new FirefoxProfile();
//      we need to find mime type list its use in preference value here is application/msword
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/msword");
        profile.setPreference("browser.download.folderList",2);//here 0 is for desktop.1--for download and 2 for desired location
//        if you provide folderlist option 1 and 2 do not need next step for location
        profile.setPreference("browser.download.dir",location);
        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
    }
}
