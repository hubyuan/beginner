package cn.wfy.lock.concurrent;

public class ReenOkLock {
    private Syn syn;
    private FairSyn fairSyn;
    private UnFairSyn unFairSyn;

    public ReenOkLock() {
        this(false);
    }

    public ReenOkLock(boolean fair) {
        syn = fair ? fairSyn : unFairSyn;

    }


    public void lock() {
        syn.tryAcquireLock();
    }

    public void unlock() {
        syn.tryReleaseLock();

    }

    class Syn {

        public void tryAcquireLock() {

        }

        public void tryReleaseLock() {

        }
    }

    class FairSyn extends Syn {
    }

    class UnFairSyn extends Syn {
    }
}
