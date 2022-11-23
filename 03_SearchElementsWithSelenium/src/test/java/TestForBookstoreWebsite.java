import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForBookstoreWebsite {

    @Test
    public void TestElementSearch() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
        var feedbackElement = driver.findElement(By.linkText("Обратная связь"));
        var preOrdersElement = driver.findElement(By.linkText("Предзаказы"));
        var buttonToCartElement = driver.findElement(By.className("book-add"));
        var quantityOfGoodsElement = driver.findElement(By.id("cart_count"));
        var menuItemBooksElement = driver.findElement(By.id("genres"));
        var storeSearchFieldElement = driver.findElement(By.id("search-input"));
        driver.quit();
    }
}



