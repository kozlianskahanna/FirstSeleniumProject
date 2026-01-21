import org.openqa.selenium.By;                                     //  👉 используется для поиска элементов на странице (id, class, tag и т.д.)
import org.openqa.selenium.WebDriver;                              //  👉 основной инструмент управления браузером
import org.openqa.selenium.WebElement;                             //  👉 представляет один HTML-элемент на странице
import org.openqa.selenium.chrome.ChromeDriver;                    //  👉 конкретная реализация WebDriver для браузера Chrome
import org.testng.annotations.AfterMethod;                         //  👉 метод будет выполняться после каждого теста
import org.testng.annotations.BeforeMethod;                        //  👉 метод будет выполняться перед каждым тестом
import org.testng.annotations.Test;                                //  👉 помечает тестовый метод

import java.time.Duration;                                         //  👉 используется для задания времени ожидания
import java.util.List;                                             //  👉 используется для хранения списка элементов
// Класс с тестами
public class FindElementTest {

    WebDriver driver;                                               //  👉 Переменная драйвера, через неё мы управляем браузером
    //  👉 метод будет выполняться перед каждым тестом
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();                                 //  👉Создаём объект ChromeDriver — открывается браузер Chrome
        driver.get("https://ilcarro.web.app");                       //  👉Открываем сайт по указанному URL

        driver.manage().window().maximize();                          //  👉 максимальный размер окна браузера
        //  👉 Неявное ожидание — Selenium будет ждать до 10 секунд, пока элементы появятся на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //  👉 метод будет выполняться после каждого теста
    @AfterMethod // 👉р
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    // 👉 метод ищет элемент пo <tag>
    @Test
    public void FindElementByTagName() {
        //fin an element
        //tag name -> h1
        WebElement h1 = driver.findElement(By.tagName("h1"));          // 👉Ищем первый элемент с тегом <h1>
        System.out.println(h1.getText());                              // 👉 Выводим текст элемента в консоль

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link = driver.findElement(By.tagName("a"));          // 👉 Ищем первый элемент с тегом <a> (ссылка)
        System.out.println(link.getAttribute("class"));

        //list of elements
        List<WebElement> links = driver.findElements(By.tagName("a"));  // 👉 ищет ВСЕ элементы с тегом <a> ссылки
        System.out.println(links.size());
    }
    // 👉 метод ищет элемент пo <id>
    @Test
    public void findElementById() {

        WebElement city = driver.findElement(By.id("city"));             // 👉 Ищем элемент с id="city"
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));              //👉 Ищем элемент с id="dates"
    }
    // 👉 метод ищет элемент пo классу
    @Test
    public void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));   //👉Ищем элемент с классом "telephone"
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));// 👉Ищем элемент с классом "description"
        System.out.println(description.getText());
    }
    // 👉 метод ищет элемент по точному тексту ссылки
    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());
    }
    // 👉 метод ищет элемент по частичному тексту ссылки
    @Test
    public void findElementByPartialLinkText() {
        WebElement partialLink = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLink.getText());
    }
    // 👉 метод ищет элемент по CSS селектору
    @Test
    public void findElementByCssSelector() {
        // driver.findElement(By.tagName("h1"));
        //tag name "h1" -> css "h1"
        driver.findElement(By.cssSelector("h1"));                         // 👉 Ищем элемент <h1> по CSS селектору

        //driver.findElement(By.id("city"));
        // id "city" -> css "#city"
        driver.findElement(By.cssSelector("#city"));                      // 👉 Ищем элемент с id="city" (#id)

        // driver.findElement(By.className("telephone"));
        // class "telephone" -> css ".telephone"
        driver.findElement(By.cssSelector(".telephone"));                 // 👉 Ищем элемент с классом "telephone" (.class)

        // [attr='par']
        driver.findElement(By.cssSelector("[href='/search']"));           // 👉 Ищем элемент с атрибутом href='/search'
        driver.findElement(By.cssSelector("[for='city']"));               // 👉 Ищем элемент с атрибутом for='city'

        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));              // 👉 Ищем элемент, href которого содержит "car"
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/let']"));              // 👉 Ищем элемент, href которого начинается с "/let"
        //end to -> $
        driver.findElement(By.cssSelector("[href$='work']"));              // 👉 Ищем элемент, href которого заканчивается на "work"

        //composite cssSelector
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));// tag+class+pare 👉 Ищем <a> с классом и атрибутом
        driver.findElement(By.cssSelector("div.social-networks")); // tag+class 👉 Ищем <div> с классом "social-networks"

        driver.findElement(By.cssSelector(".logo>img")); // > one step below// 👉 Ищем <img>, который является прямым потомком элемента с классом "logo"
        driver.findElement(By.cssSelector(".feedback .feedback-date")); // <space> one or more steps below// 👉 Ищем элемент с классом "feedback-date", потомок класса "feedback"

        //<tag> or <id> or <class>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(5)"));// 👉 Ищем пятый элемент с классом "feedback"
        System.out.println(feedback.getText());

        driver.findElement(By.cssSelector("[type='submit']"));              // 👉 Ищем кнопку отправки формы по атрибуту type='submit'
        driver.findElement(By.cssSelector(".title-container span.title")); // class + <space> + tag + class// 👉 Ищем <span> с классом "title", потомок класса "title-container"
    }

}


//❗️❗️❗️ findElement                  ищет один элемент (если не найден → ошибка)
//❗️❗️❗️ findElementByTagName         ищет элемент пo <tag>
//❗️❗️❗️ findElements                 ищет несколько элементов (если не найдено → пустой список)
//❗️❗️❗️ findElementByClassName	   Ищет элементы по классу, выводит текст
//❗️❗️❗️ @BeforeMethod                 выполняться перед каждым тестом
//❗️❗️❗️ @AfterMethod                  выполняться после каждого теста
//❗️❗️❗️ WebDriver                     мозг теста
//❗️❗️❗️ WebElement                    конкретный элемент страницы
//❗️❗️❗ findElementByLinkText     	Ищет ссылку по точному тексту
//❗️❗️❗ findElementByPartialLinkText	Ищет ссылку по части текста
//❗️❗️❗ findElementByCssSelector	    Ищет элементы с помощью CSS-селекторов (id, класс, атрибуты, композиции

//By.xpath









