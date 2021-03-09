import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CallbackTest {

    @BeforeEach
    void opening() {
        open("http://localhost:9999");
    }

    public String date(int shift) {
        LocalDate date = LocalDate.now();
        LocalDate returnDate = date.plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(returnDate);
    }

    @Test
    void shouldSubmitRequest() {

        $("[data-test-id=city] input").setValue("Тула");
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue("" + date(9));
        $("[data-test-id=name] input").setValue("Морозов Матвей");
        $("[data-test-id=phone] input").setValue("+79200000000");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofMillis(15000));
        $(withText(""+date(9))).shouldBe(Condition.visible);
    }

    @Test
    void shouldSubmitRequest2() {
        $("[data-test-id=city] input").setValue("Ту");
        $(withText("Тула")).click();
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue("" + date(9));
        $("[data-test-id=name] input").setValue("Морозов Матвей");
        $("[data-test-id=phone] input").setValue("+79200000000");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofMillis(15000));
        $(withText(""+date(9))).shouldBe(Condition.visible);
    }
}
