import java.util.function.Supplier;

public class LazyFactory {
    public static<T> Lazy<T> createLazyOneThread(final Supplier<T> supplier) {
        return new Lazy<T>() {
            private T result;
            private boolean calculated = false;
            public T get() {
                if (!calculated) {
                    result = supplier.get();
                    calculated = true;
                }
                return result;
            }
        };
    }
}
