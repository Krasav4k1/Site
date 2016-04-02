package com.servise.binder;

import com.servise.UserService;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport{


    private final UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(userService.findById(Integer.parseInt(text)));
    }

}
