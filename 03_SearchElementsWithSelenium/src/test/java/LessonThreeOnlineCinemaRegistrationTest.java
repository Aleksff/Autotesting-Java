import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonThreeOnlineCinemaRegistrationTest {

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
    public void TestSearchForRegistrationFields() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var confirmPassword = driver.findElement(By.name("confirm_password"));
    }


}
