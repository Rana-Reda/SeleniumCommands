import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T05_MultipleWindowsTaps {

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
        driver.get("https://demo.nopcommerce.com/");

        //click on facebook link
        driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();

        //put the taps into arraylist
        ArrayList<String> taps= new ArrayList<>(driver.getWindowHandles());

        //switch to tap1 from tap0
        driver.switchTo().window(taps.get(1));

        //assert that current url contais facbook.com
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));


    }



    @AfterMethod

    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
