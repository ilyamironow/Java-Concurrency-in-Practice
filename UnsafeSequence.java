import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public synchronized int getNext() {
        return value++;
    }
}
