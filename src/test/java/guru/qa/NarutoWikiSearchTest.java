package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NarutoWikiSearchTest extends BaseTest {
    @BeforeEach
    public void beforeEach () {open("https://naruto.wiki");}

    @ValueSource(
            strings = {"Kurama", "Rinnegan"}
    )
    @Tag("web")
    @DisplayName("Проверка не пустого результата поиска")
    @ParameterizedTest(name="После запроса поиска, отображается информация о наличии страницы по запросу {0}")
    void selenideJavaScriptLocaleTest (String request) {
        $("#nav-searchInput").setValue(request).pressEnter();
        $(".mw-search-exists").shouldHave(text(request));
    }
}
