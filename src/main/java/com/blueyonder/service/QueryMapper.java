package com.blueyonder.service;

public interface QueryMapper {
    public static final String CHECK_LOGIN = "select * from userdata where username=? and password = ?";
    public static final String NON_ADMIN = "select * from userdata where admin = false";
}
