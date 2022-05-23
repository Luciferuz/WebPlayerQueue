package com.antsiferov.webplayerqueue.controllers;

import com.antsiferov.webplayerqueue.entity.Queue;
import com.antsiferov.webplayerqueue.services.QueueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PlayerController {

    private QueueService queueService;

    @GetMapping("/player")
    public String player(Model model) {
        List<Queue> queue = queueService.getCurrentQueue();
        model.addAttribute("musicqueue", queue);
        String currentSongUrl;
        if (!queue.isEmpty()) {
            currentSongUrl = queue.get(0).getUrl();
        } else {
            currentSongUrl = "https://www.youtube.com/embed/oIdgpZijCpc?autoplay=1";
        }
        model.addAttribute("currentSongUrl", currentSongUrl);
        return "player";
    }

    @GetMapping("/skip/")
    public String skipSong() {
        queueService.skip();
        return "redirect:/player";
    }

}
