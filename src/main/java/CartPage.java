import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BaseClass {

    By amountSelectLocator = new By.ByCssSelector("select[class='amount']");
    By amountOptionLocator = new By.ByCssSelector("select.amount > option:nth-child(2)");
    By completeButtonLocator = new By.ByCssSelector("input[class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']");
    By saveButtonLocator = By.xpath("//button[contains(text(), 'Kaydet')]");
    By errorsLocator = By.className("invalid");
    By editCartLocator = new By.ByCssSelector("a[title='Sepeti Düzenle']");
    By secondFavoriteAddButtonLocator = new By.ByCssSelector("ul[class='clearfix recommendation-products horizontal-slider'] > li:nth-child(5) > div > a[class='gg-ui-btn-default btn-add-to-basket']");
    By basketLocator = new By.ByCssSelector("a[title='Sepetim']");
    By basketItemDivLocator = new  By.ByCssSelector("div[class='product-group-box']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    //CART-PAGE TEST METHODS

    public boolean isErrorMessagesDisplayed() {

        clickElement(saveButtonLocator);

        List<WebElement> errorMessages = findAllElements(errorsLocator);
        if (errorMessages.size() > 0) {
            return true;
        }
        return true;
    }


    public boolean isSecondItemAdded(){
        if(itemCount(basketItemDivLocator) > 1){
            return true;
        }
        return false;
    }


    //CART-PAGE ACTION METHODS

    public void increaseItemAmount() throws InterruptedException {
        Thread.sleep(3000);
        clickElement(amountSelectLocator);
        clickElement(amountOptionLocator);
        clickElement(completeButtonLocator);

    }


    public void addToCartToSecondFavorite(){
        clickElement(editCartLocator);
        clickElement(secondFavoriteAddButtonLocator);

    }

    public void goToBasket(){

        clickElement(basketLocator);

    }



}
