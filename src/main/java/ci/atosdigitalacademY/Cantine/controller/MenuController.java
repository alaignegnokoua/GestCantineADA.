package ci.atosdigitalacademY.Cantine.controller;


import ci.atosdigitalacademY.Cantine.services.dto.MenuDTO;
import ci.atosdigitalacademY.Cantine.services.dto.MenuService;
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
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public String showMenuPage(Model model) {
        List<MenuDTO> menus = menuService.findAll();
        model.addAttribute("menus", menus);
        return "menus/list";

    }

    @GetMapping("/add")
    private String showAddMenuForms(Model model) {
        log.info("Request to show add menus Forms");
        model.addAttribute("menus", new MenuDTO());
        return "menus/fors";
    }
    @PostMapping
    public String saveMenu(MenuDTO menu){
        log.info("Request to save menu {}", menu);
        menuService.save(menu);
        return "redirect:/menus";

    }

    @GetMapping("/{id}")
    public String showUpdateMenuForms(Model model, @PathVariable Long id) {
        Optional<MenuDTO> menu =menuService.findOne(id);

        if(menu.isPresent()){
            model.addAttribute("menus", menu.get());
            return "menus/forms";
        }else {
            return "redirect:/menus";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        log.info("Request to delete menu {}", id);
        menuService.delete(id);
        return "redirect:/menus";
    }

    @GetMapping("/search")
    public String searchMenus(@RequestParam String query, @RequestParam String name, Model model) {
        log.debug("Request to search menus  {}", name);
        List<MenuDTO> menu=menuService.findAll();
        model.addAttribute("menus", menu);
        model.addAttribute("query", query);
        model.addAttribute("name", name);
        return "menus/list";

    }

}
