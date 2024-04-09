package org.example;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.ElementsCollection.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ButtonTest {

    public static void main(String[] args) {
        // Headless modda çalışacak şekilde Selenide yapılandırması
        Configuration.headless = true;

        // 1. Senaryo: Buttons öğesine tıklayarak "Click Me" düğmesine tıklayan ve görünen mesajı okuyan test
        open("https://demoqa.com/elements");
        $($x("Buttons")).click();
        $($x("Click Me")).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));

        // 2. Senaryo: ADD düğmesine tıklayarak yeni bir kayıt ekleyen ve eklenen kaydı düzenleyen test
        open("https://demoqa.com/webtables");
        $("#addNewRecordButton").click();
        $("#firstName").setValue("Abdullah");
        $("#lastName").setValue("Şahin");
        $("#userEmail").setValue("asahin@example.com");
        $("#age").setValue("36");
        $("#salary").setValue("500000");
        $("#department").setValue("TEST");
        $("#submit").click();
        $(".rt-tbody").shouldHave(text("Abdullah"), text("Şahin"), text("asahin@example.com"), text("36"), text("500000"), text("TEST"));
    }
}
