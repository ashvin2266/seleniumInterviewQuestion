package downloadFileInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;

public class DownloadPdfFileInSelenium {
    /*
    SDET VEDIO 30
    In case of pdf file download when you click on download link its open in browser in view mode
    then we  click on download and file download but we need to direct
    download in desired location without view mode.
    every thing same as download word file in chrome ,edge and firefox browser but we need to add more
    preference
     */
    public static void main(String[] args) throws InterruptedException {
//        download pdf file in Chrome Browser
//        How to download the pdf files into the custom directory ?
        /*
                String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
//        first step to make Hashmap to store the preference in key value pair
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true);//this preference is only for pdf file
        preferences.put("download.default_directory",location);// its responsible to store file in location value
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);// we need to give key prefs
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();


//        how to download pdf file in edge browser
//        we need to do same as chrome browser
        String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
//        first step to make Hashmap to s"tore the preference in key value pair
        HashMap preferences=new HashMap();
        preferences.put("plugins.always_open_pdf_externally",true);//this preference is only for pdf file
        preferences.put("download.default_directory",location);// its responsible to store file in location value
        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("prefs",preferences);// we need to give key prefs
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
*/
//        how to open pdf file in firefox browser
        String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
        FirefoxProfile profile=new FirefoxProfile();
//      we need to find mime type list its use in preference value here is application/pdf
        profile.setPreference("pdfjs.disabled",true);// for pdf file
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
        profile.setPreference("browser.download.folderList",2);//here 0 is for desktop.1--for download and 2 for desired location
//        if you provide folderlist option 1 and 2 do not need next step for location
        profile.setPreference("browser.download.dir",location);
        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profile);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
    }
}
