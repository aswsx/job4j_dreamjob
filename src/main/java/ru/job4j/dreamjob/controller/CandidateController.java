package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dreamjob.store.CandidatesStore;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 21:41
 */
@Controller
public class CandidateController {
    private final CandidatesStore store = CandidatesStore.instOf();

    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("candidates", store.findAll());
        return "candidates";
    }
}
