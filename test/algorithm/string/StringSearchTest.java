package algorithm.string;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringSearchTest {

    private StringAlgorithm stringAlgorithm = new BoyerMoore();

    @Test
    public void stringSearchTest() {

        String str = "Beauty of Design Pattern";

        assertEquals(0, stringAlgorithm.searchString(str, "Beauty"));
        assertEquals(7, stringAlgorithm.searchString(str, "of"));
        assertEquals(10, stringAlgorithm.searchString(str, "Design"));
        assertEquals(17, stringAlgorithm.searchString(str, "Pattern"));
    }
}
