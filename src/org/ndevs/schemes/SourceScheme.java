package org.ndevs.schemes;

import org.ndevs.vendors.Cutter;

public class SourceScheme {
    private String uri;
    private Cutter body;
    private Cutter pointer;
    private Cutter suffix;

    public SourceScheme() {
        uri = "https://www.example.com/stream/hls/index_12345.ts";
        stablish();
    }

    public SourceScheme(String uri) {
        this.uri = uri;
        stablish();
    }

    private void stablish() {
        body = new Cutter(uri, '_');
        body.setBlinks(body.getMaxBlinks());
        body.start();

        pointer = new Cutter(body.getFoot(), '.');
        pointer.setBlinks(pointer.getMaxBlinks());
        pointer.start();

        suffix = new Cutter(uri, '.');
        suffix.setBlinks(suffix.getMaxBlinks());
        suffix.start();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
        stablish();
    }

    public String getBody() {
        return body.getHead() + body.getLimiter();
    }

    public int getPointer() {
        try {
            return Integer.parseInt(pointer.getHead());
        } catch (NumberFormatException e) {
            return 11111;
        }
    }

    public String getSuffix() {
        return suffix.getLimiter() + suffix.getFoot();
    }
}
