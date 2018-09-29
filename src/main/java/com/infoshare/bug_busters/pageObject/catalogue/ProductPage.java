package com.infoshare.bug_busters.pageObject.catalogue;

import com.infoshare.bug_busters.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductPage {

    private WebDriver driver;
    private Waits waits;
    @FindBy(xpath = "//div[@id='productDetails']")
    WebElement productDetails;
    @FindBy(xpath = "//a[@class='scroll-to']")
    WebElement scrollProduct;
    @FindBy(xpath = "//a[@id='buttonCart']")
    WebElement buttonAddToCart;
    @FindBy(xpath = "//span[@id='numItemsInCart']")
    WebElement buttoNnumberOfElementsInCart;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkProductsDetails() {

        scrollProduct.click();
        productDetails.isDisplayed();
        buttonAddToCart.isDisplayed();
        assertTrue("Product is not displayed", buttonAddToCart.isDisplayed());


    }

    public void addingProduct() {
//        scrollProduct.click();
//        productDetails.isDisplayed();

        buttonAddToCart.click();
        //buttoNnumberOfElementsInCart.isDisplayed();
       // buttoNnumberOfElementsInCart.getText("1 item(s) in cart");
       // assertThat("Product is not added",buttoNnumberOfElementsInCart.equals("1 item(s) in cart"));
    }
    public void textFromButtonNumberOfElementsInCart(){


    }

}
