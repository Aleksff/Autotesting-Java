import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonThreeTestShoeStore {

    @Test
    public void TestPositive() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("42");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.className("error")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();

    }
}
