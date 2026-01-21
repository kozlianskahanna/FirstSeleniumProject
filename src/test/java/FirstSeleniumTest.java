import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {                                    // 👉 классы нызываем с больщой буквы

    WebDriver driver;

    //before - setUp                                                  👉 предусловие пред Condition ==> действия перед тестом ...запускает
    @BeforeMethod// аннотация
    public void setUp() {
        driver = new ChromeDriver();
        //driver.get("https://www.google.com/");                    // 👉 мы говорим перейди на эту страницу without history
        driver.navigate().to("https://www.google.com/");        // 👉 with history
        driver.navigate().back();                                   // 👉 предусловие пред Condition ==> действия перед тестом ...запускает
        driver.navigate().forward();                                // 👉 вперёд
        driver.navigate().refresh();                                // 👉 обновить
    }

    //test                                                            👉пишем понятное название Test❗️
    @Test
    public void openGoogle() {
        System.out.println("Google is opened");
    }

    //after - tearDown                                               👉 пост Condition ==> завершение тестов
    @AfterMethod
    public void tearDown() {
        //driver.quit();                                            // 👉 all tabs § close browser метод закрывает браузер
        driver.close();                                             // 👉 only one tab закрывает последнюю вкладку
    }
}
