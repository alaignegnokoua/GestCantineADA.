package ci.atosdigitalacademY.Cantine.services.dto.impl;

import ci.atosdigitalacademY.Cantine.models.Menu;
import ci.atosdigitalacademY.Cantine.repositories.MenuRepository;
import ci.atosdigitalacademY.Cantine.services.dto.MenuDTO;
import ci.atosdigitalacademY.Cantine.services.dto.MenuService;
import ci.atosdigitalacademY.Cantine.services.dto.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.awt.SystemColor.menu;

@RequiredArgsConstructor
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {



    private final MenuRepository menuRepository;

    private final MenuMapper menuMapper;

    @Override
    public MenuDTO save(MenuDTO menuDTO) {
        log.debug("Request to save Menu : {}", menuDTO);
        Menu menu = menuMapper.toEntity(menuDTO);
        menu = menuRepository.save(menu);
        return menuMapper.toDto(menu);

    }

    @Override
    public MenuDTO update(MenuDTO menuDTO) {
        log.debug("Request to update Menu : {}", menuDTO);
        return findOne(menuDTO.getId()).map(existingMenu ->{
            existingMenu.setCreationDate(menuDTO.getCreationDate());
            return save(existingMenu);
        }).orElseThrow(() -> new IllegalArgumentException());

    }

    @Override
    public Optional<MenuDTO> findOne(Long id) {
        log.debug("Request to find Menu : {}", id);
        return menuRepository.findById(id).map(menu ->{
            return menuMapper.toDto(menu);
        });

    }

    @Override
    public List<MenuDTO> findAll() {
        log.debug("Request to find all Menu");
        return menuRepository.findAll().stream().map(plat ->{
            return menuMapper.toDto(plat);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Menu : {}", id);
        menuRepository.deleteById(id);

    }
}
