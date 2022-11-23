import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonTwoComplicatedWelcomeSite {

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
    public void TestHelloPositive() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("+79999999999");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79999999999.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestHelloNotCompletedForm() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestHelloOnlyName() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("+79999999999");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иван.\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79999999999.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestHelloNoValidEmail() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("test.ru");
        driver.findElement(By.name("phone")).sendKeys("+79999999999");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79999999999.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void TestHelloNoValidPhone() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("test@test.ru");
        driver.findElement(By.name("phone")).sendKeys("A999?");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (test@test.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: A999?.";
        Assert.assertEquals(expectedResult, actualResult);
    }
}




