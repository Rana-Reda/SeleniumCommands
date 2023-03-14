import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class T02_InteractingWithWebElements {

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

        //4-navigate to website
        String url="https://www.google.com/";
        driver.get(url);

    }

    @Test
    public void Browser() throws InterruptedException {

        driver.findElement(By.cssSelector("input[class=\"gLFyf\"]")).sendKeys("selenium");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class=\"gLFyf\"]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class=\"gLFyf\"]")).sendKeys("testng");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[class=\"gLFyf\"]")).sendKeys(Keys.ENTER);

    }

    @AfterMethod

    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
