package Pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public By email_input_Box = By.xpath("//input[@name='email']");
    public By password_input_Box = By.xpath("//input[@name='password']");
    public By login_btn = By.xpath("//button[normalize-space()='Login']");
    public By error_msg = By.xpath("//input[@name='password']/following-sibling::p");

    public void navigateToLoginPage(){

        HomePage homePage = new HomePage();
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_Signup);
    }


}
