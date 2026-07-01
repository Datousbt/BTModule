package com.datousbt.btautomation.hook;

import android.bluetooth.BluetoothDevice;

import com.datousbt.btautomation.model.Config;
import com.datousbt.btautomation.model.DeviceConfig;
import com.datousbt.btautomation.shell.RootExecutor;
import com.datousbt.btautomation.util.Debouncer;
import com.datousbt.btautomation.util.Logger;

public class BluetoothReceiver {

    private static Config config;

    public static void loadConfig(
            Config cfg) {

        config = cfg;
    }

    public static void onConnected(
            BluetoothDevice device) {

        execute(device, true);
    }

    public static void onDisconnected(
            BluetoothDevice device) {

        execute(device, false);
    }

    private static void execute(
            BluetoothDevice device,
            boolean connected) {

        if (config == null)
            return;

        String mac =
                device.getAddress();

        Logger.d(
                "bluetooth: "
                        + mac
                        + " "
                        + connected);

        for (DeviceConfig d :
                config.devices) {

            if (!d.enable)
                continue;

            if (!mac.equalsIgnoreCase(
                    d.mac))
                continue;

            String key =
                    mac + connected;

            if (!Debouncer.allow(
                    key,
                    config.debounce))
                return;

            if (connected) {

                RootExecutor.exec(
                        d.connect);

            } else {

                RootExecutor.exec(
                        d.disconnect);
            }

            break;
        }
    }
}