package com.datousbt.btautomation.model;

public class DeviceConfig {

    public String name;

    public String mac;

    public String connect;

    public String disconnect;

    public boolean enable;

    public String executor;

    public DeviceConfig() {

        enable = true;
        executor = "root";
    }
}