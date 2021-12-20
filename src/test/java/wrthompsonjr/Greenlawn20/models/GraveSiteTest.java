package wrthompsonjr.Greenlawn20.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraveSiteTest {

    private static final String Name_OF_PERSON = "Jack";
    private static final String DATE_OF_BIRTH = "01/01/1921";
    private static final String Date_OF_DEATH = "01/01/2021";
    private static final String STATUS = "Veteran";
    private static final String OBITUARY = "A whole bunch of words. Not Really.";

    GraveSite underTest;

    @BeforeEach
    public void setUp() {
        underTest = new GraveSite(Name_OF_PERSON, DATE_OF_BIRTH, Date_OF_DEATH, STATUS, OBITUARY);
    }

    @Test
    public void shouldInstantiateAGraveSiteClass() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructAndReturnAName() {
        String check = underTest.getName();
        assertEquals(Name_OF_PERSON, check);
    }

    @Test
    public void shouldReturnTheDateOfBirth() {
        String check = underTest.getDateOfBirth();
        assertEquals(DATE_OF_BIRTH, check);
    }

    @Test
    public void shouldReturnTheDateOfDeath() {
        String check = underTest.getDateOfDeath();
        assertEquals(Date_OF_DEATH, check);
    }

    @Test
    public void shouldReturnAStatus() {
        String check = underTest.getStatus();
        assertEquals(STATUS, check);
    }

    @Test
    public void shouldReturnAnObituary() {
        String check = underTest.getObituary();
        assertEquals(OBITUARY, check);
    }

}
