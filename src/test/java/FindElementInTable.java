import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;                                                 // 👉 используется для задания времени ожидания
import java.util.List;                                                     // 👉 используется для хранения списка элементов
// 👉 Класс с тестами для работы с таблицей на странице
public class FindElementInTable {

    WebDriver driver;                                                      // 👉 Переменная драйвера, через неё управляем браузером

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();                                       // 👉 Создаём объект ChromeDriver — открывается браузер Chrome
        driver.get("https://www.w3schools.com/css/css_table.asp");         // 👉 Открываем страницу с таблицей
        driver.manage().window().maximize();                               // 👉 Увеличиваем окно браузера на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 👉 Неявное ожидание до 10 секунд для появления элементов
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();                                                 // 👉 Закрываем браузер и завершаем работу драйвера
        }
    }
    // 👉 Метод ищет и выводит данные из таблицы с помощью CSS-селекторов
    @Test
    public void findCssSelectorInTable() {
        //get numbers of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));// 👉 Получаем все строки таблицы <tr>
        System.out.println(rows.size());

        for (int i = 0; i < rows.size(); i++) {                           // 👉 Выводим текст каждой строки с помощью цикла for с индексом
            System.out.println(rows.get(i).getText());
        }
        System.out.println("***********************************");

        for (WebElement element : rows) {                                 // 👉 Выводим текст каждой строки с помощью цикла for-each
            System.out.println(element.getText());
        }
        System.out.println("************************************");

        //get row 2
        WebElement germany = driver.findElement(By.cssSelector("#customers tr:nth-child(2)"));// 👉 Получаем вторую строку таблицы по CSS-селектору
        System.out.println(germany.getText());
        System.out.println("************************************");

        //get row 2, 2 element
        WebElement maria = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:nth-child(2)"));// 👉 Получаем второй элемент во второй строке (столбец 2)
        System.out.println(maria.getText());
        System.out.println("*******************************");

        //get row 2, last element
        WebElement last = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:last-child"));// 👉 Получаем последний элемент во второй строке
        System.out.println(last.getText());


    }
}
