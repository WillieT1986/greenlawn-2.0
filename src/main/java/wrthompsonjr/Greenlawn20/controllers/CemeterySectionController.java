package wrthompsonjr.Greenlawn20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrthompsonjr.Greenlawn20.Data.CemeterySectionRepository;

import javax.annotation.Resource;

@Controller
public class CemeterySectionController {

    @Resource
    private CemeterySectionRepository  cemeterySectionRepo;

    @RequestMapping(value = "CemeterySection")
    public String findOneCemeterySection(@RequestParam Long id, Model model) {
        model.addAttribute("CemeterySection", cemeterySectionRepo.getById(id));
        return "CemeterySection";
    }
}
