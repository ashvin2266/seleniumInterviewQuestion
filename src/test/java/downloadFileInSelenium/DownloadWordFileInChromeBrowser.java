package downloadFileInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadWordFileInChromeBrowser {
//    SDET By Pavan Vedio 30
    /*
    How to download the files using the selenium WebDriver?
-Chrome
-Edge
-Firefox
How to download the files into the custom directory ?
How to change the download file location using selenium WebDriver?
How to download the embedded PDF file ?
How to download the PDF file using selenium WebDriver?
What is Browser Profile in Firefox?
What is Mime Type?
     */
    public static void main(String[] args) {
      /*  WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

        when you click on download link its download in default download folder but
        if you need to download in your specified location or customise location
         you need to add some preference in browser setting option

         */
//        How to download the files into the custom directory ?
        String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
//        first step to make Hashmap to s"tore the preference in key value pair
        HashMap preferences=new HashMap();
        preferences.put("download.default_directory",location);// its responsible to store file in location value
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);// we need to give key prefs
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();

    }




}
