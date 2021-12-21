package wrthompsonjr.Greenlawn20.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraveSiteTest {

    private static final String TOMBSTONE_IMAGE = "Tombstone Image";
    private static final String NAME_OF_PERSON = "Jack";
    private static final String US_STATE = "Ohio";
    private static final String MILITARY_RANK = "Lance Corporal";
    private static final String MILITARY_BRANCH = "USMC";
    private static final String MILITARY_UNIT = "2/2 Warlords";
    private static final String DATE_OF_BIRTH = "01/01/1921";
    private static final String Date_OF_DEATH = "01/01/2021";
    private static final String STATUS = "Veteran";
    private static final String OBITUARY = "A whole bunch of words. Not Really.";
    private static final CemeterySection CEMETERY_SECTION = null;
    private static final String RELIGION = "Jedi";

    GraveSite underTest;

    @BeforeEach
    public void setUp() {
        underTest = new GraveSite(TOMBSTONE_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH, MILITARY_UNIT, DATE_OF_BIRTH, Date_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION);
    }

    @Test
    public void shouldInstantiateAGraveSiteClass() {
        assertNotNull(underTest);
    }

    @Test
    public void shouldConstructAndReturnAName() {
        String check = underTest.getName();
        assertEquals(NAME_OF_PERSON, check);
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

    @Test
    public void shouldReturnReligion() {
        String check = underTest.getReligion();
        assertEquals(RELIGION, check);
    }

    @Test
    public void shouldReturnAnImage() {
        String check = underTest.getImageOfTombStone();
        assertEquals(TOMBSTONE_IMAGE, check);
    }

    @Test
    public void shouldReturnAState() {
        String check = underTest.getState();
        assertEquals(US_STATE, check);
    }

    @Test
    public void shouldReturnMilitaryRankBranchAndUnit() {
        String check1 = underTest.getMilitaryRank();
        String check2 = underTest.getMilitaryBranch();
        String check3 = underTest.getMilitaryUnit();
        assertEquals(MILITARY_RANK, check1);
        assertEquals(MILITARY_BRANCH, check2);
        assertEquals(MILITARY_UNIT, check3);
    }

}
