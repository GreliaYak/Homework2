
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.*;

public class Anketa {

    @Test
    // открыть браузер
    // заполнить поля
    // нажать submit

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
        $("#dateOfBirthInput").click(); // тут был затык. Почему если делаешь  ("[id=dateOfBirthInput]").click(); то код дальше не шел? а через # корректно отрабатывает
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
        $("[id=react-select-3-input]").setValue("Haryana").sendKeys(Keys.ENTER); // что выполняет команда .sendKeys(Keys.ENTER)?нажимает подтверждение?
        $("[id=react-select-4-input]").setValue("Panipat").sendKeys(Keys.ENTER);
        $("[id=submit]").click(); //нажать иконку Сабмит

    }
}
