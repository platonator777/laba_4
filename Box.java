public class Box<T> {
    private T item;

    public void put(T newItem) {
        if (item != null) {
            throw new IllegalStateException("Коробка уже содержит объект!");
        }
        item = newItem;
    }

    public T get() {
        if (item == null) {
            throw new IllegalStateException("Коробка пуста!");
        }
        T temp = item;
        item = null;
        return temp;
    }

    public boolean isEmpty() {
        return item == null;
    }
}
