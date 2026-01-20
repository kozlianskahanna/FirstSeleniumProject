// HW: В FirstSeleniumProject создайте новый тестовый класс и
// в нем тестовый метод, который найдет по имени тэга, id,
// имени класса 10 элементов на странице

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HWFindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByTagName() {

        WebElement html = driver.findElement(By.tagName("html"));
        System.out.println(html.getText());

        WebElement head = driver.findElement(By.tagName("head"));
        System.out.println(head.getText());

        WebElement title = driver.findElement(By.tagName("title"));
        System.out.println(title.getText());

        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        WebElement p = driver.findElement(By.tagName("p"));
        System.out.println(p.getText());

        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println(body.getText());

        WebElement script = driver.findElement(By.tagName("script"));
        System.out.println(script.getText());

        List<WebElement> links = driver.findElements(By.tagName("div"));
        System.out.println(links.size());

    }

    @Test
    public void findElementById() {

        WebElement success = driver.findElement(By.id("dialog-notifications-success"));
        System.out.println(success.getAttribute("id"));

        WebElement error = driver.findElement(By.id("dialog-notifications-error"));
        System.out.println(error.getAttribute("id"));

        WebElement bar = driver.findElement(By.id("bar-notification"));
        System.out.println(bar.getAttribute("id"));

        WebElement uiid = driver.findElement(By.id("ui-id-1"));
        System.out.println(uiid.getAttribute("id"));

        WebElement newsletter = driver.findElement(By.id("newsletter-email"));
        System.out.println(newsletter.getAttribute("id"));

        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        System.out.println(searchBox.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {

        List<WebElement> headers = driver.findElements(By.className("header"));
        System.out.println(headers.size());

        List<WebElement> topics = driver.findElements(By.className("topic-html-content-body"));
        System.out.println(topics.size());

        List<WebElement> footers = driver.findElements(By.className("footer"));
        System.out.println(footers.size());

        List<WebElement> buttons = driver.findElements(By.className("button-1"));
        System.out.println(buttons.size());
    }

}


