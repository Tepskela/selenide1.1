package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

class CallbackTest {

    @Test
    void shouldTest() {
        open ("http://localhost:9999/");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Александр");
        form.$("[data-test-id=phone] input").setValue("+79000000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class=button__content]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}