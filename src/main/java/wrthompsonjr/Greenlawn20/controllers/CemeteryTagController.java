package wrthompsonjr.Greenlawn20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrthompsonjr.Greenlawn20.Data.CemeteryTagRepository;

import javax.annotation.Resource;

@Controller
public class CemeteryTagController {

    @Resource
    private CemeteryTagRepository cemeteryTagRepo;

    @RequestMapping(value = "CemeteryTag")
    public String findOneCemeteryTag(@RequestParam Long id, Model model) {
        model.addAttribute("CemeteryTag", cemeteryTagRepo.getById(id));
        return "CemeteryTag";
    }
}
