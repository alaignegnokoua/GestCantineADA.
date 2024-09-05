package ci.atosdigitalacademY.Cantine.services.dto.impl;

import ci.atosdigitalacademY.Cantine.models.Plat;
import ci.atosdigitalacademY.Cantine.repositories.PlatRepository;
import ci.atosdigitalacademY.Cantine.services.dto.PlatDTO;
import ci.atosdigitalacademY.Cantine.services.dto.PlatService;
import ci.atosdigitalacademY.Cantine.services.dto.mapper.PlatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.awt.SystemColor.menu;


@RequiredArgsConstructor
@Service
@Slf4j
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;

    private final PlatMapper platMapper;

    @Override
    public PlatDTO save(PlatDTO platDTO) {
        log.debug("Request to save Plat : {}", platDTO);
        Plat plat = platMapper.toEntity(platDTO);
        plat = platRepository.save(plat);
        return platMapper.toDto(plat);

    }

    @Override
    public PlatDTO update(PlatDTO platDTO) {
        log.debug("Request to update Plat : {}", platDTO);
        return findOne(platDTO.getId()).map(existingPlat ->{
            existingPlat.setName(platDTO.getName());
            existingPlat.setSummary(platDTO.getSummary());
            return save(existingPlat);
        }).orElseThrow(() -> new IllegalArgumentException());

    }

    @Override
    public Optional<PlatDTO> findOne(Long id) {
        log.debug("Request to find Plat : {}", id);
        return platRepository.findById(id).map(plat -> {
            return platMapper.toDto(plat);
        });

    }

    @Override
    public List<PlatDTO> findAll() {
        log.debug("Request to find all Plats");
        return platRepository.findAll().stream().map(plat -> {
            return platMapper.toDto(plat);
        }).toList();

    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Menu : {}", id);
        platRepository.deleteById(id);

    }
}
