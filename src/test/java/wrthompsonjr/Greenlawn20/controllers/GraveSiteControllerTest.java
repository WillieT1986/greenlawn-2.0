package wrthompsonjr.Greenlawn20.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import wrthompsonjr.Greenlawn20.Data.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GraveSiteControllerTest {

    @InjectMocks
    GraveSiteController underTest;

    @Mock
    private GraveSiteRepository graveSiteRepo;

    @Mock
    private GraveSite graveSite1;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldAddAnIndividualGraveSiteToModel() throws Exception {
        long graveSiteId = 1L;
        when(graveSiteRepo.getById(graveSiteId)).thenReturn(graveSite1);
        underTest.findOneGraveSite(graveSiteId, model);
        verify(model).addAttribute("GraveSite", graveSite1);
    }

    @Test
    public void shouldReturnAnIndividualGraveSite() throws Exception {
        String template = underTest.findOneGraveSite(1L, model);
        assertThat(template, is("GraveSite"));
    }

}
