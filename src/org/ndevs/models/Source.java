package org.ndevs.models;

import org.ndevs.schemes.SourceScheme;

public class Source {
    private SourceScheme uri;
    private String body;
    private int pointer;
    private String suffix;

    public Source() {
        uri = new SourceScheme();
        initSource();
    }

    public Source(String uri) {
        this.uri = new SourceScheme(uri);
        initSource();
    }

    private void initSource() {
        setBody();
        setPointer();
        setSuffix();
    }

    public String getBody() {
        return body;
    }

    private void setBody() {
        body = uri.getBody();
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPointer() {
        return pointer;
    }

    private void setPointer() {
        pointer = uri.getPointer();
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public String getSuffix() {
        return suffix;
    }

    private void setSuffix() {
        suffix = uri.getSuffix();
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return body + pointer + suffix;
    }
}