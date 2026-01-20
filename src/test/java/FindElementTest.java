import org.openqa.selenium.By;                                     // 👉 используется для поиска элементов на странице (id, class, tag и т.д.)
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

    WebDriver driver;                                               // 👉 Переменная драйвера, через неё мы управляем браузером
    //  👉 метод будет выполняться перед каждым тестом
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();                                 // 👉Создаём объект ChromeDriver — открывается браузер Chrome
        driver.get("https://ilcarro.web.app");                       // 👉Открываем сайт по указанному URL

        driver.manage().window().maximize();                          // 👉 максимальный размер окна браузера
        //  👉 Неявное ожидание — Selenium будет ждать до 10 секунд, пока элементы появятся на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    //  👉 метод будет выполняться после каждого теста
    @AfterMethod // 👉р
    public void tearDown() {                                               // 👉 Закрывает браузер и завершает сессию WebDriver
        driver.quit();
    }
    // 👉 метод ищет элемент пo <tag>
    @Test
    public void FindElementByTagName(){

        WebElement h1=driver.findElement(By.tagName("h1"));                    // 👉Ищем первый элемент с тегом <h1>
        System.out.println(h1.getText());                                      // 👉 Выводим текст элемента в консоль

        WebElement h2=driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link=driver.findElement(By.tagName("a"));                    // 👉 Ищем первый элемент с тегом <a> (ссылка)
        System.out.println(link.getAttribute("class"));

        List<WebElement> links=driver.findElements(By.tagName("a"));            // 👉 ищет ВСЕ элементы с тегом <a> ссылки
        System.out.println(links.size());
    }
    // 👉 метод ищет элемент пo <id>
    @Test
    public void findElementById(){
        WebElement city = driver.findElement(By.id("city"));                    // 👉 Ищем элемент с id="city"
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));                     //👉 Ищем элемент с id="dates"
    }
    // 👉 метод ищет элемент пo классу
    @Test
    public void findElementByClassName(){
        WebElement telephone = driver.findElement(By.className("telephone"));   //👉Ищем элемент с классом "telephone"
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));// 👉Ищем элемент с классом "description"
        System.out.println(description.getText());

    }

}
//❗️❗️❗️findElement — ищет один элемент (если не найден → ошибка)
//❗️❗️❗️findElements — ищет несколько элементов (если не найдено → пустой список)
//❗️❗️❗️@BeforeMethod -выполняться перед каждым тестом
//❗️❗️❗️@AfterMethod - выполняться после каждого теста
//❗️❗️❗️WebDriver — мозг теста
//❗️❗️❗️WebElement — конкретный элемент страницы
