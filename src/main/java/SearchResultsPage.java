import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchResultsPage extends BaseClass{

    By searchBarLocator = new By.ByCssSelector("input[data-cy='header-search-input']");
    By favoriteIconLocator = new By.ByCssSelector("div[data-cy='product-favorite']");
    By selectedFavoriteIconLocator = new By.ByCssSelector("div[class='ndodpt-1 bgCibU sc-1n49x8z-13 dchmcc']");
    By findButtonLocator = new By.ByCssSelector("button[data-cy='search-find-button']");
    By seventhItem = new By.ByCssSelector("ul.sc-1yvp483-0.pmyvb0-1.dTGwmm.gDmzzR > li:nth-child(7)");
    By seventhAddCartButton = new By.ByCssSelector("ul.sc-1yvp483-0.pmyvb0-1.dTGwmm.gDmzzR > li:nth-child(7)> article > div.sc-533kbx-0.sc-1v2q8t1-0.iCRwxx.ixSZpI.sc-1n49x8z-12.bhlHZl > footer > button");
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //SEARCH-PAGE TEST METHODS

    public boolean isSearchResultsLoad() throws InterruptedException {

        Thread.sleep(2000);
        if(itemCount(selectedFavoriteIconLocator) > 0){
            return true;
        }
        return false;

    }

    public boolean isSelectedFavorites() throws InterruptedException {

        getItems();

        if(itemCount(selectedFavoriteIconLocator) > 0){
            return true;
        }
        return false;
    }

    public boolean isSpecificItemSearched(){
        System.out.println("CANTA ARATAM SEARCHBAR SONUCU"+findElement(searchBarLocator).getText());
        if(driver.getTitle().contains("Çanta - GittiGidiyor")){
            return true;
        }
        return false;
    }

    // SEARCH-PAGE ACTION METHODS
    public void getItems() throws InterruptedException {

       Thread.sleep(3000);
        searchProducts("Laptop");

        scrollToPageBottom();

        int count = itemCount(favoriteIconLocator)-1;
        List<WebElement> products = findAllElements(favoriteIconLocator);
        ArrayList<Integer> productNumbers = new ArrayList<>(4);
        Random random = new Random();
        int randomNumber;
        while(productNumbers.size() <= 4){
            randomNumber = random.nextInt(count);
            if(!productNumbers.contains(randomNumber)){
                productNumbers.add(randomNumber);
            }
        }

        WebElement prodctElement;
        for(int i =0;i < 4;i++){
            try{
                prodctElement = products.get(productNumbers.get(i));
                prodctElement.click();
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e);
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();",products.get(productNumbers.get(i)));
            }
        }

    }


    public void searchProducts(String text){
        typeText(searchBarLocator,text);
        clickElement(findButtonLocator);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getSpecificItem(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        WebElement seventhProduct = findElement(seventhItem);
        actions.moveToElement(seventhProduct).perform();

        clickElement(seventhAddCartButton);
    }

    public void scrollToPageBottom() throws InterruptedException {
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight || document.documentElement.scrollHeight)", "");

    }

}
