package com.ti.testcases;

import com.ti.base.BrowserType;
import com.ti.base.DriverFactory;
//import com.ti.pages.LoginPage;
//import com.ti.pages.StudentPage;
import com.ti.pages.SearchPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    String baseURL = "https://www.liverpool.com.mx/tienda/home";
    Map<String, String> productToSearch = new HashMap<>();
    Map<String, String> studentAccountInfo = new HashMap<>();
    String[] studentPersonalDetails = {"Female", "TestStudent", "StudentLastName", "14", "TestAddress"};
    SearchPage search;

//    StudentPage studentPage;
//    LoginPage loginPage;

    @BeforeTest
    @Parameters("browser")
     void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser.toUpperCase()));
        DriverFactory.getInstance().getDriver().navigate().to(baseURL);

        productToSearch.put("product1", "cerveza");
        productToSearch.put("product2", "vino");

//        studentAccountInfo.put("email", "test@email.com");
//        studentAccountInfo.put("user", "testuser");
//        studentAccountInfo.put("password", "test123");
        search = new SearchPage();
//        loginPage = new LoginPage();
//        studentPage = new StudentPage();
    }

    @AfterTest
    void turnDown(){
//        studentPage.deleteStudent();
        DriverFactory.getInstance().removeDriver();
    }
}
