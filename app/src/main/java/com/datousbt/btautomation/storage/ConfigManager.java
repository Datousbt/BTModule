package com.datousbt.btautomation.storage;

import android.content.Context;

import com.datousbt.btautomation.model.Config;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigManager {

    private static final Gson gson =
            new Gson();

    private static File getFile(
            Context context) {

        return new File(
                context.getFilesDir(),
                "config.json");
    }

    public static Config load(
            Context context) {

        try {

            File f = getFile(context);

            if (!f.exists())
                return new Config();

            return gson.fromJson(
                    new FileReader(f),
                    Config.class);

        } catch (Exception e) {

            return new Config();
        }
    }

    public static void save(
            Context context,
            Config config) {

        try {

            FileWriter fw =
                    new FileWriter(
                            getFile(context));

            gson.toJson(
                    config,
                    fw);

            fw.close();

        } catch (Exception ignored) {

        }
    }
}