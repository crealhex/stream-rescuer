package org.ndevs.controllers;

import org.ndevs.models.Mediator;
import org.ndevs.models.Source;

public class SourceController extends Mediator {
    private String url;
    private Source source;

    public SourceController() {
        source = new Source();
    }

    public SourceController(Source source) {
        url = source.toString();
        this.source = source;
    }

    public SourceController(String url) {
        this.url = url;
        String[] partials = getPartialsFromURL();
        source = new Source(partials[0], partials[1], partials[2]);
    }

//    public String getUrl() {
//        return url;
//    }

    public void setUrl(String url) {
        this.url = url;
        String[] partials = getPartialsFromURL();
        source.setUrlname(partials[0]);
        source.setPointer(partials[1]);
        source.setSuffix(partials[2]);
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    private String[] getPartialsFromURL() {
        String urlname, pointer, suffix;
        String[] tmp;

        tmp = dispatcher(url, "_");
        urlname = tmp[0];
        tmp = dispatcher(tmp[1], ".");
        pointer = tmp[0];
        suffix = tmp[1];

        return new String[]{
                urlname,
                pointer,
                suffix,
        };
    }

    private String[] dispatcher(String textline, String separator) {
        textline = reverse(textline);
        String[] chars = textline.split("");

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            tmp.append(chars[i]);
            if (chars[i].equals(separator)) {
                break;
            }
            chars[i] = "";
        }

        String[] response = new String[2];
        response[1] = tmp.reverse().toString();

        tmp = new StringBuilder();
        tmp.append(String.join("", chars));
        response[0] = tmp.reverse().toString();

        return response;
    }
}
