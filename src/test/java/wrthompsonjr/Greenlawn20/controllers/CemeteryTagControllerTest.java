package wrthompsonjr.Greenlawn20.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CemeteryTagControllerTest {

    @InjectMocks
    CemeteryTagController underTest;

    @Mock
    private CemeteryTagRepository cemeteryTagRepo;

    @Mock
    private CemeteryTag cemeteryTag1;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldAddAnIndividualCemeteryTagToModel() {
        long cemeteryTagId = 3L;
        when(cemeteryTagRepo.getById(cemeteryTagId)).thenReturn(cemeteryTag1);
        underTest.findOneCemeteryTag(cemeteryTagId, model);
        verify(model).addAttribute("cemeteryTag", cemeteryTag1);
    }

    @Test
    public void shouldReturnAnIndividualCemeteryTagToModel() {
        String template = underTest.findOneCemeteryTag(3L, model);
        assertThat(template, is("cemeteryTag"));
    }

}
