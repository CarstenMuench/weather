package InductionProject.Day1;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.junit.runner.RunWith;

public class TC002_Maximum {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\6813\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @Test
    public void testEx03Top5SellingAlbums() throws Exception {
        driver.get("https://www.accuweather.com/de/za/durban/305605/daily-weather-forecast/305605");
        String Maximum1Day1Text = driver.findElement(By.cssSelector(".fday1 > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > span:nth-child(1)")).getText();
        char Maximum1Day1char1 = Maximum1Day1Text.charAt(0);
        char Maximum1Day1char2 = Maximum1Day1Text.charAt(1);
        driver.get("http://weather.news24.com/sa/durban");
        driver.findElement(By.xpath("//*[@id=\"ext-gen28\"]")).click();
        String Maximum2Day1Text = driver.findElement(By.cssSelector(".forecastTable > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(4)")).getText();
        char Maximum2Day1char1 = Maximum2Day1Text.charAt(0);
        char Maximum2Day1char2 = Maximum2Day1Text.charAt(1);

        if (Maximum1Day1char1 == Maximum2Day1char1) {
            System.out.println("First digit is the same");
        }
        else
            System.out.println(1/0);
        if (Maximum1Day1char2 == Maximum2Day1char2) {
            System.out.println("Second digit is the same");
        }
        else
            System.out.println(1/0);

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        //String verificationErrorString = verificationErrors.toString();
        //if (!"".equals(verificationErrorString)) {
        //    fail(verificationErrorString);
        //}
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
