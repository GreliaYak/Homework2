
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class Anketa {
    @BeforeEach
    void closeBanner() {
        // открывает страницу с баннером
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");  // Открытие браузера на нужной странице
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()");  // Скрытие рекламы
        // скрываем баннер
     }



    @Test
    // открыть браузер
    // заполнить поля
    // нажать submit

    // убираем рекламный баннер

    void firstTest() {
        //Поиск и заполнение всех полей
        // открыть браузер
        // заполнить поля
        // выбрать сабмит
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("Kirill");//фио
        $("[id=lastName]").setValue("Llirik");
        $("[id=userEmail]").setValue("Llirik@ya.ru");//почта
        $("[class=custom-control-label]").click();//выбор пола муж
        $("[id=userNumber]").setValue("9798888854");// телефон

        //календарь
        $(byId("dateOfBirthInput")).click(); // такая конструкция теперь тоже работает =)
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--013").click();

        //subject
       //$("id=subjectsContainer").click(); // разве нажимая не должны после этого только вводить значения?
        $("[id=subjectsInput]").setValue("a").sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER); //тоже взяла с домашки как подсказку, почему выбираются ключи и как они работают?

        //выбор чекбокса,используется конструкция родитель+наследник.
        //указываем элемент лейбл+родитель for.
        //(почитать и разобраться. есть в таблице по формуле //E[1]?)
        $("label[for='hobbies-checkbox-3']").click();

        //загрузка файла>
        $("[id=uploadPicture]").uploadFromClasspath("Screenshot_4.png");//нашла эту подсказку у тех, кто уже сдавал. Есть информация почему именно так реализовывается?
        //адрес
        $("[id=currentAddress]").setValue("11223355, Canzas, Morei street, h 45");

        //выпадающие списки
        $("[id=react-select-3-input]").setValue("Haryana").pressEnter(); // что выполняет команда .sendKeys(Keys.ENTER)?нажимает подтверждение?
        $("[id=react-select-4-input]").setValue("Panipat").pressEnter();
        $("[id=submit]").click(); //нажать иконку Сабмит

    }
}
