package se.systementor.backend2start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.systementor.backend2start.model.Dog;
import se.systementor.backend2start.model.DogRepository;

import java.util.List;

@Controller
public class PublicController extends BaseController {
    @Autowired
    DogRepository dogRepository;

    @GetMapping(path="/")
    String empty(Model model,  @RequestParam(defaultValue = "1") int pageNo,
                 @RequestParam(defaultValue = "10") int pageSize,
                 @RequestParam(defaultValue = "name") String sortCol,
                 @RequestParam(defaultValue = "ASC") String sortOrder,
                 @RequestParam(defaultValue = "") String q)
    {
        model.addAttribute("activeFunction", "home");
        setupVersion(model);

        q = q.trim();

        model.addAttribute("q", q);

        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortCol);
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        if(!q.isEmpty()){
            Page<Dog> page = dogRepository.findAllByNameContainsOrBreedContains(q,q,pageable);
            model.addAttribute("dogs", page);
            model.addAttribute("totalPages",  page.getTotalPages());
            model.addAttribute("pageNo",  pageNo);
        }else {
            Page<Dog> page = dogRepository.findAll(pageable);
            model.addAttribute("pageNo", pageNo);
            model.addAttribute("totalPages",  page.getTotalPages());
            model.addAttribute("dogs", page);
        }
        return "home";
    }

}
