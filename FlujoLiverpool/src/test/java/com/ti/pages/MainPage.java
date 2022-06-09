package com.ti.pages;

import com.ti.base.DriverFactory;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainPage {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    @FindBy(linkText = "cerveza")
    private WebElement lnkBuscado;
    private JavascriptExecutor js;


    @FindBy(id = "opc_pdp_addCartButton")
    private WebElement btnAddToCart;

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    public void scrollWindow(String scroll){
        js = (JavascriptExecutor)driver;
        try {
            switch (scroll){
                case "up":
                    js.executeScript("window.scrollBy(0,-250)");
                    break;
                case "down":
                    js.executeScript("window.scrollBy(0,250)");
                    break;
                default:
                    System.err.println("Bad option");
                    break;
            }
        }catch (JavascriptException je){
            System.err.println(String.format("Class: MainPAge | Method: scroll | Exception sec: "+ je.getMessage()));
        }
    }

    public void addTocart(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        btnAddToCart.click();
    }

    private String getItemSearched(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(lnkBuscado));
        return lnkBuscado.getText();
    }
    public void verifyItemSearched(){
        Assert.assertTrue(getItemSearched().equals("cerveza"));
    }

}
