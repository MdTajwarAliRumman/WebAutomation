package testcases;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {

    HomePage homePage = new HomePage();

    @AfterMethod
    public void addScreenshotAfterTest(){
        homePage.addScreenShots();
    }

    @Test
    public void testHomePageURL(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageURL(), homePage.url);
    }

    @Test
    public void testHomePageTitle(){
        Assert.assertEquals(homePage.getPageTitle(),homePage.Title);
    }
}
