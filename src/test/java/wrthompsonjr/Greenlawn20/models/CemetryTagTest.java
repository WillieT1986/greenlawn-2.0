package wrthompsonjr.Greenlawn20.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CemetryTagTest {

    @Test
    public void shouldInstantiateCemeteryTagClass() {
        CemeteryTag underTest = new CemeteryTag("Jill");
        assertNotNull(underTest);
    }

    @Test
    public void shouldReturnACemeteryTagName() {
        CemeteryTag underTest = new CemeteryTag("Jill");
        String check = underTest.getCemeteryTagName();
        assertEquals("Jill", check);
    }

}
