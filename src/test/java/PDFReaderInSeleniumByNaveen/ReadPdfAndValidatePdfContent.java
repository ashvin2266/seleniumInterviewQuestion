package PDFReaderInSeleniumByNaveen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadPdfAndValidatePdfContent {
   public static WebDriver driver;
   public static String url="file:///C:/Users/ashvi/SeleniumInterviewQuestion/downloadFile/sample.pdf";
    /* In THIS HOW TO READ PDF FILE BY USING PDF BOX DEPENDENCIES*/
    /*
    first we need to add pdfbox dependencies in pom file
    * */
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        pdfReaderTest();



    }
    public static void pdfReaderTest() throws IOException {
        /*first create a object of URL class
        * create as stream and connect url returns input stream import from java io
        * crate one buffred input stream and then load pdf document */
        URL pdfUrl=new URL(url);
        InputStream ip = pdfUrl.openStream();
        BufferedInputStream bf=new BufferedInputStream(ip);
        PDDocument pdDocument=PDDocument.load(bf);
        // how many pages on pdf file use this method
        int totalPage =pdDocument.getNumberOfPages();
        System.out.println("Total No of pages ="+totalPage);
        /*pdf content of all pages BY USING PDFTeststipperclass*/
        System.out.println("=========================PDF content of all page==========");
        PDFTextStripper pdfStripper=new PDFTextStripper();
       String textContentOfAllPdf= pdfStripper.getText(pdDocument);
        System.out.println(textContentOfAllPdf);
        Assert.assertTrue(textContentOfAllPdf.contains("A Simple PDF File"));
        /*
        set page no and get text from this page only
         */
        System.out.println("===================PDF content of Page 3 and 4");
        pdfStripper.setStartPage(2);
        String textContentOfPageFrom2=pdfStripper.getText(pdDocument);
        System.out.println(textContentOfPageFrom2);
        Assert.assertTrue(textContentOfPageFrom2.contains("The end, and just as well"));
        driver.close();


    }
}
