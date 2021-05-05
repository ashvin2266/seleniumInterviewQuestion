package downloadFileInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;

public class DownloadWordFileInEdgeBrowser {
    public static void main(String[] args) {
//        we need to do same as chrome browser
        String location=System.getProperty("user.dir")+"\\downloadFile"+"\\";
//        first step to make Hashmap to s"tore the preference in key value pair
        HashMap preferences=new HashMap();
        preferences.put("download.default_directory",location);// its responsible to store file in location value
        EdgeOptions options=new EdgeOptions();
        options.setExperimentalOption("prefs",preferences);// we need to give key prefs
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
    }
}
