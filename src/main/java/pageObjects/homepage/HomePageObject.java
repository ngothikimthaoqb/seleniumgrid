package pageObjects.homepage;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    public final By button = By.xpath("//li/a[text()='Buttons']");
    public final By checkbox = By.xpath("//li/a[text()='Checkbox']");
    public final By datepicker = By.xpath("//li/a[text()='Datepicker']");
    public final By switchWindow = By.xpath("//li/a[text()='Switch Window']");
    public final By keyAndMousePress = By.xpath("//li/a[text()='Key and Mouse Press']");
    public final By completeWebForm = By.xpath("//li/a[text()='Complete Web Form']");
    public final By fileUpload = By.xpath("//li/a[text()='File Upload']");
    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
