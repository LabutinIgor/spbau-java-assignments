import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

public class LazyFactoryTest {
    @Test
    public void testCreateLazyOneThread() {
        Supplier<Integer> supplierReturn42 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 42;
            }
        };
        Lazy<Integer> lazyReturn42 = LazyFactory.createLazyOneThread(supplierReturn42);
        assertEquals(lazyReturn42.get(), Integer.valueOf(42));
    }
}
