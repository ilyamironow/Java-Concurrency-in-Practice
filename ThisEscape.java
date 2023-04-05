public class ThisEscape {
    private final int value;

    public ThisEscape(EventSource source) {
        source.registerListener(
            new EventListener() {
                public void onEvent(Event e) {
                    doSomething(e);
                }
            }
        );

        // Sleep for a short duration (200 ms) before initializing the value field
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        value = 42;
    }

    public void doSomething(Event e) {
        System.out.println("Value: " + value);
    }
}