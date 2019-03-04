package org.ndevs.models;

public class Source extends Mediator {
    private String urlname;
    private String pointer;
    private String suffix;

    public Source() {
        urlname = "example_url_name_";
        pointer = "xxxxx";
        suffix = ".dev";
    }

    public Source(String urlname, String pointer, String suffix) {
        this.urlname = urlname;
        setPointer(pointer);
        this.suffix = suffix;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        if (pointer.startsWith("_") && pointer.endsWith(".")) {
            for (int i = 1; i <= 2; i++) {
                pointer = reverse(pointer).substring(1);
            }
        }
        this.pointer = pointer;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return urlname + pointer + suffix;
    }
}
