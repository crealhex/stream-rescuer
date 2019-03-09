package org.ndevs.views;

import org.ndevs.models.Source;

public class Main {
    public static void main(String[] args) {
        Source source = new Source();
//        System.out.println(source.getBody());
//        System.out.println(source.getPointer());
//        System.out.println(source.getSuffix());
        System.out.println(source.toString());
    }
}
