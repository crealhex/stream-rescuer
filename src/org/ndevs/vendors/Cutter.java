package org.ndevs.vendors;

public class Cutter {

    private String uri;
    private char limiter;
    private short blinks;

    private short uriLength;
    private short maxBlinks;
    private short distance;
    private String head;
    private String foot;

    public Cutter(String uri, char limiter) {
        this.uri = uri;
        this.limiter = limiter;
        initCutter();
    }

    public Cutter(String uri, char limiter, short blinks) {
        this.uri = uri;
        this.limiter = limiter;
        this.blinks = blinks;
        initCutter();
    }

    private void initCutter() {
        setUriLength();
        setMaxBlinks();
    }

    public void start() {
        setDistance();
        setHead();
        setFoot();
    }

    public char getLimiter() {
        return limiter;
    }

    public void setLimiter(char limiter) {
        this.limiter = limiter;
    }

    public short getBlinks() {
        return blinks;
    }

    public void setBlinks(short blinks) {
        this.blinks = blinks;
    }

    public short getUriLength() {
        return uriLength;
    }

    private void setUriLength() {
        this.uriLength = (short) uri.length();
    }

    public short getMaxBlinks() {
        return maxBlinks;
    }

    private void setMaxBlinks() {
        short maxBlinks = 0;
        for (int i = 1; i < uriLength; i++) {
            if (uri.charAt(i) == limiter) {
                maxBlinks++;
            }
        }
        this.maxBlinks = (short) (maxBlinks - 1);
    }

    public short getDistance() {
        return distance;
    }

    private void setDistance() {
        short currentBlink = 0, distance = 0;
        for (int i = 1; i < uriLength; i++) {
            distance++;
            if (uri.charAt(i) == limiter) {
                if (currentBlink == blinks) {
                    break;
                }
                currentBlink++;
            }
        }
        this.distance = distance;
    }

    public String getHead() {
        return head;
    }

    private void setHead() {
        StringBuilder head = new StringBuilder();
        for (int i = 0; i < uriLength; i++) {
            if (distance == i) break;
            head.append(uri.charAt(i));
        }
        this.head = head.toString();
    }

    public String getFoot() {
        return foot;
    }

    private void setFoot() {
        StringBuilder foot = new StringBuilder();
        boolean state = false;
        for (int i = 0; i < uriLength; i++) {
            if (state) foot.append(uri.charAt(i));
            if (distance == i) state = true;
        }
        this.foot = foot.toString();
    }

    @Override
    public String toString() {
        return "" +
                "INPUT DATA\n" +
                "\t URI: " + uri + "\n" +
                "\t Limiter: " + limiter + "\n" +
                "\t Blinks: " + blinks + "\n" +
                "\n" +
                "ADDITIONAL\n" +
                "\t URI Length: " + uriLength + "\n" +
                "\t Max Blinks: " + maxBlinks + "\n" +
                "\t Distance: " + distance + "\n" +
                "\t Head: " + head + "\n" +
                "\t Foot: " + foot;
    }
}