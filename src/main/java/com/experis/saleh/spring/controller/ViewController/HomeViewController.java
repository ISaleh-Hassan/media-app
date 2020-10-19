package com.experis.saleh.spring.controller.ViewController;

import com.experis.saleh.spring.data_access.TrackRepository;
import com.experis.saleh.spring.models.daoModels.TrackDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeViewController {

    TrackRepository trackRepository = new TrackRepository();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("track", new TrackDao());
        model.addAttribute("genres", trackRepository.getFiveRandom("Genre"));
        model.addAttribute("artists", trackRepository.getFiveRandom("Artist"));
        model.addAttribute("tracks", trackRepository.getFiveRandom("Track"));
        return "home";
    }

    @GetMapping("/search")
    public String findTrack(@RequestParam( value="trackName", required = false)String trackName, Model model){
        if(trackName == null || trackName == ""){
            return "redirect:/";
        }
        model.addAttribute("track", trackRepository.getTrackByName(trackName));
        return "searchPage";
    }
}
