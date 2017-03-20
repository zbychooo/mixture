package com.mycompany.service;

import com.mycompany.CustomUrlException;

import java.util.Map;
import java.util.Random;

public class UrlMapService {

    private static final String PREFIX = "smrtcd.rs/";

    private static final int TOKEN_SIZE = 7;

    private static final String ALPHA_NUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private Map<String, String> urlMap;

    private UrlMapService() {
        this.urlMap = FileService.loadData();
    }

    private static UrlMapService instance;

    /**
     * Adds url to url map and returns its key
     *
     * @param url url to be added
     * @return url token
     */
    public String addUrl(String url) {
        String key = buildKey(url, false);
        urlMap.put(key, url);
        return key;
    }

    /**
     * Adds custom url to given url
     *
     * @param url       given url
     * @param customUrl custom url
     * @return custom url
     * @throws CustomUrlException occurs when custom url is already taken
     */
    public String addUrl(String url, String customUrl) throws CustomUrlException {

        String customKey = buildKey(customUrl, true);
        if (urlMap.keySet().contains(customKey)) {
            throw new CustomUrlException("Error: Short Url already in use");
        }
        urlMap.put(customKey, url);
        return customKey;
    }

    /**
     * Gets url for given token
     *
     * @param token given token
     * @return url
     */
    public String getUrl(String token) {
        return urlMap.get(token);
    }

    /**
     * Save data into file database
     */
    public void saveData() {
        FileService.writeFile(this.urlMap);
    }

    /**
     * Assigns token to given url value
     *
     * @param value
     * @return token
     */
    private String assignToken(String value) {

        int index;
        int tokenSize = value.length() < TOKEN_SIZE ? value.length() : TOKEN_SIZE;
        Random random = new Random();

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < tokenSize; i++) {
            index = random.nextInt(ALPHA_NUMERIC.length());
            result.append(ALPHA_NUMERIC.charAt(index));
        }

        return result.toString();

    }

    /**
     * Builds key for url map
     *
     * @param url      given url
     * @param isCustom boolean flag indicator
     * @return key
     */
    private String buildKey(String url, boolean isCustom) {

        String key;
        if (isCustom) {
            key = PREFIX + url;
        } else {
            key = PREFIX + assignToken(url);
        }
        return key;
    }

    /**
     * Returns single url map service
     *
     * @return instance of url map service
     */
    public static UrlMapService getInstance() {
        if (instance == null) {
            instance = new UrlMapService();
        }
        return instance;
    }
}
