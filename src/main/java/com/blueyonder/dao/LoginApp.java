package com.blueyonder.dao;

import com.blueyonder.model.User;

public interface LoginApp {
    public User confirmUser(String username, String password);
    public User returnNonAdminUsers();
}
