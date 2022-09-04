package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        first();
        second();
        third();
    }

    public static void first() {
        String str = "Enter in the console sentence of five words";
        String[] strings = str.split(" ");
        String maxStr = " ";
        for (int i = 0; i < strings.length -1; i++) {
            if (strings[i].length() > maxStr.length()) {
                maxStr = strings[i];
            }
        }
        System.out.println(String.format("max str - %s with %s letters", maxStr, maxStr.length()));
        System.out.println(String.format("second word in reverse order - %s", new StringBuilder(strings[1]).reverse()));

    }

    public static void second() {
        String str = "Enter       a sentence that            contains the words  between more    than one     space. Convert    all spaces, consecutive, one. For example, if we introduce the sentence\"I am  learning Java   Core», we have to get the \"I'm learning Java Core»\n";
        String regex = "\\s+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);

        System.out.println(String.format("Corrected string:  %s", matcher.replaceAll(" ")));
    }

    public static void third() {
        String regex = "\\$\\d+\\.\\d+";
        String text = "$43.228, $3443.43343433,$34GFDGDG.REER,  4.2,$324.232fdf323";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found occurence " + text.substring(matcher.start(), matcher.end()) + " from " + matcher.start() + " to " + matcher.end());
        }
    }

}
