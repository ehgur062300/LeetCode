class ZeroEvenOdd {
    private int n;
    private int cnt = 1;
    private boolean isZero = false;
    private boolean isEven = true;
    private boolean isOdd = true;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0; i<n; i++) {
            while(isZero){
                wait();
            }
            printNumber.accept(0);
            isZero = true;
            if (cnt % 2 == 0) {
                isEven = false;
            } else {
                isOdd = false;
            }
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(cnt <= n){
            while(isEven){
                wait();
                if(cnt > n) { return; }
            }
            printNumber.accept(cnt);
            cnt++;
            isEven = true;
            isZero = false;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(cnt <= n) {
            while(isOdd){
                wait();
                if(cnt > n) { return; }
            }
            printNumber.accept(cnt);
            cnt++;
            isOdd = true;
            isZero = false;
            notifyAll();
        }
    }
}