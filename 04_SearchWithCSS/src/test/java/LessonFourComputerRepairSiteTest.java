import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonFourComputerRepairSiteTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private By fioLocator = By.cssSelector(".form-input.fio");
    private By streetLocator = By.cssSelector(".street");
    private By houseLocator = By.cssSelector(".house");
    private By flatLocator = By.cssSelector(".flat");
    private By dateLocator = By.cssSelector(".date");
    private By buttenMasterLocator = By.cssSelector(".form-submit");
    private By resultWindows = By.cssSelector(".form-result");

    @Test
    public void testFeedback() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        var fio = "Иванов Иван Иванович";
        var street = "Московская";
        var house = "5";
        var flat = "123";
        var date = "02.11.2022";
        driver.findElement(fioLocator).sendKeys(fio);
        driver.findElement(streetLocator).sendKeys(street);
        driver.findElement(houseLocator).sendKeys(house);
        driver.findElement(flatLocator).sendKeys(flat);
        driver.findElement(dateLocator).sendKeys(date);
        driver.findElement(buttenMasterLocator).click();
        Assert.assertTrue("Не отображается окно с сообщением о деталях заказа ", driver.findElement(resultWindows).isDisplayed());
    }

}


