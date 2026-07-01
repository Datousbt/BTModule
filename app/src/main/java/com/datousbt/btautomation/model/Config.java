package com.datousbt.btautomation.model;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public boolean enabled = true;

    public int debounce = 5000;

    public List<DeviceConfig> devices =
            new ArrayList<>();
}