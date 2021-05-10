package kursovaya.kr17.controllers;

import kursovaya.kr17.models.Ticket;
import kursovaya.kr17.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BoardController {

    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/towns")
    public String showTowns(Model model) {
        Iterable<Ticket> tickets = ticketRepo.findAll();
        model.addAttribute("tickets", tickets);
        model.addAttribute("title", "towns");
        return "town-list";
    }

    @GetMapping("/towns/{id}")
    public String showDetails(@PathVariable(value = "id") long id,  Model model) {
        if(!ticketRepo.existsById(id)){
            return "redirect:/towns";
        }

        Optional<Ticket> ticket = ticketRepo.findById(id);
        ArrayList<Ticket> res = new ArrayList<>();
        ticket.ifPresent(res::add);
        model.addAttribute("title", "details");
        model.addAttribute("ticket", res);
        return "flight-det";
    }

    @PostMapping("/towns/add")
    public String addNewFlight(@RequestParam String townA, @RequestParam String townB, @RequestParam Integer cost, @RequestParam String image, Model model) {
        Ticket ticket = new Ticket(townA, townB, cost, image);
        ticketRepo.save(ticket);
        return "redirect:/towns";
    }

    @GetMapping("/towns/add")
    public String addFlight(Model model) {
        model.addAttribute("title", "add");
        return "add-flight";
    }

    @GetMapping("/towns/{id}/edit")
    public String flightEdit(@PathVariable(value = "id") long id,  Model model) {
        if(!ticketRepo.existsById(id)){
            return "redirect:/towns";
        }
        model.addAttribute("title", "editing");

        Optional<Ticket> ticket = ticketRepo.findById(id);
        ArrayList<Ticket> res = new ArrayList<>();
        ticket.ifPresent(res::add);
        model.addAttribute("ticket", res);
        return "flight-edit";
    }

    @PostMapping("/towns/{id}/edit")
    public String flightEdited(@PathVariable(value = "id") long id,@RequestParam String townA, @RequestParam String townB, @RequestParam Integer cost, @RequestParam String image, Model model) {
        model.addAttribute("title", "edited");
        Ticket ticket = ticketRepo.findById(id).orElseThrow();
        ticket.setImage(image);
        ticket.setCost(cost);
        ticket.setTownA(townA);
        ticket.setTownB(townB);

        ticketRepo.save(ticket);

        return "redirect:/towns";
    }

}
