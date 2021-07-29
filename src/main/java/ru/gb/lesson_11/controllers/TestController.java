package ru.gb.lesson_11.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.lesson_11.models.User;
import ru.gb.lesson_11.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "Main page";
    }

    @GetMapping("/articles")
    public String getArticles() {
        return "Articles.........";
    }

    @GetMapping("/article/change/{id}")
    public String changeArticle(@PathVariable("id") Long id) {
        return "Change article " + id;
    }

    @GetMapping("/admin")
    // @PreAuthorize("hasRole('ADMIN')")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findUserByName(principal.getName()).orElseThrow(() -> new RuntimeException("Unable to find user by username: " + principal.getName()));
        return "Authenticated user info: " + user.getName() + " : " + user.getEmail();
    }
}
