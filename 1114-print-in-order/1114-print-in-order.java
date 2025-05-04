class Foo {

    private boolean firstCheck;
    private boolean secondeCheck;

    public Foo() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstCheck = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(!firstCheck) {
            wait();
        }
        printSecond.run();
        secondeCheck = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!secondeCheck){
            wait();
        }
        printThird.run();
    }
}