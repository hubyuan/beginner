package cn.wfy.map;

public class SmallInteger implements Comparable<SmallInteger> {


    final int signum;

    public int compareTo(SmallInteger o) {
        return 0;
    }

    public SmallInteger(int signum) {

        this.signum = signum;
    }

    public SmallInteger(String val, int signum) {

        this.signum = signum;
    }

    public SmallInteger and(SmallInteger val) {
//return (getint()+val.getint());
        return null;
    }

    private int getint() {
        return signum;
    }
}
