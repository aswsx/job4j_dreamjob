package ru.job4j.dreamjob.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.service.CandidateService;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 21:41
 */
@ThreadSafe
@Controller
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates";
    }

    @GetMapping("/formAddCandidate")
    public String formAddCandidate(Model model) {
        return "addCandidate";
    }

    @GetMapping("/formUpdateCandidate/{candidateId}")
    public String formUpdateCandidate(Model model, @PathVariable("candidateId") int id) {
        model.addAttribute("candidate", candidateService.findById(id));
        return "updateCandidate";
    }

    @GetMapping("/addCandidate")
    public String addCandidate(Model model) {
        model.addAttribute("candidate", new Candidate(0, "Заполните поле"));
        return "addCandidate";
    }

    @PostMapping("/updateCandidate")
    public String updateCandidate(@ModelAttribute Candidate candidate) {
        candidateService.update(candidate);
        return "redirect:/candidates";
    }

    @PostMapping("/createCandidate")
    public String createCandidate(@ModelAttribute Candidate candidate) {
        candidateService.create(candidate);
        return "redirect:/candidates";
    }

    @PostMapping("/saveCandidate")
    public String saveCandidate(@ModelAttribute Candidate candidate) {
        candidateService.add(candidate);
        return "redirect:/candidates";
    }
}
