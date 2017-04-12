package com.klymchuk.rozetkaProject.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by iklymchuk on 4/11/17.
 */
public class EmailGenerator {

    public final static String TEMP_MAIL_URL = "https://temp-mail.ru";
    public final static String API_MAIL_URL = "http://api.temp-mail.ru/request/mail/id/";
    private final static String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String getEmailAddress() throws IOException {
        Document doc = Jsoup.connect(TEMP_MAIL_URL).get();
        Elements emails = doc.select("[id=mail]");
        String email;
        if (emails.size() > 0) {
            email = emails.get(0).attr("value");
            return email;
        }
        return "Oups"; //sorry for that I save the time
    }

    public String getEmailMd5(String email) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(email.getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String getConfirmationLink(String md5) throws IOException, NoSuchAlgorithmException {
        Document doc = Jsoup.connect(API_MAIL_URL + md5 + "/format/php").get(); //format/html doesn't work
        Elements links = doc.select("[href]");

        for (Element link : links) {
            if (link.attr("href").toString().startsWith("https://my.rozetka.com.ua/authorize")) {
                return link.attr("href");
            }
        }
        return "Oups"; //sorry for that I save the time
    }

    public String generateRandomString(int count) {
        final StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
