package wrthompsonjr.Greenlawn20;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {

    @Resource
    private TestEntityManager entityManager;

    @Resource
    private GraveSiteRepository graveSiteRepo;

    @Resource
    private CemeterySectionRepository cemeterySectionRepo;

    @Resource
    private CemeteryTagRepository cemeteryTagRepo;

    private static final String TOMBSTONE_IMAGE = "Tombstone Image";
    private static final String REGULAR_IMAGE = "Regular Image";
    private static final String NAME_OF_PERSON = "Jack";
    private static final String US_STATE = "Ohio";
    private static final String MILITARY_RANK = "Lance Corporal";
    private static final String MILITARY_BRANCH = "USMC";
    private static final String MILITARY_UNIT = "2/2 Warlords";
    private static final String DATE_OF_BIRTH = "01/01/1921";
    private static final String DATE_OF_DEATH = "01/01/2021";
    private static final String STATUS = "Veteran";
    private static final String OBITUARY = "A whole bunch of words. Not Really.";
    private static final CemeterySection CEMETERY_SECTION = null;
    private static final String RELIGION = "Jedi";
    private static final String MILITARY_MEDAL = "Git Gud";
    private static final String GPS_COORDINATES = "No, No";

    GraveSite graveSite;
    CemeteryTag veteran;
    CemeteryTag electedOfficial;

    @BeforeEach
    public void setUp() {
        graveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION, MILITARY_MEDAL, GPS_COORDINATES);

        veteran = cemeteryTagRepo.save(new CemeteryTag("Veteran"));
        electedOfficial = cemeteryTagRepo.save(new CemeteryTag("Elected Official"));
    }

    @Test
    public void shouldSaveAndLoadAGraveSite() {
        graveSite = graveSiteRepo.save(graveSite);
        long graveSiteId = graveSite.getId();

        entityManager.flush();
        entityManager.clear();

        graveSite = graveSiteRepo.getById(graveSiteId);
        assertThat(graveSite.getName(), is(NAME_OF_PERSON));
    }

    @Test
    public void shouldSaveAGraveSiteToCemeterySectionRelationship() {
        CemeterySection section = new CemeterySection("10A");
        cemeterySectionRepo.save(section);
        long cemeterySectionId = section.getId();

        GraveSite firstGraveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, section, RELIGION, MILITARY_MEDAL, GPS_COORDINATES);
        firstGraveSite = graveSiteRepo.save(firstGraveSite);

        GraveSite secondGraveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, "William", US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, section, RELIGION, MILITARY_MEDAL, GPS_COORDINATES);
        secondGraveSite = graveSiteRepo.save(secondGraveSite);

        entityManager.flush();
        entityManager.clear();

        section = cemeterySectionRepo.getById(cemeterySectionId);
        assertThat(section.getGraveSites(), containsInAnyOrder(firstGraveSite, secondGraveSite));
    }

    @Test
    public void shouldSaveAndLoadACemeteryTag() {
        long cemeteryTagId = veteran.getId();

        entityManager.flush();
        entityManager.clear();

        veteran = cemeteryTagRepo.getById(cemeteryTagId);
        assertThat(veteran.getCemeteryTagName(), is("Veteran"));
    }

    @Test
    public void shouldEstablishAGraveSiteToCemeteryTagRelationship() {
        graveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION, MILITARY_MEDAL, GPS_COORDINATES, veteran, electedOfficial);

        graveSite = graveSiteRepo.save(graveSite);
        long graveSiteId = graveSite.getId();

        graveSite = graveSiteRepo.getById(graveSiteId);
        assertThat(graveSite.getCemeteryTags(), containsInAnyOrder(veteran, electedOfficial));
    }

    @Test
    public void shouldEstablishCemeteryTagToAGraveSiteRelationship() {
        long cemeteryTagId = veteran.getId();

        GraveSite firstGraveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION, MILITARY_MEDAL, GPS_COORDINATES, veteran);
        firstGraveSite = graveSiteRepo.save(firstGraveSite);

        GraveSite secondGraveSite = new GraveSite(TOMBSTONE_IMAGE, REGULAR_IMAGE, NAME_OF_PERSON, US_STATE, MILITARY_RANK, MILITARY_BRANCH,
                MILITARY_UNIT, DATE_OF_BIRTH, DATE_OF_DEATH, STATUS, OBITUARY, CEMETERY_SECTION, RELIGION, MILITARY_MEDAL, GPS_COORDINATES, veteran);
        secondGraveSite = graveSiteRepo.save(secondGraveSite);

        entityManager.flush();
        entityManager.clear();

        veteran = cemeteryTagRepo.getById(cemeteryTagId);
        assertThat(veteran.getGraveSites(), containsInAnyOrder(firstGraveSite, secondGraveSite));
    }

    @Test
    public void shouldReturnAListOfSpecificDetailsOfAGraveSite() {
        String check = graveSite.getName();
        String check2 = graveSite.getDateOfBirth();
        String check3 = graveSite.getDateOfDeath();
        String check4 = graveSite.getStatus();
        String check5 = graveSite.getObituary();

        assertEquals(check, NAME_OF_PERSON);
        assertEquals(check2, DATE_OF_BIRTH);
        assertEquals(check3, DATE_OF_DEATH);
        assertEquals(check4, STATUS);
        assertEquals(check5, OBITUARY);
    }
}
