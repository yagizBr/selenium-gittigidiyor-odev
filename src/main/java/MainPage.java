import org.openqa.selenium.*;


public class MainPage extends BaseClass{
    String mainPageUrl = "https://www.gittigidiyor.com/";
    String mainPageTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    By loginDivLocator = new By.ByCssSelector("div[data-cy='header-user-menu']");
    By loginButtonLocator = new By.ByCssSelector("a[data-cy='header-login-button']");
    By mainPageLinkLocator = new By.ByCssSelector("a[class='sc-1fjiks5-1 cSPLit']");
    By cookieInformationWindowLocator = new By.ByCssSelector("a[class='tyj39b-5 lfsBU']");


    public MainPage(WebDriver driver) {
        super(driver);
    }



    //MAIN-PAGE TEST METHODS

    public boolean isMainPageOpened(){

        if(driver.getTitle().contains(mainPageTitle) || getPageUrl() == mainPageUrl){
            return true;
        }
        return false;

    }

    //MAIN-PAGE ACTION METHODS

    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        clickElement(loginDivLocator);
        clickElement(loginButtonLocator);

    }

    public void closeCokieInformWindow(){
        clickElement(cookieInformationWindowLocator);
    }

    public void goToMainPage(){ //ANASAYFAYA GIDILDI MI? ASSERTION ILE KONTROL ET goToMainPage() 'i BOOLEAN HALE GETIR.
        clickElement(mainPageLinkLocator);
    }

    public void openNewTab(){

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.gittigidiyor.com/");

    }
}
