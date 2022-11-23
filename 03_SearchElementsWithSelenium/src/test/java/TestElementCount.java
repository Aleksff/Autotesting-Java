import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestElementCount {

    @Test
    public void TestSearchElements() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
        var noteElements = driver.findElements(By.className("book-info"));
        Assert.assertEquals("Неверное количество элементов", 15, noteElements.size());
        driver.quit();
    }
}

