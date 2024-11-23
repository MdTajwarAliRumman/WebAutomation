package testcases;

import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {

    HomePage homePage = new HomePage();

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void loadTestPage(){
        loginPage.navigateToLoginPage();
    }

    @AfterMethod
    public void addScreenshotAfterTest(){
        homePage.addScreenShots();
    }

    @Test(description = "Test with valid credentials")
    @Description("User is trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
//    testLoginWith
    public void ValidCredentials(){

        loginPage.writeOnElement(loginPage.email_input_Box,"xikolek393@cironex.com");
        loginPage.writeOnElement(loginPage.password_input_Box, "12345");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertTrue(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertFalse(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
//    testLoginWith
    public void InvalidCredentials(){

        loginPage.writeOnElement(loginPage.email_input_Box,"xikolek393@cironex");
        loginPage.writeOnElement(loginPage.password_input_Box, "145");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Your email or password is incorrect!");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
//    testLoginWith
    public void InvalidEmailAndPass(){

        loginPage.writeOnElement(loginPage.email_input_Box,"xikolek393@cironex");
        loginPage.writeOnElement(loginPage.password_input_Box, "12345");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Your email or password is incorrect!");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }


    @Test
//    testLoginWith
    public void ValidEmailAndInvalidPass(){

        loginPage.writeOnElement(loginPage.email_input_Box,"xikolek393@cironex.com");
        loginPage.writeOnElement(loginPage.password_input_Box, "15");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Your email or password is incorrect!");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
//    testLoginWithOut
    public void BlankEmailandPassField(){

        loginPage.writeOnElement(loginPage.email_input_Box,"");
        loginPage.writeOnElement(loginPage.password_input_Box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),"Please fill out this field.");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test
//    testLoginWithOut
    public void BlankEmailFieldandPass(){

        loginPage.writeOnElement(loginPage.email_input_Box,"");
        loginPage.writeOnElement(loginPage.password_input_Box, "12345");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_input_Box).getAttribute("validationMessage"),"Please fill out this field.");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }


    @Test
//    testLoginWithOut
    public void EmailandBlankPassField(){

        loginPage.writeOnElement(loginPage.email_input_Box,"xikolek393@cironex.com");
        loginPage.writeOnElement(loginPage.password_input_Box, "");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_Box).getAttribute("validationMessage"),"Please fill out this field.");
//        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
//    testLoginWithOut
    public void testLoginWithInvalidCredentials(String email, String passward, String error_msg, String validationMsg){

        loginPage.writeOnElement(loginPage.email_input_Box, email);
        loginPage.writeOnElement(loginPage.password_input_Box, passward);
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertEquals(loginPage.getElement(loginPage.email_input_Box).getAttribute("validationMessage"),validationMsg);
        Assert.assertEquals(loginPage.getElement(loginPage.password_input_Box).getAttribute("validationMessage"),validationMsg);
        if(loginPage.is_element_visible(loginPage.error_msg))
        Assert.assertEquals(loginPage.getElement(loginPage.error_msg).getText(),error_msg);

        //        Assert.assertFalse(homePage.is_element_visible(homePage.logout_btn));
        Assert.assertTrue(loginPage.is_element_visible(loginPage.login_btn));
    }





}
