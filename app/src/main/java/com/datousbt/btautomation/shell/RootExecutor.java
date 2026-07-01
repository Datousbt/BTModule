package com.datousbt.btautomation.shell;

import com.datousbt.btautomation.util.Logger;

public class RootExecutor {

    public static void exec(
            String command) {

        try {

            Logger.d(
                    "exec: " + command);

            Process p =
                    Runtime
                            .getRuntime()
                            .exec(
                                    new String[]{
                                            "su",
                                            "-c",
                                            command
                                    });

            p.waitFor();

        } catch (Throwable t) {

            Logger.e(t);
        }
    }
}