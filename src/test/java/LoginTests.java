import manager.DataProviderUser;
import model.User;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(dataProvider = "loginValidFile", dataProviderClass = DataProviderUser.class)
    public void validLoginTest(User user){
        logger.info("Success login started ===> "+"\n["+user.getEmail()+"]\n["+user.getPassword()+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Finish testing !!!!!!");
    }

   // @Test(dataProvider = "loginWrongEmailFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongEmail(User user){
        logger.info("Wrong Email login started ===> "+"\n["+user.getEmail()+"]\n["+user.getPassword()+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();


        logger.info("Finish testing !!!!!!");
    }

   // @Test
    public void loginWrongSymbolEmail(){
        User user = new User().withEmail("solodka1998mail.ru").withPassword("Atteloiv369!");
        logger.info("Empty Email login started ===> "+"\n["+user+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().buttonYalla();


        logger.info("Finish testing !!!!!!");
    }

    //@Test
    public void loginEmptyEmail(){
        User user = new User().withEmail("").withPassword("Atteloiv369!");
        logger.info("Empty Email login started ===> "+"\n["+user+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

        logger.info("Finish testing !!!!!!");
    }

   // @Test
    public void loginSpaceEmail(){
        User user = new User().withEmail("   ").withPassword("Atteloiv369!");
        logger.info("Space Email login started ===> "+"\n["+user+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        logger.info("Finish testing !!!!!!");
    }

    //@Test(dataProvider = "loginWrongPasswordFile", dataProviderClass = DataProviderUser.class)
    public void loginWrongPassword(User user){
        logger.info("Wrong Password login started ===> "+"\n["+user.getEmail()+"]\n["+user.getPassword()+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        logger.info("Finish testing !!!!!!");
    }

   // @Test
    public void loginEmptyPassword(){
        User user = new User().withEmail("solodka1998@mail.ru").withPassword("");
        logger.info("Empty Password login started ===> "+"\n["+user+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Finish testing !!!!!!");
    }

   // @Test
    public void loginSpacePassword(){
        User user = new User().withEmail("solodka1998@mail.ru").withPassword("   ");
        logger.info("Space Password login started ===> "+"\n["+user+"]\n");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);

        logger.info("Finish testing !!!!!!");
    }

}
