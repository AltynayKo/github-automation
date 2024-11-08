package com.epam.ta.service;

import com.epam.ta.model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(UserDataReader.getTestData(TESTDATA_USER_NAME),
                UserDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", UserDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
    public static User withEmptyPassword(){
        return new User(UserDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
