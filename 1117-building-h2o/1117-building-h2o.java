class H2O {
    private AtomicInteger count = new AtomicInteger(0);

    public H2O() {
        
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (count.get() == 2) {
            wait();
        }
        count.getAndIncrement();
        releaseHydrogen.run();
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (count.get() != 2) {
            wait();
        }
        count.set(0);
        releaseOxygen.run();    
        notifyAll();
    }
}