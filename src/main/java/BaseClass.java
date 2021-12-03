import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseClass {

    WebDriver driver;



    public BaseClass(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator){
        return driver.findElements(locator);
    }

    public void clickElement(By locator){
        findElement(locator).click();
    }

    public void typeText(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public Boolean isOnPage(By locater){
        return findElement(locater).isDisplayed();
    }

    public int itemCount(By locator){
        return findAllElements(locator).size();

    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }




}
