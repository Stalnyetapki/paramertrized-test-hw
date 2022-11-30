package ru.citilink.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement catalogListButton = $("button.PopupCatalogMenu__button-open");


    public MainPage openPage() {
        open("/");
        // executeJavaScript("$('div.Tooltip__block').remove()");
        $(".Main__category-wrapper").shouldHave(text("Популярные категории"));
        return this;
    }

    public MainPage checkSubcategoryExisting(String category, String subcategory) {
        catalogListButton.click();
        $(".CatalogMenu__category-item[data-title='" + category + "']").hover();
        // $(".CatalogMenu__subcategory-title").shouldHave(text(category));
        $(".CatalogMenu__subcategory-label[data-title='" + subcategory + "']").shouldBe(visible);
        return this;
    }

    public MainPage checkCategoryBlockAppearing(String category) {
        $(".CatalogMenu__category-item[data-title='" + category + "']").hover();
        $(".CatalogMenu__subcategory-title").shouldHave(text(category));
        return this;
    }

    public MainPage checkCategoryList(String category) {
        catalogListButton.click();
        $(".CatalogMenu__category-item[data-title='" + category + "']").scrollTo().shouldBe(visible);
        return this;
    }

    public MainPage checkListOfSubcategory(String category, String subcategory, List<String> subcategories) {
        catalogListButton.click();
        $(".CatalogMenu__category-item[data-title='" + category + "']").hover();
        $(".CatalogMenu__subcategory-label[data-title='" + subcategory + "']").parent().$$(".CatalogMenu__subcategory-link").
                filter(visible).shouldHave(CollectionCondition.texts(subcategories));
        return this;
    }

}
