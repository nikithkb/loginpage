package com.blueyonder.ui;

import com.blueyonder.dao.LoginAppImpl;

public class Frontend {
    public static void main(String[] args) {
        LoginAppImpl login = new LoginAppImpl();
        login.confirmUser("nikith", "nikith");
        login.confirmUser("zen", "zen");
        login.confirmUser("nikith", "zen");
    }
}
