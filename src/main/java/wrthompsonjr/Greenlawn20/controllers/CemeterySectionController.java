package wrthompsonjr.Greenlawn20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;

import javax.annotation.Resource;

@Controller
public class CemeterySectionController {

    @Resource
    private CemeterySectionRepository  cemeterySectionRepo;

    @RequestMapping(value = "cemeterySection")
    public String findOneCemeterySection(@RequestParam Long id, Model model) {
        model.addAttribute("cemeterySection", cemeterySectionRepo.getById(id));
        return "cemeterySection";
    }

    @RequestMapping(value = "cemeterySections")
    public String FindAllCemeterySections(Model model) {
        model.addAttribute("cemeterySections", cemeterySectionRepo.findAll());
        return "cemeterySections";
    }
}
