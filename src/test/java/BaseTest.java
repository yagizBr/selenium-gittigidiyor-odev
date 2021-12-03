
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResults.class)
public class BaseTest {

    static WebDriver driver;

    @BeforeAll
    public void startUp(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://gittigidiyor.com.tr");
        driver.manage().window().maximize();

    }


    @AfterAll
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
