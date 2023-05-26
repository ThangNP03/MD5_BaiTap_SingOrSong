package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.entity.Song;
import ra.model.service.ISongService;
import ra.model.service.SongServiceIMPL;

import java.util.List;

@Controller
@RequestMapping("/")
public class SongController {
    ISongService songService = new SongServiceIMPL();
    @GetMapping("/")
    public String showListSong(Model model){
        List<Song> list =  songService.findAll();
        model.addAttribute("listSong",list);
        return "list";
    }
}
