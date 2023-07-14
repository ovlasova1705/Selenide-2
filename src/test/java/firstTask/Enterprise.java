package firstTask;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Enterprise {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Проверка, что на странице Enterprise есть заголовок Build like the best")

    @Test
    void searchTitle(){
        open("https://github.com/");
        $("div.header-menu-wrapper").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $(byText("Build like the best")).shouldBe(visible);
    }
}

