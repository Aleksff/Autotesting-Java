import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoversSiteTestFunnySocks_1 {

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
//    Запишите один тест на сценарий работы валидации формы авторизации на сайте клуба любителей весёлых носков.
//    Реализуйте следующий сценарий:
//    Перейдите на страницу.
//    Введите в поле email значение @.
//    Введите в поле для пароля значение 123.
//    Нажмите на кнопку «Войти».
//    Убедитесь, что отобразился текст с ошибкой (проверка только на видимость).
//    Проверьте сам текст с ошибкой, он должен быть равен «Некорректный email или пароль».
//    Локаторы для этих элементов вынесите в отдельный блок кода (на уровне класса или самого тестового метода).
//    Элементы ищите непосредственно перед взаимодействием.
//    При этом каждый из четырёх элементов ищите новым способом из уже изученных: By.id, By.tagName, By.className, By.name.
//    Используйте при проверках assertTrue и assertEquals с указанием сообщений в случае падения теста.
    private By emailLocator = By.id("email");
    private By passwordLocator = By.name("password");
    private By buttonToComeIn = By.tagName("button");
    private By resultFormErrorLocator = By.className("form-error-password-email");

    @Test
    public void TestAuthorizationForm() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
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
