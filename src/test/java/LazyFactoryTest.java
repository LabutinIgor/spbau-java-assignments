import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.function.Supplier;

public class LazyFactoryTest {
    @Test
    public void testCreateLazyOneThread_ReturnConstString() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "abacaba";
            }
        };
        Lazy<String> lazy = LazyFactory.createLazyOneThread(supplier);
        String result = lazy.get();
        assertEquals(result, "abacaba");
        assertTrue(result == lazy.get());
    }

    @Test
    public void testCreateLazyOneThread_returnNull() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Lazy<String> lazy = LazyFactory.createLazyOneThread(supplier);
        String result = lazy.get();
        assertTrue(result == null);
        assertTrue(lazy.get() == null);
    }


}
