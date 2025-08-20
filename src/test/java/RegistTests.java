import model.UserReg;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccessTest(){
        int i = new Random().nextInt(1000)+1000;

        UserReg user=new UserReg()
                .setFirstName("test").setLastName("test").setEmail("test"+i+"@test.com").setPassword("Test"+i+"!");
        logger.info("Success Registration started ===> "+" \nFirstName = ["+user.getFirstName()
                +"] \nLastName = ["+user.getLastName()+"] \nEmail = ["+user.getEmail()+"] \nPassword = ["+user.getPassword()+"]");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrForm(user);
        app.getHelperUser().getScreen("src/test/screenshots/screen-"+i +".png");
        app.getHelperUser().clickPolicyLabel();
        app.getHelperUser().buttonYalla();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Finish testing !!!!!!");
    }


}
