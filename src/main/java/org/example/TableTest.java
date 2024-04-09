package org.example;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TableTest {
    public static void main(String[] args) {
        // Headless modda çalışacak şekilde Selenide yapılandırması
        Configuration.headless = true;

        // ADD düğmesine tıklayarak yeni bir kayıt ekleyen ve eklenen kaydı düzenleyen test
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




