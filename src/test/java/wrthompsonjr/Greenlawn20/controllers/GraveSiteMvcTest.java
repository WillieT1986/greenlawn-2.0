package wrthompsonjr.Greenlawn20.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import javax.annotation.Resource;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GraveSiteRestController.class)
public class GraveSiteMvcTest {

    @Resource
    MockMvc mvc;

    @MockBean
    private GraveSiteRepository graveSiteRepo;

    @MockBean
    private CemeterySectionRepository cemeterySectionRepo;

    @MockBean
    private CemeteryTagRepository cemeteryTagRepo;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ShouldRetrieveGraveSites() throws Exception {
        mvc.perform(get("/gravesites")).andExpect(status().isOk());
    }

    @Test
    public void shouldGetAnIndividualGraveSite() throws Exception {
        when(graveSiteRepo.getById(18L))
                .thenReturn(new GraveSite("", "", "", "Joe", "", "",
                        "", "", "", "", "", null, "", "", ""));
        mvc.perform(get("/gravesites/18")).andExpect(status().isOk());
    }

    @Test
    public void shouldNotFindGraveSiteId() throws Exception {
        mvc.perform(get("/gravesites/35")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldGetAnIndividualCemeterySection() throws Exception {
        when(cemeterySectionRepo.getById(23L)).thenReturn(new CemeterySection("23B"));
        mvc.perform(get("/cemeterySection/23")).andExpect(status().isOk());
    }

    @Test
    public void shouldNotFindCemeterySectionId() throws Exception {
        mvc.perform(get("/cemeterySection/560")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldGetAnIndividualCemeteryTag() throws Exception {
        when(cemeteryTagRepo.getById(46L)).thenReturn(new CemeteryTag("Military"));
        mvc.perform(get("/cemeteryTag/46")).andExpect(status().isOk());
    }

    @Test
    public void shouldNotFindCemeteryTag() throws Exception {
        mvc.perform(get("/cemetery-tag/36")).andExpect(status().isNotFound());
    }

}
