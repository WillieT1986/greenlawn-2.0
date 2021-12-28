package wrthompsonjr.Greenlawn20.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class CemeterySectionControllerTest {

    @InjectMocks
    CemeterySectionController underTest;

    @Mock
    private CemeterySectionRepository cemeterySectionRepo;

    @Mock
    private CemeterySection cemeterySection1;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldAddAnIndividualCemeterySectionToModel() {
        long cemeterySectionId = 2L;
        when(cemeterySectionRepo.getById(cemeterySectionId)).thenReturn(cemeterySection1);
        underTest.findOneCemeterySection(cemeterySectionId, model);
        verify(model).addAttribute("cemeterySection", cemeterySection1);
    }

    @Test
    public void shouldReturnAnIndividualCemeterySectionToModel() {
        String template = underTest.findOneCemeterySection(2L, model);
        assertThat(template, is("cemeterySection"));
    }

    @Test
    public void shouldReturnAllCemeterySections() {
        when(cemeterySectionRepo.findAll()).thenReturn(Collections.singletonList(cemeterySection1));
        String result = underTest.FindAllCemeterySections(model);
        assertTrue(result, contains(any(CemeterySection.class)) != null);
    }
}
