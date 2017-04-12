package com.klymchuk.rozetkaProject;

import com.klymchuk.rozetkaProject.entities.TestRunInfo;
import com.klymchuk.rozetkaProject.util.EmailGenerator;
import com.klymchuk.rozetkaProject.util.HibernateUtil;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * Created by iklymchuk on 4/12/17.
 */
public class BaseTest {

    protected WebDriver driver;
    protected EmailGenerator emailGenerator;
    protected String email;
    protected String md5;
    protected String user;
    protected String confirmationLink;
    protected TestRunInfo iphoneInfo = new TestRunInfo();

    @BeforeClass
    public static void setupClass() {
        FirefoxDriverManager.getInstance().setup();
    }

    @Before
    public void setupTest() throws IOException, NoSuchAlgorithmException {
        driver = new FirefoxDriver();
        emailGenerator = new EmailGenerator();
        email = emailGenerator.getEmailAddress();
        md5 = emailGenerator.getEmailMd5(email);
        user = emailGenerator.generateRandomString(10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void dummyLog() {
        System.out.println("email: " + email);
        System.out.println("md5: " + md5);
        System.out.println("user: " + user);
        System.out.println("confirmationLink: " + confirmationLink);
    }

    protected void dummyWaiter(int ms) throws InterruptedException {
        Thread.sleep(ms);
    }

    protected void dbReport(TestRunInfo testRunInfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();

        session.save(testRunInfo);
        session.getTransaction().commit();
        session.close();
    }
}
