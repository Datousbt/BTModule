package com.datousbt.btautomation.shell;

public class RootExecutor {

    public static void exec(
            String command) {

        try {

            Runtime.getRuntime().exec(
                    new String[]{
                            "su",
                            "-c",
                            command
                    });

        } catch (Exception ignored) {

        }
    }
}