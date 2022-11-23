import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoversSiteTestFunnySocks_2 {

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
//    Страница авторизации обновилась. Запишите для неё точно такой же тест.
//    В этом задании ищите все элементы с помощью By.cssSelector.
//    Там, где элемент нельзя найти уникально по одному классу, ищите по двум.
    private By emailLocator = By.cssSelector(".input-data");
    private By passwordLocator = By.cssSelector(".form-input.password");
    private By buttonToComeIn = By.cssSelector(".form-submit");
    private By resultFormErrorLocator = By.cssSelector(".form-error-password-email");

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
