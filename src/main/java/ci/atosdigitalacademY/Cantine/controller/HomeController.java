package ci.atosdigitalacademY.Cantine.controller;


import ci.atosdigitalacademY.Cantine.services.dto.MenuDTO;
import ci.atosdigitalacademY.Cantine.services.dto.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final MenuService menuService;

    @GetMapping
    public String index(Model model) {

        List<MenuDTO> menus = menuService.findAll();
        if (menus.isEmpty()) {
            return "home/dashboard";
        } else {
            Optional<MenuDTO> menuDTO = menus.stream().findFirst();
            model.addAttribute("menu", menuDTO.get());
            return "home/dashboard";
        }

    }
}
