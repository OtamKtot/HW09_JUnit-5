package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideLanguageTest extends BaseTest {
    @BeforeEach
    public void beforeEach() { open("https://www.logitech.com/");}
    String link = "https://www.logitech.com/";

    static Stream<Arguments> selenideJavaScriptLocaleTest() {
        return Stream.of(
                Arguments.of(Locale.DK, "Logitech: Trådløs mus, tastaturer, headset og videomøder"),
                Arguments.of(Locale.ES, "Logitech: Ratón inalámbrico, teclados, auriculares y videoconferencia"),
                Arguments.of(Locale.FR, "Logitech: Souris sans fil, claviers, casques et solutions de visioconférence")
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
        $$(".col-2__countries__title").find(text(link+locale.name())).click();
        $(".body-copy-ctn js-body-copy-ctn rte-field").shouldHave(text(title));
    }
}
