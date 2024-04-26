package se.systementor.backend2start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import se.systementor.backend2start.model.DogRepository;

@Controller
public class PublicController extends BaseController {
    @Autowired
    DogRepository dogRepository;

    @GetMapping(path="/")
    String empty(Model model)
    {
        model.addAttribute("activeFunction", "home");
        setupVersion(model);

        model.addAttribute("dogs", dogRepository.findAll());
        return "home";
    }

}
