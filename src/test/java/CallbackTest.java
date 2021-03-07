import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CallbackTest {

    @Test
    void shouldSubmitRequest() {
        Configuration.timeout = 15000;
        open("http://localhost:9999");
        LocalDate date = LocalDate.now();
        LocalDate returnDate = date.plusDays(9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        $("[data-test-id=city] input").setValue("Тула");
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(""+formatter.format(returnDate));
        $("[data-test-id=name] input").setValue("Морозов Матвей");
        $("[data-test-id=phone] input").setValue("+79200000000");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
    }

    @Test
    void shouldSubmitRequest2() {
        Configuration.timeout = 15000;
        open("http://localhost:9999");
        LocalDate date = LocalDate.now();
        LocalDate returnDate = date.plusDays(9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        $("[data-test-id=city] input").setValue("Ту");
        $(withText("Тула")).click();
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(""+formatter.format(returnDate));
        $("[data-test-id=name] input").setValue("Морозов Матвей");
        $("[data-test-id=phone] input").setValue("+79200000000");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
    }
}
