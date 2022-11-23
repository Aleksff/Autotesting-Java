import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsForAnOnlineCinemaWebsite5 {

    private static WebDriver driver;

    @BeforeClass
    public static void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void AfterClass() {
        driver.quit();
    }

    @Test
    public void TestWithoutPressingTheSaveButton() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var bestFilmsElement = driver.findElement(By.id("films"));
        var bestSerialsElement = driver.findElement(By.id("serials"));
        var bestFilms = "Терминатор";
        var bestSerials = "Санта-Барбара";
        bestFilmsElement.sendKeys(bestFilms);
        bestSerialsElement.sendKeys(bestSerials);
        var buttonTwo = driver.findElement(By.id("two"));
        buttonTwo.click();
        var buttonEnter = driver.findElement(By.id("save"));
        buttonEnter.click();
        var buttonOk = driver.findElement(By.id("ok"));
        buttonOk.click();
        var bestFilmsResult = driver.findElement(By.id("best_films")).getText();
        var bestSerialsResult = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("любимый фильм сохранен без нажатия кнопки СОХРАНИТЬ", "", bestFilmsResult);
        Assert.assertEquals("любимый сериал сохранен без нажатия кнопки СОХРАНИТЬ", "", bestSerialsResult);
    }

    @Test
    public void UserAgeSavingTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var bestFilmsElement = driver.findElement(By.id("films"));
        var bestSerialsElement = driver.findElement(By.id("serials"));
        var bestFilms = "Терминатор";
        var bestserials = "Санта-Барбара";
        bestFilmsElement.sendKeys(bestFilms);
        bestSerialsElement.sendKeys(bestserials);
        var buttonSave = driver.findElement(By.id("save"));
        buttonSave.click();
        var buttonTwo = driver.findElement(By.id("two"));
        buttonTwo.click();
        var buttonEnter = driver.findElement(By.id("save"));
        buttonEnter.click();
        var buttonOk = driver.findElement(By.id("ok"));
        buttonOk.click();
        var bestFilmsResult = driver.findElement(By.id("best_films")).getText();
        var bestSerialsResult = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("любимый фильм не соответствует указанному пользователем", bestFilms, bestFilmsResult);
        Assert.assertEquals("любимый сериал не соответствует указанному пользователем", bestserials, bestSerialsResult);
    }

    @Test
    public void TestElementsAgeCount() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var buttonSave = driver.findElement(By.id("save"));
        buttonSave.click();
        var ageCountElements = driver.findElements(By.name("age"));
        Assert.assertEquals("Неверное количество элементов", 5, ageCountElements.size());
    }

    @Test
    public void TestElementsCheckboxsCount() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var buttonSave = driver.findElement(By.id("save"));
        buttonSave.click();
        var checkboxsCountElements = driver.findElements(By.className("checkboxs"));
        Assert.assertEquals("Неверное количество элементов", 4, checkboxsCountElements.size());
    }


}

