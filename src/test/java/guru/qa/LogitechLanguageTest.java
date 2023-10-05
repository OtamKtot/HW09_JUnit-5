package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LogitechLanguageTest extends BaseTest {
    @BeforeEach
    public void beforeEach() { open("https://www.logitech.com/");}
    String linkStart = "https://www.logitech.com/";

    static Stream<Arguments> selenideJavaScriptLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.DK, "Vores mærker"),
                Arguments.of(Locale.ES, "Nuestras marcas"),
                Arguments.of(Locale.FR, "Nos marques")
        );
    }
    @Tags({
            @Tag("web"),
            @Tag("locale")
    })
    @MethodSource
    @DisplayName("Проверка отображаемых заголовков в зависимости от выбранной локали")
    @ParameterizedTest(name="При смене локали на {0} на странице отображается заголовк {1}")
    void selenideJavaScriptLocaleTest(Locale locale, String title) {
        $(".lang-code").click();
        String locatorString = "a[href='" + linkStart + locale + "']";
        $(locatorString).click();
        $(".brand-switcher-btn").shouldHave(text(title));
    }
}
