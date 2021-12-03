import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class FavoritesPage extends BaseClass{

    By mainPageLinkLocator = new By.ByCssSelector("a[class='logo_gg imglink logo-small']");
    By myAccountButtonLocator = new By.ByCssSelector("div[title='Hesabım']");
    By favoritesLinkLocator = new By.ByCssSelector("a[title='Favorilerim']");
    By favoritesCheckBox = new By.ByCssSelector("tr:nth-child(3) > td:nth-child(1) > div[class='gg-ui-checkbox-primary robot-watchproducts-product-checkbox']");
    By favoritesItemsLocator = new By.ByCssSelector("div[class='watch-products--content gg-d-9 gg-t-24 gg-m-24 padding-none']");
    By favoritesDeleteButtonLocator = new By.ByCssSelector("button[class='delete-watch-products robot-delete-all-button']");
    By logOutLinkLocator = new By.ByCssSelector("a[href='/cikis-yap']");


    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    //FAVORITES-PAGE TEST METHODS


    public boolean isBasketDecreased(){

        if(itemCount(favoritesItemsLocator) < 4){
            return true;
        }
        return false;
    }

    //FAVORITES-PAGE ACTION METHODS

    public void goToMainPageFromCart(){
        clickElement(mainPageLinkLocator);
    }

    public void clickFavorites() throws InterruptedException {

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement favoriteLink = findElement(myAccountButtonLocator);
        actions.moveToElement(favoriteLink).perform();
        clickElement(favoritesLinkLocator);


    }

    public void deleteThirdFavoriteElement() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(favoritesCheckBox);
        clickElement(favoritesDeleteButtonLocator);


    }


    public void logOut() throws InterruptedException {

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement myAccountBox = findElement(myAccountButtonLocator);
        actions.moveToElement(myAccountBox).perform();

        clickElement(logOutLinkLocator);

    }


}
