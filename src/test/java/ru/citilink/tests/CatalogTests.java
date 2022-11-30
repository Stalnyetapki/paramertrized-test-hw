package ru.citilink.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class CatalogTests extends TestBase {


    @ValueSource(strings = {"Смартфоны и гаджеты", "Ноутбуки и компьютеры", "Телевизоры, аудио-видео, фото",
            "Бытовая техника для дома и кухни", "Строительство и ремонт", "Дом и дача",
            "Умный дом и системы безопасности", "Автотовары", "Канцтовары, Мебель и Офисная техника",
            "Красота и здоровье", "Детские товары", "Спорт и отдых", "Товары для геймеров", "Новый год",
            "Сервисы и услуги"})
    @Tag("High")
    @ParameterizedTest(name = "Check that {0} category exists in catalog")
    void checkCatalogCategoryTest(String category) {

        mainPage.openPage().checkCategoryList(category);
    }

    @CsvSource(value = {"Смартфоны и гаджеты | Смартфоны",
            "Ноутбуки и компьютеры | Манипуляторы и устройства ввода",
            "Телевизоры, аудио-видео, фото | Кабели для ТВ и аудио-видео"},
            delimiter = '|')
    @Tag("High")
    @ParameterizedTest(name = "Check that {1} subcategory exists in {0} category")
    void checkCatalogSubcategoryTest(String category, String subcategory) {

        mainPage.openPage().checkSubcategoryExisting(category, subcategory);
    }


    static Stream<Arguments> checkCatalogImgSubcategoryTest() {
        return Stream.of(
                Arguments.of("Смартфоны и гаджеты", "Смартфоны",
                        List.of("Смартфоны", "Премиум смартфоны", "Смартфоны Apple iPhone",
                                "Смартфоны Samsung", "Смартфоны Xiaomi", "Недорогие смартфоны",
                                "Мощные смартфоны", "Смартфоны на Android", "Смартфоны с хорошей камерой")));
    }

    @MethodSource
    @Tag("High")
    @ParameterizedTest(name = "Check that {1} subcategory in {0} category have next list of subcategories {2}")
    void checkCatalogImgSubcategoryTest(String category, String subcategory, List<String> subcategories) {
        mainPage.openPage().checkListOfSubcategory(category, subcategory, subcategories);
    }

}
