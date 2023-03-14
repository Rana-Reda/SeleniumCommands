import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T04_Dropdown_Static_Dynamic {

    //declare a webdriver object
    WebDriver driver;
    @BeforeMethod
    public void openBrowser() {

        //1-bridge between code and browser
        String value=System.getProperty("user.dir")+"\\Browsers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",value);

        //2-create new web driver object
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);

        //3-configuration to browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void staticTest() throws InterruptedException {

        //navigate to browser
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //define webElement for the list
        WebElement list= driver.findElement(By.id("dropdown"));
        //create new object from select list
        Select dropList= new Select(list);
        //select options
        Thread.sleep(200);
        dropList.selectByIndex(1);
        Thread.sleep(200);
        dropList.selectByValue("2");
        Thread.sleep(200);

    }

    @Test
    public void dynamicTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(2000);
        List<WebElement> list= driver.findElements(By.cssSelector("li[class=\"sbct\"]"));
        list.get(6).click();

    }

    @AfterMethod

    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
