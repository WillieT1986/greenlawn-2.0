package wrthompsonjr.Greenlawn20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;

import javax.annotation.Resource;

@Controller
public class GraveSiteController {

    @Resource
    private GraveSiteRepository graveSiteRepo;

    @RequestMapping("GraveSite")
    public String findOneGraveSite(@RequestParam Long id, Model model) {
        model.addAttribute("GraveSite", graveSiteRepo.getById(id));
        return "GraveSite";
    }
}
