package seleniumInterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextVsGetAttributeValue {
//    SDET BY PAVAN VEDIO NO 7
    /*Interview question
    1.How enter and clear text from input box
    2. How to capture text from Input box
    3. What is the difference between getText() and getAttribute("Value") method
    Answer
    get text---returns the inner text of an element
    get attribute---- method fetches the text contained by an attribute in an html documents



    get attribute()---> returns attribute value like
    <input class="email valid" autofocus="" type="email" data-val="true"
     data-val-email="Wrong email" data-val-required="Please enter your email"
      id="Email" name="Email" aria-describedby="Email-error" aria-invalid="false">
      if we use get attribute method it gives following result like
      getAttributr("name")----Email
      getAttributr("class")--- email

      so its return attribute value
      while getText method returns inner text like
      <button type="submit" class="button-1 login-button">Log in</button>
      here log in is a inner text



     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
       WebElement emailInputBox= driver.findElement(By.xpath("//input[@id='Email']"));
       emailInputBox.sendKeys("abcd@gmail.com");
        System.out.println( "get text by attribute "+emailInputBox.getAttribute("value"));
        System.out.println("Get text by get text"+emailInputBox.getText());//its give empty because no inner text here
        WebElement welcomeTextElement=driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        System.out.println("get text by get text "+ welcomeTextElement.getText());//it give text because its having inner text in html
        Thread.sleep(2000);
        emailInputBox.clear();
//        try for login button for both method
        WebElement loginBtn=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        System.out.println("Get text by using getAttribute ---->"+ loginBtn.getAttribute("class"));
        System.out.println("Get text by using getText ---->"+ loginBtn.getText());
    }
}
