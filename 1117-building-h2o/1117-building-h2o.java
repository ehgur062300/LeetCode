class H2O {
    private Semaphore hydrogenSemaphore = new Semaphore(2); // 수소 2개까지 허용
    private Semaphore oxygenSemaphore = new Semaphore(0);   // 산소는 대기 상태

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();        // 수소 2개까지만 실행됨
        releaseHydrogen.run();              // 수소 출력
        oxygenSemaphore.release();          // 산소를 위한 신호 보냄
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire(2);         // 수소 2개 신호를 기다림
        releaseOxygen.run();                // 산소 출력
        hydrogenSemaphore.release(2);       // 다음 수소 2개를 위해 자원 돌려줌
    }
}
