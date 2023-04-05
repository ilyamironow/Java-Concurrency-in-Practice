import java.util.ArrayList;
import java.util.List;

class Event {}

interface EventListener {
    void onEvent(Event e);
}

public class EventSource {
    private final List<EventListener> listeners = new ArrayList<>();

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void fireEvent(Event e) {
        for (EventListener listener : listeners) {
            listener.onEvent(e);
        }
    }
}