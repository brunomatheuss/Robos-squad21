package squad21.banese.Robo;

@Controller
public class IndexController {

	@PostMapping("/registro/1")
	public Robo registrarRobo() {
		return registrarRobo();
	}

	@GetMapping("/consulta/1")
	public Robo consultarStatus() {
		return consultarStatus();
	}

	@PostMapping("/agendamento/1")
	public Robo agendarRobo() {
		return agendarRobo();
	}
