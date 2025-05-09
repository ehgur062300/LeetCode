class FooBar {
    private int n;
    private boolean check = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while(!check) {
                    this.wait();
                }
        	    check = false;

        	    printFoo.run();
                this.notifyAll();       
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while(check) {
                    this.wait();
                }
                check = true;

        	    printBar.run();
                this.notifyAll();       
            }
        }
    }
}