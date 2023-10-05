package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadStrategy = "eager";
    }
}
