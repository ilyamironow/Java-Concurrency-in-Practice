public class Main {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        // Start a new thread to fire an event concurrently
        new Thread(() -> {
            try {
                // Sleep for a short duration (100 ms) to allow the ThisEscape constructor to start
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eventSource.fireEvent(new Event());
        }).start();

        // Create a new ThisEscape instance and register the EventListener
        ThisEscape thisEscape = new ThisEscape(eventSource);

        // Check that value is 42 now
        eventSource.fireEvent(new Event());
    }
}