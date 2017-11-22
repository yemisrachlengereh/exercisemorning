package com.example.exercisemorning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

public class MainController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CloudinaryCongig cloudc;

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("gotmovies",movieRepository.count());
        model.addAttribute("gotactors",movieRepository.count());
        model.addAttribute("actorList",movieRepository.findAll());
        model.addAttribute("movieList",movieRepository.findAll());
        model.addAttribute("title","Movie Database");
        return "index";

        @GetMapping("/addmovie")
                public String addAttribute(Model model){
            Movie movie = new Movie();
            model.addAttribute("movie", movie);
            return "addmovies";
        }
        @PostMapping("/addmovie")
        public String saveMovie(@ModelAttribute("movie") Movie movie){
                   movieRepository.save(movie);
                   return "redirect:/";

        }
        @GetMapping("/addactor")
        public String addActor(Model model){
            model.addAttribute("actor", new Actor());
            return "addactor";
        }
        @PostMapping("/addactor")
                public String saveActor(@ModelAttribute("actor")Actor actor,MultipartFileHttpServlet
        }
    }
}
