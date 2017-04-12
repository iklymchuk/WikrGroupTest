package com.klymchuk.rozetkaProject;

import com.klymchuk.rozetkaProject.pages.ProfilePage;
import com.klymchuk.rozetkaProject.pages.RegistrationPage;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static com.klymchuk.rozetkaProject.data.Const.SIGNUP_URL;
import static org.junit.Assert.assertEquals;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class RegistrationTest extends BaseTest {

    @Test
    public void successfulRegistrationTest() throws InterruptedException, IOException, NoSuchAlgorithmException {

        driver.get(SIGNUP_URL);
        dummyWaiter(5000);

        RegistrationPage registration = new RegistrationPage(driver);
        dummyWaiter(5000);

        registration.registered(user, user +"pass", email);
        dummyWaiter(5000);

        confirmationLink = emailGenerator.getConfirmationLink(md5);
        dummyLog();

        driver.get(confirmationLink);
        ProfilePage confirmProfile = new ProfilePage(driver);
        dummyWaiter(5000);

        assertEquals(email, confirmProfile.getProfileEmail());
    }
}
