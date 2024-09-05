package ci.atosdigitalacademY.Cantine.controller;

import ci.atosdigitalacademY.Cantine.services.dto.PlatDTO;
import ci.atosdigitalacademY.Cantine.services.dto.PlatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/plats")
public class PlatController {

    private final PlatService platService;

        @GetMapping
        public String showPlatPage(Model model) {
            List<PlatDTO> plats = platService.findAll();
            model.addAttribute("plats", plats);
            return "plats/list";

        }
        @GetMapping("/add")
        public String showAddPlatForms(Model model) {
            log.debug("Request to show add plat forms");
            model.addAttribute("plat", new PlatDTO());
            return "plats/forms";
        }

        @PostMapping
        public String savePlat(PlatDTO plat){
            log.debug("Request to save pla :{}",plat);
            platService.save(plat);
            return "redirect:/plats";
        }

        @GetMapping("/{id}")
        public String showUpdatePlatForms(Model model, @PathVariable long id) {
            Optional<PlatDTO> plat = platService.findOne(id);

            if(plat.isPresent()){
                model.addAttribute("plat", plat.get());
                return "plats/forms";
            }else {
                return "redirect:/plats";
            }
        }

        @PostMapping("/delete/{id}")
        public String deletePlat(@PathVariable long id) {
            log.debug("Request to delete plat : {}", id);
            platService.delete(id);
            return "redirect:/plats";
        }

        @GetMapping("/search")
        public String searchPlats(@RequestParam String query, @RequestParam String name, Model model) {
            log.debug("Request to search plats : {}", name);
            List<PlatDTO> plats=platService.findAll();
            model.addAttribute("plats", plats);
            model.addAttribute("query", query );
            model.addAttribute("name", name );
            return "plats/list";
        }


}
