package ci.atosdigitalacademY.Cantine;

import ci.atosdigitalacademY.Cantine.services.dto.MenuDTO;
import ci.atosdigitalacademY.Cantine.services.dto.MenuService;
import ci.atosdigitalacademY.Cantine.services.dto.PlatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
@RequiredArgsConstructor
public class CantineApplication implements CommandLineRunner {

	private final MenuService menuService;

	private final PlatService platService;

	public static void main(String[] args) {
		SpringApplication.run(CantineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setCreationDate(Instant.now());
		menuService.save(menuDTO);

	}
}
