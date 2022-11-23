import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {
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

//    Задание 1. XPath-локаторы для сайта домашнего кинотеатра
//
//    Что нужно сделать
//    Для сайта домашнего кинотеатра составьте XPath-локаторы следующих элементов:

    @Test
    public void NewLocator() {
        driver.navigate().to("http://qa.skillbox.ru/module19/");
//    1. Кнопка перехода к предыдущему объявлению в слайдере «<». <span class="da-arrows-prev"></span>
        var elementA1Locator = By.xpath("//span[@class='da-arrows-prev']");
//    2. Кнопка «Узнать больше» в слайдере. Используйте поиск сразу по двум
//       классам. <a href="#" class="da-link button">Узнать больше</a>
        var elementA2Locator = By.xpath("//div[contains(@class,'da-slide-current')]//a[@class='da-link button']");
//    3. Все неактивные фильтры из раздела фильмов, которые есть в онлайн-кинотеатре.
        var elementA3Locator = By.xpath("//ul[@class='nav nav-pills']//li[not(@class='filter active')]");
//    4. Все элементы, у которых класс начинается на слова button.
        var elementA4Locator = By.xpath("//*[starts-with(@class,'button')]");
//    5. Кнопка «Подписаться сейчас».
        var elementA5Locator = By.xpath("//*[.='Подписаться сейчас']");
//    6. Все картинки клиентов из раздела «Наши клиенты». Для уточнения локатора используйте указание
//       ближайшего родительского элемента с ID.
        var elementA6Locator = By.xpath("//div[@id='clients']//img");
//    7. Необязательное задание. Все элементы с ценами тарифов, следующих после тарифа «Любительский».
        var elementA7Locator = By.xpath("((//*[.='Любительский']/parent::*)/following-sibling::*)//li[@class='price']");
//    8. Необязательное задание. Все поля для ввода в форме «Скажите “Привет”», которые
//    предшествуют полю «* Текст сообщения».
        var elementA8Locator = By.xpath("//form[@id='contact-form']//input");


//    Задание 2. XPath-локаторы для сайта онлайн-института
//
//
//    Что нужно сделать
//    Для сайта онлайн-института составьте XPath-локаторы следующих элементов:
//
//    1. Заголовок пятого курса.
        var elementB1Locator = By.xpath("//*[@class='pageCreate__cards']//div[5]//span");
//    2. Элемент с учебным периодом последнего курса.
        var elementB2Locator = By.xpath("//*[@class='pageCreate__cards']/div[last()]//div[@class='baseCondition'][3]/p");
//    3. Необязательное задание. Все div, которые являются непосредственными родителями для ссылок с href='#'.
        var elementB3Locator = By.xpath("//a[@href='#']/parent::div");
//    4. Необязательное задание. Преобразуйте предыдущий локатор, чтобы он возвращал пятый элемент.
        var elementB4Locator = By.xpath("(//a[@href='#']/parent::div)[5]");
//    5. Необязательное задание. Все родительские элементы заголовка «Все курсы».
        var elementB5Locator = By.xpath("//div[@class='pageCreate__title']/ancestor::*");

//   Задание 3. XPath-локаторы для сайта книжного магазина
//
//
//   Что нужно сделать
//   Применяя правила построения хороших локаторов, составьте XPath-локаторы для следующих
//   элементов на сайте книжного магазина:
//
//    1. Ссылка «О магазине» в футере.
        var elementC1Locator = By.xpath("//footer//a[@test-info='about-us']");
//    2. Заголовок «Бестселлеры».
        var elementC2Locator = By.xpath("//ul[@class='menu-main']/li[3]/a");
//    3. Строка поиска.
        var elementC3Locator = By.xpath("//*[@id='search-input']");
//    4. Итоговая сумма заказа в корзине.
        var elementC4Locator = By.xpath("//div[@id='total']");
//    5. Заголовок «Ваш заказ: в корзине.
        var elementC5Locator = By.xpath("//div[@id='order-info']/div[1]");
//    6. Кнопка «Отменить» на странице поиска.
        var elementC6Locator = By.xpath("//div[@class='filter-container']//button[2]");
    }
}


