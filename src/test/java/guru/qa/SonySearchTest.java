package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.open;

public class SonySearchTest extends BaseTest {
    @BeforeEach
    public void beforeEach() {
        open("https://www.playstation.com/ru-ru/support/");
    }

    @CsvFileSource(
            resources = "/successfulSearchResult.csv"
    )
    @Tag("web")
    @DisplayName("Проверка результата поиска игры")
    @ParameterizedTest(name = "В предложенных вариантах есть Сообщество игры")
    void selenideJavaScriptLocaleTest(String searchGame, String searchResult) {
        $(".shared-nav-icon > svg").click();
        $(".search-text-box__input").setValue(searchGame).pressEnter();
        $(".search-results__tile__content").shouldHave(text(searchResult));
    }
}