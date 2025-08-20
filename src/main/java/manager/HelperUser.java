package manager;

import model.User;
import model.UserReg;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {

        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }

    public void logout() {

        click(By.xpath("//button[text()='Log out']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()='Log in']"));
    }

    public void fillLoginForm(User user) {
        type(By.name("username"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void buttonYalla() {
        click(By.xpath("//button[text()='Y’alla!']"));
    }

    public void buttonOk() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void openRegistrationForm() {
        pause(1000);
        click(By.xpath("//a[text()='Sign up']"));
    }

    public void fillRegistrForm(UserReg user) {
        type(By.name("firstName"), user.getFirstName());
        type(By.name("lastName"), user.getLastName());
        type(By.name("username"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void checkPolicyLabel() {
        click(By.xpath("//a[@href='/terms-of-use']"));
    }

    public void clickPolicyLabel() {
        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rec = label.getRect();
            int w = rec.getWidth();
            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }
}
