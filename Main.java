public class Main {
    public static void main(String[] args) throws InterruptedException {
        UnsafeSequence unsafeSequence = new UnsafeSequence();
        Runnable runnable = () -> System.out.println(unsafeSequence.getNext());

        final int numberOfThreads = 200;
        Thread[] threads = new Thread[numberOfThreads];
        initializeThreads(runnable, threads);

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].start();
        }

        waitForAllThreadsToFinish(threads);
    }

    private static void initializeThreads(Runnable runnable, Thread[] threads) {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
        }
    }

    private static void waitForAllThreadsToFinish(Thread[] threads) throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }
}