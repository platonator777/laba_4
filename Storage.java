import static java.util.Objects.requireNonNull;


public final class Storage<T> {

    private final T item;

    public Storage(T item, T alternative) {
        this.item = null != item
                ? item
                : requireNonNull(alternative, "alternative must be not null");
    }

    public T get() {
        return this.item;
    }
}

