package org.ndevs.models;

public class Mediator {
    protected String reverse(String textline) {
        String[] chars = textline.split("");
        StringBuilder drow = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            drow.append(chars[i]);
        }

        return drow.toString();
    }
}
