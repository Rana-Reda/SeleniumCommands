import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T03_webElementsStatus_EnabledAndSelected {

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
        String url="https://the-internet.herokuapp.com/";
        driver.get(url);

        //5-click on checkboxes
        driver.findElement(By.cssSelector("a[href=\"/checkboxes\"]")).click();

    }

    @Test
    public void Browser() {

        //check is enabled status for checkbox1
        boolean box1Enable= driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).isEnabled();
        System.out.println(box1Enable);
        //check is selected status for checkbox1
        boolean box1Select= driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).isSelected();
        System.out.println(box1Select);

        //check is enabled status for checkbox2
        boolean box2Enable= driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(1).isEnabled();
        System.out.println(box2Enable);

        //check is selected status for checkbox2
        boolean box2Select= driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(1).isSelected();
        System.out.println(box2Select);



    }

    @AfterMethod

    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
