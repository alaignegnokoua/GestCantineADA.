package ci.atosdigitalacademY.Cantine.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MenuDTO {

    private Long id;
    private Instant creationDate;
}
