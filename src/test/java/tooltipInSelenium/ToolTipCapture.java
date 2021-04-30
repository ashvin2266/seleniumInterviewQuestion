package tooltipInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipCapture {
    /*
    SDET By pavan Vedio 27
    Tooltip means when you mouse hoover to some element and
     you get some text in pop up like its called tooltips
     so how to capture tooltip text and verify in selenium
     Interview Question like
     How to capture tooltip of the Web Element?
     How to open a link in new tab?
     How to open URL’s in a multiple tabs & Windows?
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();
//        How to capture tooltip of the web element ?
        WebElement frameEle=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameEle);
        WebElement inputBox=driver.findElement(By.id("age"));
        String toolTipText=inputBox.getAttribute("title");
        System.out.println(toolTipText);
//        second tooltip
        WebElement themeRoller=
                driver.findElement(By.xpath("//a[text()='ThemeRoller']"));
        String themeRollerTooltipText=themeRoller.getAttribute("title");
        System.out.println(themeRollerTooltipText);
//        3rd tooltip
        WebElement toolTip=driver.findElement(By.xpath("//a[text()='Tooltips']"));
        String  toolTipsText=toolTip.getAttribute("title");
        System.out.println(toolTipsText);



    }
}
