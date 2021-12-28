package wrthompsonjr.Greenlawn20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;

import javax.annotation.Resource;

@Controller
public class CemeteryTagController {

    @Resource
    private CemeteryTagRepository cemeteryTagRepo;

    @RequestMapping(value = "cemeteryTag")
    public String findOneCemeteryTag(@RequestParam Long id, Model model) {
        model.addAttribute("cemeteryTag", cemeteryTagRepo.getById(id));
        return "cemeteryTag";
    }

    @RequestMapping(value = "cemeteryTags")
    public String FindAllCemeterySections(Model model) {
        model.addAttribute("cemeteryTags", cemeteryTagRepo.findAll());
        return "cemeteryTags";
    }

}
