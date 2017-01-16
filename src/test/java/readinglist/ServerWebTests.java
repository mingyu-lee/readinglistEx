package readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mingyu Lee on 2017-01-09.
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class)
@WebIntegrationTest(randomPort = true)
public class ServerWebTests {

    //private static FirefoxDriver firefoxDriver;
    private static ChromeDriver chromeDriver;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBroswer() {
        chromeDriver.quit();
    }

    @Test
    public void addBookToEmptyList() {
        String baseUrl = "http://localhost:9515";

        chromeDriver.get(baseUrl); // 메인페이지 조회
        assertEquals("You have no books in your book list",
                chromeDriver.findElementByTagName("div").getText()); // 빈 책 목록 검증
        chromeDriver.findElementByName("title").sendKeys("BOOK TITLE");
        chromeDriver.findElementByName("author").sendKeys("BOOK AUTHOR");

        chromeDriver.findElementByName("isbn").sendKeys("1234567890");
        chromeDriver.findElementByName("description").sendKeys("DESCRIPTION");
        chromeDriver.findElementByName("form").submit(); // 폼에 데이터를 추가하고 전송

        WebElement dl = chromeDriver.findElementByCssSelector("Dt.bookHeadLine");
        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)", dl.getText());
        WebElement dt = chromeDriver.findElementByCssSelector("dd.bookDescription");
        assertEquals("DESCRIPTION", dt.getText()); // 목록에 새 책이 있는지 검증

    }

}
