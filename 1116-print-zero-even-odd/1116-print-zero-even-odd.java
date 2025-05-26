class ZeroEvenOdd {
    private int n;
    private int current = 1;
    private int state = 0; // 0: zero, 1: odd, 2: even

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                wait();
            }
            printNumber.accept(0);
            if (current % 2 == 1) {
                state = 1; // odd
            } else {
                state = 2; // even
            }
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (state != 2) {
                wait();
                if (current > n) return;
            }
            printNumber.accept(current);
            current++;
            state = 0;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (state != 1) {
                wait();
                if (current > n) return;
            }
            printNumber.accept(current);
            current++;
            state = 0;
            notifyAll();
        }
    }
}
