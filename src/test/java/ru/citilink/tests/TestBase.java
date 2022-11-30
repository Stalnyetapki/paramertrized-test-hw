package ru.citilink.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ru.citilink.pages.MainPage;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.citilink.ru";
        Configuration.browserSize = "1920x1080";
    }
}
