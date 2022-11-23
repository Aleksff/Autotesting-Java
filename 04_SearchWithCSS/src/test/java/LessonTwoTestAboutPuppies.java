import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonTwoTestAboutPuppies {

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

    private By checkedBoyLocator = By.id("boy");
    private By checkedGirlsLocator = By.id("girl");
    private By emailLocator = By.name("email");
    private By buttonSendMeLocator = By.id("sendMe");
    private By resultGirlsLocator = By.className("result-text");
    private By resultBoyLocator = By.className("result-text");
    private By resultEmailLocator = By.className("your-email");

    @Test
    public void TestGirlsPuppies() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        var email = "test@test.ru";
        var textresultGirls = "Хорошо, мы пришлём имя для вашей девочки на e-mail:";
        driver.findElement(checkedGirlsLocator).click();
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonSendMeLocator).click();

        Assert.assertEquals("Выводимый текст не соответствует полу щенка!", textresultGirls, driver.findElement(resultGirlsLocator).getText());
    }

    @Test
    public void TestBoyPuppies() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        var email = "test@test.ru";
        var textresultBoy = "Хорошо, мы пришлём имя для вашего мальчика на e-mail:";
        driver.findElement(checkedBoyLocator).click();
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonSendMeLocator).click();

        Assert.assertEquals("Выводимый текст не соответствует полу щенка!", textresultBoy, driver.findElement(resultBoyLocator).getText());
    }

    @Test
    public void TestPuppiesEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonSendMeLocator).click();
        Assert.assertTrue("Не отобразилось сообщение с email", driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Выводимый email не соответствует введеному!", email, driver.findElement(resultEmailLocator).getText());
    }
}


