import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod // 👉развернуть браузер на все окно
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        //maximize
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod // 👉р
    public void tearDown() {
        driver.quit();
    }

    @Test// 👉найти элемент пo <tag>
    public void FindElementByTagName(){
        //tag name ->
        WebElement h1=driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement h2=driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement link=driver.findElement(By.tagName("a"));
        System.out.println(link.getAttribute("class"));

        //list of elements 👉 ищет несколько элементов
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    }
    @Test// 👉 найти элемент пo <id>
    public void findElementById(){
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test// 👉 найти элемент пo классу
    public void findElementByClassName(){
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());

    }



}
