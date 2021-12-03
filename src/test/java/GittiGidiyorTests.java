
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class GittiGidiyorTests extends BaseTest{

    MainPage mainPage;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    CartPage cartPage;
    FavoritesPage favoritesPage;




    @Test
    @Order(1)
    public void checkMainPage(){
        mainPage = new MainPage(driver);
        mainPage.closeCokieInformWindow();
        Assertions.assertTrue(mainPage.isMainPageOpened(),"GittiGidiyor sitesinin anasayfasına ulasilamadi.");


    }

    @Test
    @Order(2)
    public void goToLoginPage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        mainPage.clickLogin();
        Assertions.assertTrue(loginPage.isLoginPageOpened(),"Login sayfasına ulasilmadi ve sayfa yuklenemedi.");

    }
    @Test
    @Order(3)
    public void checkSession() throws InterruptedException {
        Assertions.assertTrue(loginPage.isLogged(),"Outurm acilamadi");

    }

    @Test
    @Order(4)
    public void isRandomProductSearched() throws InterruptedException {
        searchResultsPage = new SearchResultsPage(driver);
        Assertions.assertTrue(searchResultsPage.isSearchResultsLoad(),"Aratilan urunler bulunamadi");
    }

    @Test
    @Order(5)
    public void isProductSelected() throws InterruptedException {
        Assertions.assertTrue(searchResultsPage.isSelectedFavorites(),"Favoriler 4 adet urun checklenmedi.");

    }

    @Test
    @Order(6)
    public void specificItemSearch() throws InterruptedException {
        cartPage = new CartPage(driver);
        mainPage.goToMainPage();
        searchResultsPage.searchProducts("Çanta");
        searchResultsPage.getSpecificItem();
        Assertions.assertTrue(searchResultsPage.isSpecificItemSearched(),"istenilen urun aratilamadi.");


    }

    @Test
    @Order(7)
    public void checkTheCart() throws InterruptedException {
        cartPage.goToBasket();
        cartPage.increaseItemAmount();
        Assertions.assertTrue(cartPage.isErrorMessagesDisplayed(),"Error mesajlarina ulasilamadi.");
    }

    @Test
    @Order(8)
    public void addSecondItemToBasket(){

        cartPage.addToCartToSecondFavorite();
        Assertions.assertTrue(cartPage.isSecondItemAdded(),"Onerilenlerden ikinci urun sepete eklenemedi");
    }

    @Test
    @Order(9)
    public void checkFavorites() throws InterruptedException {
        favoritesPage = new FavoritesPage(driver);
        favoritesPage.goToMainPageFromCart();
        favoritesPage.clickFavorites();
        favoritesPage.deleteThirdFavoriteElement();
        Assertions.assertTrue(favoritesPage.isBasketDecreased(),"Favorilerden 3. eleman silindi.");
    }


    @Test
    @Order(10)
    public void openInNewTab(){
        mainPage.openNewTab();
    }

    @Test
    @Order(11)
    public void logOut() throws InterruptedException {
        favoritesPage.logOut();
    }


}
