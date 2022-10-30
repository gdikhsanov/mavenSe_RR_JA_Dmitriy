import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.DataTruncation;

public class First {

static {
    WebDriverManager.chromedriver().setup();
}

private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFirst() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.id("my-text-id"));
        text.sendKeys("Testing chrome");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button")).click();
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, "Form submitted");
    }



//    //For Junit
//    WebDriver driver;
//
//    @BeforeAll
//    static void setupAll() {
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    void setup() {
//        driver = new ChromeDriver();
//    }
//
//    @AfterEach
//    void teardown() {
//        driver.quit();
//    }
//
//    @Test
//    void test() {
//        // Your test logic here
//    }


//    //For Edge FF IE
//    @Test
//    public void edgeSession() {
//        WebDriverManager.edgedriver().setup();
//
//        WebDriver driver = new EdgeDriver();
//
//        driver.quit();
//    }
//
//    @Test
//    public void firefoxSession() {
//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver = new FirefoxDriver();
//
//        driver.quit();
//    }

//    @Disabled("Only runs on Windows")
//    @Test
//    public void ieSession() {
//        WebDriverManager.iedriver().setup();
//
//        WebDriver driver = new InternetExplorerDriver();
//
//        driver.quit();
//    }
}
