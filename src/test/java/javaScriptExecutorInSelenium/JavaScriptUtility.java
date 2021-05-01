package javaScriptExecutorInSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    public static void flash(WebElement element, WebDriver driver) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i <= 100; i++) {

            changeColour("rgb(0,200,0)", element, driver);
            changeColour(bgcolor, element, driver);
        }
    }

    public static void changeColour(String color, WebElement element, WebDriver driver) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", element);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void drowAborder(WebElement element, WebDriver driver) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border ='3px solid red'", element);
    }

    //    public static void TakeAscreenShot(String scenario) throws IOException {
//
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile(srcFile, new File("./target/screenshots/drowborderpage.png"));}
//        catch (IOException e1){
//            e1.printStackTrace();
//        }}
    public static void generateAlert(WebDriver driver, String message) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public static void clickElementByJs(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    public static void refreshBrowserByJs(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJs(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static String getPageInnerTextByJs(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public static void scrollPageDownByJs(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
   /*     this is use for all height of page scroll down
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    */
//        this is for half height scroll down by js
        js.executeScript("window.scrollTo(0,500)");

    }
    public static void scrollPageUpByJs(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");


    }

    public static void scrollIntoViewByJs(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectDateByJs(WebDriver driver, WebElement element, String dateValue) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);

    }

    public static String getTextOfElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String text = (String) js.executeScript(
                "var e = arguments[0]; " +
                        "return e.innerText !== undefined ? e.innerText : e.textContent",
                element);


        return text;
    }
    public static void zoomPageByJs(WebDriver driver){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("document.body.style.zoom='50%'");

    }

}
