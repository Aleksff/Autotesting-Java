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

    //    Задание № 1.
//    Для сайта книжного магазина составьте, используя CSS:
    @Test
    public void MainPageLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
//    1. Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
//    Осуществите поиск только по атрибуту test-info, равному about-us.
        var aboutStoreLocator = By.cssSelector("[test-info = 'about-us']");
//    2. Локатор на главной странице для всех элементов с тегом a и с атрибутом href с
//    пустым значением, то есть равным «».
        var footerLinksLocator = By.cssSelector("a[href = '']");
//    4.Локатор на главной странице для элемента <div class="book-price">.
//    Осуществите поиск одновременно по тегу и классу, равному book-price.
        var allPriseLocator = By.cssSelector("div.book-price");
//    5. Локатор на главной странице  для всех элементов с тегом button и
//    с атрибутом class, начинающимся на book.
        var allButtonsAddToCartLocator = By.cssSelector("button[class ^= 'book']");
//    6. Локатор на главной странице для всех элементов, у которых атрибут class
//    заканчивается на main.
        var mainMenuListLocator = By.cssSelector("[class $= 'main']");
//    7. Локатор на главной странице для всех элементов с тегом a и с атрибутом class,
//    содержащим в себе слово menu.
        var allAAndTextLocator = By.cssSelector("a[class *= 'menu']");
    }

    @Test
    public void searchPageLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
//    3. Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected.
//    Осуществите поиск только по атрибуту selected.
        var choiceOfAuthorAndYearLocator = By.cssSelector("[selected = '']");
    }

//    Задание № 2
//    Для сайта книжного магазина составьте CSS-локаторы:

    @Test
    public void MainPageNestingLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/index.html");
//    1. На главной странице найдите все теги div, которые являются дочерними
////    элементами первого уровня у элемента <footer id="footer">.
        var footerElementsLocator = By.cssSelector("footer#footer > div");
//    2. На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
        var firstChildLocator = By.cssSelector("li#genres +*");
    }

    @Test
    public void searchPageNestingLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/search.html");
//    3. На странице поиска найдите любые теги, которые расположены после
//    <div class="filter-container"> (необязательно ближайший сосед).
        var containerLocator = By.cssSelector("div.filter-container ~ *");
    }

    //    Задание № 3 (Практика 5.4).
    //   Для сайта клуба любителей весёлых носков составьте CSS-локаторы, в которых найдите:
    @Test
    public void MainPageSocksLocators() {
        driver.navigate().to("http://qajava.skillbox.ru/module05/auth/index.html/");
        //1. Первый тег h1, находящийся сразу на первом уровне вложенности
        // внутри <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.
        var oneTitleTextLocator = By.cssSelector("section.important-section-block[for='main-header-page'] > h1 :first-child");
        //Последний тег p, находящийся сразу на первом уровне вложенности
        // внутри <form class="form" id="login-form">. Используйте поиск по child.
        var buttonLocator = By.cssSelector(".form#login-form > p:last-child");
        //Любой тег, который является третьим дочерним элементом
        // первого уровня тега <body>. Используйте поиск по child.
        var footerLocator = By.cssSelector("body > *:nth-child(3)");
        //Все элементы с тегом <a>, которые являются первым элементом своего
        // родителя <div class="footer__menuList">. Используйте поиск по type.
        var OneLinksFooterLocator = By.cssSelector("div.footer__menuList > a:first-child");
        //По желанию: найдите элемент с тегом <a>, который является первым дочерним
        // элементом данного типа у своего родителя <div class="footer__menuList">,
        // при этом <div class="footer__menuList"> является первым дочерним элементом
        // у своего родителя <div class="footer__menu">.
        // Составленный поиск должен вернуть ровно один найденный элемент.
        var socksOffFeetLocator = By.cssSelector(".footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)");
    }
}
