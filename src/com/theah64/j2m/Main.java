package com.theah64.j2m;

import com.theah64.j2m.core.CodeGenJava;
import org.json.JSONException;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        final Scanner scanner = new Scanner(System.in);

        System.out.print("Model Name : ");
        final String modelName = scanner.nextLine();

        System.out.print("Paste JSON here : ");
        final String jsonString = scanner.nextLine();

        System.out.print("Do you want GSON support ? (y/n) : ");
        final String gsonSupport = scanner.nextLine();
        final boolean isNeedGsonSupport = gsonSupport.trim().toLowerCase().equals("y");

        try {
            final String output = CodeGenJava.getFinalCode(
                    jsonString,
                    modelName,
                    isNeedGsonSupport
            );

            // adding to clipboard
            final StringSelection stringSelection = new StringSelection(output);
            final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            System.out.println(output);

            System.out.println("Copied to clipboard");
            scanner.nextLine();
            System.out.println("Removed from clipboard");

        } catch (JSONException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}

