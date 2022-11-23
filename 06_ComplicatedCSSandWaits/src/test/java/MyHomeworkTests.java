import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyHomeworkTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

//  Задание № 1.

// Составьте такой CSS-локатор, по которому бы находились все элементы,
// отмеченные записью <!-- Нужен этот элемент -->.

    //a.
// <section class="header">
//   <h1>Ежедневник</h1>
//   <div>
///        <p>На текущий год</p> <!-- Нужен этот элемент -->
//   </div>
//   <p>Первая запись</p> <!-- Нужен этот элемент -->
//   <p>Вторая запись</p>  <!-- Нужен этот элемент -->
// </section>
    @Test
    public void NewLocator() {

        var elementA1Locator = By.cssSelector("p");

        //b.

// <section>
//   <h1>Ежедневник</h1>
//   <main>
//        <div class="mainText text" name="mainBlock">
//            <a href='#'>Посмотреть за предыдущий год</a><!-- Нужен этот элемент -->
//        </div>
//   </main>
//   <div class="text">
//        <a href='#'>На текущий год</a> <!-- Нужен этот элемент -->
//        <div>
////            <a href='#'>Ещё ранее</a>
//        </div>
//   </div>
//   <p>Первая запись</p>
//   <p>Вторая запись</p>
// </section>

        var elementB1Locator = By.cssSelector("div.text>a");


        //c.

//<section>
//   <h1>Ежедневник</h1>
//   <div class="text">
//        <div class="header" name="headerName">
//            <a href='#'>Посмотреть за предыдущий год</a>
//        </div>
//   </div>
//   <div class="text">
//        <a href='#'>На текущий год</a> <!-- Нужен этот элемент -->
//        <div>
//            <a href='#'>Ещё записи...</a>
//        </div>
//   </div>
//   <div class="text">
//        <a href='#'>За прошлый год</a>
//        <div>
//            <a href='#'>Ещё записи...</a>
//        </div>
//   </div>
//   <p>Первая запись</p>
//   <p>Вторая запись</p>
//</section>
        var elementC1Locator = By.cssSelector("section > div:nth-of-type(2) > a:first-child");
    }

    //  Задание № 2.
//Для сайта заказа такси составьте CSS-локаторы, в них:
//
    @Test
    public void TestTaxiBookingWebsite() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
// * Найдите тег input, у которого нет атрибута id.
        var timeElementLocator = driver.findElement(By.cssSelector("input:not([id])"));
// * Найдите все теги p, у которых одновременно выполняются два условия:
//   + class начинается на слово form;
//   + class НЕ заканчивается на слово error.
        var formElementLocator = driver.findElement(By.cssSelector("p[class ^= 'form']:not([class $= 'error'])"));
// * Найдите <div class="form-inner">, у него найдите первый по счёту элемент
//   такого типа: <p class="form-row">.
        var formRowLocator = driver.findElement(By.cssSelector("div.form-inner p.form-row:first-child"));
    }

    //Задание № 3.
//Для сайта онлайн-ежедневника составьте один тест, в котором:
    @Test
    public void TestOnlineDiary() {
        //  Перейдите на страницу.
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        var noteAddNoteLocator = By.cssSelector("button.articlePreview__link");
        //  Кликните на заметку из списка заметок по центру экрана.
        driver.findElement(noteAddNoteLocator).click();
        //  Дождитесь появления справа от заголовка выбранной записи в разделе «Все записи».
        var noteTitleHomepageLocator = By.cssSelector("p.articlePreview__title");
        var textHomepageLocator = By.cssSelector("p.articlePreview__text");
        //  Проверьте, что у первой записи текст и заголовок равен только что выбранной записи.
        var noteInNotesLocator = By.cssSelector("div.vb-content>div:first-child button.articlePreview__link");
        Assert.assertTrue("Запись не появилась в заметках", driver.findElement(noteInNotesLocator).isDisplayed());
        var noteTitleNoteLocator = By.cssSelector("div.vb-content>div:first-child p.articlePreview__title");
        Assert.assertEquals("Заголовок заметки не соответствует выбранному ранее",
                driver.findElement(noteTitleHomepageLocator).getText(), driver.findElement(noteTitleNoteLocator).getText());
        var textNoteLocator = By.cssSelector("div.vb-content>div:first-child p.articlePreview__text");
        Assert.assertEquals("Текст заметки не соответствует выбранному ранее",
                driver.findElement(textHomepageLocator).getText(), driver.findElement(textNoteLocator).getText());
        //  Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        var basketButtonLocator = By.cssSelector("div.pageArticle__buttons button:last-child");
        driver.findElement(basketButtonLocator).click();
        //  В разделе «Все записи» выберите самую верхнюю запись (первую).
        var oneNoteButtonLocator = By.cssSelector("div.vb-content>div:first-child button.articlePreview__link");
        driver.findElement(oneNoteButtonLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(oneNoteButtonLocator));
        //  Кликните по кнопке с иконкой корзины, расположенной в центральной белой части страницы.
        driver.findElement(basketButtonLocator).click();
        //  Дождитесь исчезновения записи в разделе «Все записи».
        //  Проверьте, что справа в списке «Все записи» не видно записей.
        var emptyFieldLocator = By.cssSelector("div.vb-content:not(div.vb-content > div:first-child button.articlePreview__link)");
        Assert.assertTrue("Записи не удалены", driver.findElement(emptyFieldLocator).isDisplayed());
    }
}


