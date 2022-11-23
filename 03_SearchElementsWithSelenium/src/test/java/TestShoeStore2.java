import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestShoeStore2 {

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

    @Test
    public void TestOrderASizeSmaller() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("32");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("Сообщение о наличии обуви при заказе размера меньше 34", expectedResult, actualResult);
    }

    @Test
    public void TestPositiveOrder() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("42");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals("Сообщении об отсутствии обуви при заказе размера в диапозоне от 34 по 44 включительно", expectedResult, actualResult);
    }
}

