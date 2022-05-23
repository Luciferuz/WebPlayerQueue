package com.antsiferov.webplayerqueue.controllers;

import com.antsiferov.webplayerqueue.entity.Queue;
import com.antsiferov.webplayerqueue.entity.User;
import com.antsiferov.webplayerqueue.services.QueueService;
import com.antsiferov.webplayerqueue.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AddSongController {

    private QueueService queueService;

    private UserService userService;

    @GetMapping("/add")
    public String addSong() {
        return "addSong";
    }

    @RequestMapping("/add")
    public String backToPlayer(Authentication authentication, @RequestParam String url, @RequestParam String description) {
        User user = userService.findUserByName(authentication.getName());
        queueService.put(new Queue(user, url, description));
        return "redirect:/player";
    }

}
