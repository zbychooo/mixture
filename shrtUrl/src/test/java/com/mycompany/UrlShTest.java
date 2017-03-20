package com.mycompany;

import com.mycompany.service.UrlMapService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.junit.Assert;

/**
 * Unit test for simple UrlSh.
 */
public class UrlShTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UrlShTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(UrlShTest.class);
    }

    public void testApp() {

        //case 1
        String testUrl1 = "http://very-long-url.com.pl/ble/u/?riwc";
        String result1 = UrlMapService.getInstance().addUrl(testUrl1);
        System.out.println(testUrl1 + " ==> " + result1);

        // case 2
        String result2 = UrlMapService.getInstance().getUrl(result1);
        System.out.println(result1 + " ==> " + testUrl1);
        Assert.assertEquals(testUrl1, result2);

        // case 3
        String result3;
        try {
            result3 = UrlMapService.getInstance().addUrl(testUrl1, "MyStringXYZ");
        } catch (CustomUrlException e) {
            result3 = e.getMessage();
        }
        System.out.println(testUrl1 + " ==> " + result3);

        // case 4
        String result4 = UrlMapService.getInstance().addUrl(testUrl1);
        System.out.println(testUrl1 + " ==> " + result4);

        // case 5
        String test2 = "http://other-url.com.pl/u/pl";
        String result5;
        try {
            result5 = UrlMapService.getInstance().addUrl(test2, "MyString");
        } catch (CustomUrlException e) {
            result5 = e.getMessage();
        }
        System.out.println(test2 + " ==> " + result5);

    }
}
