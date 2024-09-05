package ci.atosdigitalacademY.Cantine.services.dto.mapper;

import ci.atosdigitalacademY.Cantine.models.Menu;
import ci.atosdigitalacademY.Cantine.services.dto.MenuDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {
}
