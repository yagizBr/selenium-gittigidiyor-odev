import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass{

    String loginPageTitle= "Üye Girişi - GittiGidiyor";
    String loginPageUrl="https://www.gittigidiyor.com/uye-girisi?s=1";
    String email = "email";
    String pass = "password";

    By userNameInputLocator = By.id("L-UserNameField");
    By userPasswordInputLocator = By.id("L-PasswordField");
    By signInButtonLocator = By.id("gg-login-enter");
    By myAccountButtonLocator = new By.ByCssSelector("div[title='Hesabım']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //LOGIN-PAGE TEST METHODS

    public boolean isLoginPageOpened(){

        if(driver.getTitle().contains(loginPageTitle) || getPageUrl() == loginPageUrl){
            if(isOnPage(userNameInputLocator) && isOnPage(userPasswordInputLocator)){
                return true;
            }
        }
        return false;

    }
    public boolean isLogged() throws InterruptedException {
        signIn();



        if(findElement(myAccountButtonLocator).isDisplayed()){
            return true;
        }

        return false;

    }

    //LOGIN-PAGE ACTION METHODS

    public void signIn() throws InterruptedException {
        Thread.sleep(2000);
        typeText(userNameInputLocator,email);
        typeText(userPasswordInputLocator,pass);
        clickElement(signInButtonLocator);
    }


}
