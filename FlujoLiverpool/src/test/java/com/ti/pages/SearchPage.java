package com.ti.pages;

import com.ti.base.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchPage extends MainPage{

    @FindBy(id = "mainSearchbar")
    private WebElement txtSearchBar;

    @FindBy(className = "input-group-text")
    private WebElement btnSearch;

    @FindBy(xpath = "(//*[contains(text(), 'Cerveza Minerva Stout 355 ml')])[1]")
    private WebElement artCervezaMinerva;

    @FindBy(xpath = "(//*[contains(text(), 'Cerveza Minerva Stout 355 ml')])[3]")
    private WebElement titleCerveza;

    @FindBy(xpath = "//h2[contains(text(), 'Artículos similares')]")
    private WebElement sugestions;

    @FindBy(linkText = "Generoso")
    private WebElement lnkGeneroso;

    @FindBy(linkText = "Ordenar por:")
    private WebElement drpdSortBy;

    @FindBy(xpath = "(//button[contains(.,'Mayor precio')])[2]")
    private WebElement btnMayorPrecio;

//    @FindBy(className = "mdc-snackbar--open")
//    private WebElement alertAdded;

//    public MainPage searchItem(){
//        btnSearch.click();
//        return this;
//    }

    public void sortByHihgPrice(){
//        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(btnMayorPrecio));
        btnMayorPrecio.click();
    }

    public void selectSortBy(){
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(drpdSortBy));
        drpdSortBy.click();
    }

    private void searchItem(String obj){
        System.out.println("Objeto recibido: "+obj);
        txtSearchBar.clear();
        txtSearchBar.sendKeys(obj);
    }

    private void search(){
        btnSearch.click();
    }

    public void clickCervezaMinerva(){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(artCervezaMinerva));

        artCervezaMinerva.click();
    }

    public void scrollToDetails(){
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(titleCerveza));

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("var element = document.getElementById('o-product__productSpecsDetails');\n" +
                "element.scrollIntoView()");
    }

    public void scrollToRelated() throws InterruptedException {
//        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(sugestions));
//        Thread.sleep(2000);
//        JavascriptExecutor js =(JavascriptExecutor)driver;
//        js.executeScript("var element = document.querySelector(\"section[class='o-carousel-section'] h2[class='ti-carousel']\");\n" +
//                "element.scrollIntoView()");
        scrollWindow("down");
        scrollWindow("down");
        scrollWindow("down");
        scrollWindow("down");
        scrollWindow("down");
        scrollWindow("down");

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,0);");

    }

    public void busqueda(String obj){
        searchItem(obj);
        search();
    }


    public void addToCart() {
        addTocart();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(alertAdded));
//        Assert.assertTrue(alertAdded.getText().equals("Agregaste un producto a tu bolsa"));
    }

    public void slGeneroso(){
        lnkGeneroso.click();
    }
}
