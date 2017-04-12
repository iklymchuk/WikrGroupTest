package com.klymchuk.rozetkaProject;

import com.klymchuk.rozetkaProject.pages.IphonePage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Date;
import static com.klymchuk.rozetkaProject.data.Const.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by iklymchuk on 4/12/17.
 */
@RunWith(DataProviderRunner.class)
public class IphoneTest extends BaseTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { IPHONE_7_URI, IPHONE_7_WEIGHT, IPHONE_7_DIAGONAL, IPHONE_7_RAM },
                { IPHONE_7_PLUS_URI, IPHONE_7_PLUS_WEIGHT, IPHONE_7_PLUS_DIAGONAL, IPHONE_7_PLUS_RAM },
        };
    }

    @Test
    @UseDataProvider("data")
    public void iphoneTest(final String url, final String weight, final String diagonal, final String ram) throws InterruptedException {
        driver.get(url);
        dummyWaiter(10000);

        IphonePage iphone = new IphonePage(driver);
        dummyWaiter(5000);

        assertEquals(weight, iphone.getWeight());
        assertEquals(diagonal, iphone.getDiagonal());
        assertEquals(ram, iphone.getRam());

        iphoneInfo.setIphone7Price(iphone.getPrice());

        iphone.buy();

        assertEquals("1", iphone.getCountOfPurchase());

        iphoneInfo.setDate(new Date());
        dbReport(iphoneInfo);

    }

}
