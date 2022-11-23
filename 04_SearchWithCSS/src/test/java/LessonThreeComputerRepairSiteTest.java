import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonThreeComputerRepairSiteTest {

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

    private By nameLocator = By.cssSelector(".data.text");
    private By emailLocator = By.cssSelector(".data.field");
    private By reviewTextLocator = By.cssSelector(".field.text");
    private By buttonSendLocator = By.id("comment");
    private By answerThanksLocator = By.className("message-header");

    @Test

    public void testAnswerThanksLocator() {

        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        var name = "Василий";
        var email = "test@test.ru";
        var reviewText = "Очень доволен!";
        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(reviewTextLocator).sendKeys(reviewText);
        driver.findElement(buttonSendLocator).click();
        Assert.assertTrue("Не отображается окно с сообщением про спасибо", driver.findElement(answerThanksLocator).isDisplayed());
    }

}
