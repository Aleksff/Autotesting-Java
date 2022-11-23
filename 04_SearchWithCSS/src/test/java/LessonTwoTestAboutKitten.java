import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonTwoTestAboutKitten {
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

    private By emailLocator = By.className("email");
    private By buttonLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-email");

    @Test
    public void TestKittens() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        var email = "test@test.ru";
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Не отобразилось сообщение с email", driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Текст с email не соответствует спецификации", email, driver.findElement(resultEmailLocator).getText());
    }

    @Test
    public void TestKittensEmpltyEmail() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Текст про email не соответствует спецификации", "", driver.findElement(resultEmailLocator).getText());
    }

}
