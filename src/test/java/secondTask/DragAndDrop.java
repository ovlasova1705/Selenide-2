package secondTask;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDrop {
    @Test
    public void testDragAndDropFailed() {
        // Открываем страницу
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");

        // Находим прямоугольники A и B
        SelenideElement rectangleA = $("#column-a");
        SelenideElement rectangleB = $("#column-b");

        // Перетаскиваем прямоугольник A на место B с помощью actions()

        actions().clickAndHold(rectangleA).moveToElement(rectangleB).release().build().perform();

        // Проверяем, что прямоугольники действительно поменялись
        rectangleA.shouldHave(text("B"));
        rectangleB.shouldHave(text("A"));

    }

    @Test
    public void testDragAndDropPassed() {
        // Открываем страницу
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");

        // Находим прямоугольники A и B
        SelenideElement rectangleA = $("#column-a");
        SelenideElement rectangleB =$("#column-b");

        // Перетаскиваем прямоугольник A на место B с помощью $(element).dragAndDropTo($(to-element))
        rectangleA.dragAndDropTo(rectangleB);

        // Проверяем, что прямоугольники действительно поменялись
        rectangleA.shouldHave(text("B"));
        rectangleB.shouldHave(text("A"));
    }
}



