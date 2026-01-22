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

    // HW:В FirstSeleniumProject в созданном для домашнего задания
    // тестовом классе добавьте новый тестовый метод,
    // который найдет по стратегии cssSelector те же элементы,
    // которые вы нашли в предыдущих методах по тэгу,id и классу на странице......

    @Test
    public void findElementsByCssSelector() {

        WebElement html = driver.findElement(By.cssSelector("html"));
        System.out.println(html.getText());

        WebElement head = driver.findElement(By.cssSelector("head"));
        System.out.println(head.getText());

        WebElement title = driver.findElement(By.cssSelector("title"));
        System.out.println(title.getText());

        WebElement h2 = driver.findElement(By.cssSelector("h2"));
        System.out.println(h2.getText());

        WebElement p = driver.findElement(By.cssSelector("p"));
        System.out.println(p.getText());

        WebElement body = driver.findElement(By.cssSelector("body"));
        System.out.println(body.getText());

        WebElement success = driver.findElement(By.cssSelector("#dialog-notifications-success"));
        System.out.println(success.getAttribute("id"));

        WebElement error = driver.findElement(By.cssSelector("#dialog-notifications-error"));
        System.out.println(error.getAttribute("id"));

        WebElement bar = driver.findElement(By.cssSelector("#bar-notification"));
        System.out.println(bar.getAttribute("id"));

        WebElement uiid = driver.findElement(By.cssSelector("#ui-id-1"));
        System.out.println(uiid.getAttribute("id"));

        WebElement newsletter = driver.findElement(By.cssSelector("#newsletter-email"));
        System.out.println(newsletter.getAttribute("id"));

        WebElement searchBox = driver.findElement(By.cssSelector("#small-searchterms"));
        System.out.println(searchBox.getAttribute("id"));

        List<WebElement> headers = driver.findElements(By.cssSelector(".header"));
        System.out.println(headers.size());

        List<WebElement> topics = driver.findElements(By.cssSelector(".topic-html-content-body"));
        System.out.println(topics.size());

        List<WebElement> footers = driver.findElements(By.cssSelector(".footer"));
        System.out.println(footers.size());

        List<WebElement> buttons = driver.findElements(By.cssSelector(".button-1"));
        System.out.println(buttons.size());
    }

    //HW:В FirstSeleniumProject в созданном для домашнего задания тестовом классе
    // добавьте новый тестовый метод,
    // который найдет по стратегии xPath те же элементы, которые вы нашли
    // в предыдущем методе по стратегии cssSelector на странице

    @Test
    public void findElementsByXpath() {

        WebElement html = driver.findElement(By.xpath("//html"));
        System.out.println(html.getText());

        WebElement head = driver.findElement(By.xpath("//head"));
        System.out.println(head.getText());

        WebElement title = driver.findElement(By.xpath("//title"));
        System.out.println(title.getText());

        WebElement h2 = driver.findElement(By.xpath("//h2"));
        System.out.println(h2.getText());

        WebElement p = driver.findElement(By.xpath("//p"));
        System.out.println(p.getText());

        WebElement body = driver.findElement(By.xpath("//body"));
        System.out.println(body.getText());

        WebElement success = driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        System.out.println(success.getAttribute("id"));

        WebElement error = driver.findElement(By.xpath("//*[@id='dialog-notifications-error']"));
        System.out.println(error.getAttribute("id"));

        WebElement bar = driver.findElement(By.xpath("//*[@id='bar-notification']"));
        System.out.println(bar.getAttribute("id"));

        WebElement uiid = driver.findElement(By.xpath("//*[@id='ui-id-1']"));
        System.out.println(uiid.getAttribute("id"));

        WebElement newsletter = driver.findElement(By.xpath("//*[@id='newsletter-email']"));
        System.out.println(newsletter.getAttribute("id"));

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        System.out.println(searchBox.getAttribute("id"));

        List<WebElement> headers = driver.findElements(By.xpath("//*[@class='header']"));
        System.out.println(headers.size());

        List<WebElement> topics = driver.findElements(By.xpath("//*[@class='topic-html-content-body']"));
        System.out.println(topics.size());

        List<WebElement> footers = driver.findElements(By.xpath("//*[@class='footer']"));
        System.out.println(footers.size());

        List<WebElement> buttons = driver.findElements(By.xpath("//*[@class='button-1']"));
        System.out.println(buttons.size());
    }

}


