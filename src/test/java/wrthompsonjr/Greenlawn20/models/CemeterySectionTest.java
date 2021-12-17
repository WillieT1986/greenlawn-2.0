package wrthompsonjr.Greenlawn20.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CemeterySectionTest {

    @Test
    public void shouldInstantiateCemeterySection() {
        CemeterySection underTest = new CemeterySection("11A");
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnACemeterySection() {
        CemeterySection underTest = new CemeterySection("11A");
        String check = underTest.getCemeterySection();
        assertEquals("11A", check);
    }

}
