package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
   public String url = "https://automationexercise.com/";

   public String Title = "Automation Exercise";

   public By login_Signup = By.xpath("//a[normalize-space()='Signup / Login']");

   public By logout_btn = By.xpath("//a[normalize-space()='Logout']");

   public void loadHomePage(){
      loadWebPage(url);
   }

}
