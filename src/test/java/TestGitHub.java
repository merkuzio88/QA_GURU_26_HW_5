import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestGitHub {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void gitHubTest() {
        open("/");
        $$("button").findBy(text("Solutions")).hover();
        $$("a.HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldBe(visible)
                .shouldHave(allOf(text("The AI-powered"), text("developer platform.")));
    }

    @Test
    void actionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void dragAddDropToTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }
}
