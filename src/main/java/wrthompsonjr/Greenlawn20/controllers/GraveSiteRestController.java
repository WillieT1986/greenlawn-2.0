package wrthompsonjr.Greenlawn20.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import javax.annotation.Resource;

@RestController
public class GraveSiteRestController {

    @SuppressWarnings("unused")
    private Logger log = LoggerFactory.getLogger(GraveSiteRestController.class);

    @Resource
    private GraveSiteRepository graveSiteRepo;

    @Resource
    private CemeterySectionRepository cemeterySectionRepo;

    public String findGraveSites(Model model) {
        model.addAttribute("graveSites", graveSiteRepo.findAll());
        return "graveSites";
    }

    @RequestMapping("/gravesite/{id}")
    public GraveSite findGraveSite(@PathVariable(name = "id") long id) {
        if (graveSiteRepo.getById(id) == null) {
            throw new CannotFindException("Gravesite Does Not Exist.");
        }
        return graveSiteRepo.getById(id);
    }

    public String findCemeterySections(Model model) {
        model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
        return "cemeterySections";
    }

    @RequestMapping("/cemeterySections/{id}")
    public CemeterySection findCemeterySection(@PathVariable(name = "id") Long id) {
        if (cemeterySectionRepo.getById(id) == null) {
            throw new CannotFindException("Invalid Query. Unable to Find Cemetery Section.");
        }
        return cemeterySectionRepo.getById(id);
    }

    @SuppressWarnings("serial")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class CannotFindException extends RuntimeException {
        private String message;

        public String getMessage() {
            return message;
        }

        CannotFindException(String errorMessage) {
            this.message = errorMessage;
        }
    }
}
