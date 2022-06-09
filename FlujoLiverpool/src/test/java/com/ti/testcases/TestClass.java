package com.ti.testcases;

import org.testng.annotations.Test;

public class TestClass extends BaseTest {
    @Test(priority = 1)
    void searchCerveza() throws InterruptedException {
//        System.out.println("Producto: "+productToSearch.get("product1"));
        search.busqueda(productToSearch.get("product1"));
        search.verifyItemSearched();
        search.clickCervezaMinerva();
//        search.scrollToDetails();
//        Thread.sleep(5000);
//        search.scrollToRelated();
//        Thread.sleep(5000);
        search.addToCart();
//        Thread.sleep(10000);

//        mainPage.searchItem(productToSearch.get("product1"));
//        loginPage.login(userCredentials.get("username"), userCredentials.get("password"));
//        loginPage.verifySchoolName();
    }

    @Test(priority = 2)
    void selectWine() throws InterruptedException {
        search.busqueda(productToSearch.get("product2"));
        search.slGeneroso();
        search.selectSortBy();
        search.sortByHihgPrice();
        Thread.sleep(10000);

//        studentPage.clickStudents();
//        studentPage.clickCreateNew();
//        studentPage.studentPersonalDetails(studentPersonalDetails);
//        studentPage.accountInformation(studentAccountInfo);
//        studentPage.schoolDetails("015");
//        studentPage.validateStudentsIsAdded(studentPersonalDetails[1]);
    }

}
