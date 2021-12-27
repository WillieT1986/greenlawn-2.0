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

    @RequestMapping(value = "cemetery-section")
    public String findOneCemeterySection(@RequestParam Long id, Model model) {
        model.addAttribute("cemetery-section", cemeterySectionRepo.getById(id));
        return "cemetery-section";
    }

    @RequestMapping(value = "cemetery-sections")
    public String FindAllCemeterySections(Model model) {
        model.addAttribute("cemetery-sections", cemeterySectionRepo.findAll());
        return "cemetery-sections";
    }
}
