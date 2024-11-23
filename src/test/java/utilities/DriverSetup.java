package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    private static String browserName = System.getProperty("browser", "Chrome");
    private static  final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_DRIVER.set(driver);
    }
    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get();
    }



    public  WebDriver getBrowser(String browser_name){
        if (browser_name.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();

        else if(browser_name.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();

        else if(browser_name.equalsIgnoreCase("Edge"))
            return new EdgeDriver();

        else {
            throw new RuntimeException("Browser is not available with the name:" + browser_name);
        }

    }


    @BeforeMethod
    public void openABowser(){
        WebDriver driver = getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
        setDriver(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }


}

