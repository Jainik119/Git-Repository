package com.adit.util;

/**
 * Created by jainik.bakaraniya on 3/14/2017.
 */
public interface RestApiConstantURL {

    /*ApplicationTestController*/
    public final static String API_TEST_URL = "/test";

    /*UserController*/
    public final static String SAVE_USER = "/save";
    public final static String DELETE_USER = "/delete/{id}";
    public final static String FIND_ALL_USER = "/all";
    public final static String FIND_ONE_USER = "/get/{id}";

    /*CommonController*/
    public final static String SAVE_COUNTRY = "/country/save";
    public final static String DELETE_COUNTRY = "/country/delete/{id}";
    public final static String FIND_ALL_COUNTRY = "/country/all";
    public final static String FIND_ONE_COUNTRY = "/country/get/{id}";
    public final static String SAVE_STATE = "/state/save";
    public final static String DELETE_STATE = "/state/delete/{id}";
    public final static String FIND_ALL_STATE = "/state/all";
    public final static String FIND_ONE_STATE = "/state/get/{id}";
}
