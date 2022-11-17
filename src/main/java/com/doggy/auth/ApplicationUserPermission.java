package com.doggy.auth;

public enum ApplicationUserPermission {

    BOARD_WRITE("board:write"),
    BOARD_READ("board:read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
