package wrthompsonjr.Greenlawn20.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import wrthompsonjr.Greenlawn20.controllers.GraveSiteRestController.CannotFindException;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class GraveSiteRestControllerTest {

    @InjectMocks
    private GraveSiteRestController underTest;

    @Mock
    private GraveSite graveSite;

    @Mock
    private CemeterySection cemeterySection;

    @Mock
    private CemeteryTag cemeteryTag;

    @Mock
    private GraveSiteRepository graveSiteRepo;

    @Mock
    private CemeterySectionRepository cemeterySectionRepo;

    @Mock
    private CemeteryTagRepository cemeteryTagRepo;

//    @Mock
//    private Collection<GraveSite> graveSites;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldRetrieveAnyGraveSite() throws Exception {
        when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
        String result = underTest.findGraveSites(model);
        assertTrue(result, contains(any(GraveSite.class)) != null);
    }

    @Test
    public void shouldFindAllGraveSitesFromDatabase() throws Exception {
        when(graveSiteRepo.findAll()).thenReturn(Collections.singletonList(graveSite));
        String result = underTest.findGraveSites(model);
        assertTrue(result, contains(graveSite) != null);
    }

    @Test
    public void shouldGetOneGraveSiteFromDatabase() {
        when(graveSiteRepo.getById(150000L)).thenReturn(graveSite);
        GraveSite result = underTest.findGraveSite(150000L);
        assertThat(result, is(graveSite));
    }

    @Test
    public void shouldReturnCannotFindExceptionForGraveSiteId() throws Exception {
        CannotFindException thrown = assertThrows(
                CannotFindException.class,
                () -> {
                    long invalidGraveSiteId = 54L;
                    underTest.findGraveSite(invalidGraveSiteId);
                });
        assertEquals("Gravesite Does Not Exist.", thrown.getMessage());
    }

    @Test
    public void shouldReturnAListOfCemeterySections() {
        when(cemeterySectionRepo.findAll()).thenReturn(Collections.singletonList(cemeterySection));
        String result = underTest.findCemeterySections(model);
        assertTrue(result, contains(any(CemeterySection.class)) != null);
    }

    @Test
    public void shouldGetOneCemeterySectionFromDatabase() {
        when(cemeterySectionRepo.getById(88L)).thenReturn(cemeterySection);
        CemeterySection result = underTest.findCemeterySection(88L);
        assertThat(result, is(cemeterySection));
    }

    @Test
    public void shouldReturnAListOfCemeteryTags() {
        when(cemeteryTagRepo.findAll()).thenReturn(Collections.singletonList(cemeteryTag));
        Iterable<CemeteryTag> result = underTest.findCemeteryTags(model);
        assertThat(result, contains(any(CemeteryTag.class)));
    }

    @Test
    public void shouldGetACemeteryTagFromDatabase() {
        when(cemeteryTagRepo.getById(183L)).thenReturn(cemeteryTag);
        CemeteryTag result = underTest.findCemeteryTag(183L);
        assertThat(result, is(cemeteryTag));
    }

}
