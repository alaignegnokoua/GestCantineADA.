package ci.atosdigitalacademY.Cantine.services.dto.mapper;

import ci.atosdigitalacademY.Cantine.models.Plat;
import ci.atosdigitalacademY.Cantine.services.dto.PlatDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlatMapper extends EntityMapper<PlatDTO, Plat> {
}
