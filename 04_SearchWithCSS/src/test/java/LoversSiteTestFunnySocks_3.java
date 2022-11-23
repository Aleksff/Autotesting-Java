import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoversSiteTestFunnySocks_3 {

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
//    Используйте сценарий и тест как в задании 2, только
//    теперь ищите элементы с помощью By.cssSelector с поиском по тегу и одному или двум классам одновременно.
    private By emailLocator = By.cssSelector("input.input-data");
    private By passwordLocator = By.cssSelector("input.password");
    private By buttonToComeIn = By.cssSelector("button.form-submit");
    private By resultFormErrorLocator = By.cssSelector("pre.form-error-password-email");

    @Test
    public void TestAuthorizationForm() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        var email = "@";
        var password = "123";
        var resultFormError = "Некорректный email или пароль";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonToComeIn).click();
        Assert.assertTrue("Отсутствует окно с сообщением об ошибке в поле email или пароль!", driver.findElement(resultFormErrorLocator).isDisplayed());
        Assert.assertEquals("Текст в сообщении об ошибке в поле email или пароль не соответствует ожидаемому!", resultFormError, driver.findElement(resultFormErrorLocator).getText());
    }

}
