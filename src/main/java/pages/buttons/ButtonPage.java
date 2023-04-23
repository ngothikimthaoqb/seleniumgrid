package pages.buttons;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.buttons.ButtonPageObject;

public class ButtonPage extends BasePage {

    private final WebDriver driver;
    private ButtonPageObject buttonPageObject;

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
        this.buttonPageObject = new ButtonPageObject();
    }

    public boolean verifyAllButtons(){
        return isPrimaryButtonCorrect() && isDangerButtonCorrect() && isSuccessButtonCorrect();
    }

    private boolean isPrimaryButtonCorrect(){
        return getElementText(driver, buttonPageObject.primaryButton).equals("Primary");
    }

    private boolean isDangerButtonCorrect(){
        return getElementText(driver, buttonPageObject.dangerButton).equals("Danger");
    }

    private boolean isSuccessButtonCorrect(){
        return getElementText(driver, buttonPageObject.dangerButton).equals("Success");
    }

}
