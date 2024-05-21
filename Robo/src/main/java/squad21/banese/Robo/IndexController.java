package squad21.banese.Robo;
import java.time.LocalDateTime;

public class Agendamento {
    private String nomeCliente;
    private LocalDateTime dataAgendamento;
    private String tipoTarefa;

	 public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public LocalDateTime getDataAgendamento() {
            return dataAgendamento;
        }

        public void setDataAgendamento(LocalDateTime dataAgendamento) {
            this.dataAgendamento = dataAgendamento;
        }

        public String getTipoTarefa() {
            return tipoTarefa;
        }

        public void setTipoTarefa(String tipoTarefa) {
            this.tipoTarefa = tipoTarefa;
        }
}


@Controller
public class IndexController {


	@PostMapping("/agendamento")
public ResponseEntity agendarRobo(@RequestBody Agendamento agendamento) {

      return ResponseEntity.ok(HttpStatus.OK);
}

	
	@PostMapping("/registro")
public ResponseEntity registrarRobo(@RequestBody Robo robo) {

      return ResponseEntity.ok(HttpStatus.OK);
}

	@GetMapping("/consulta/1")
	public Robo consultarStatus() {
		return consultarStatus();
	}

	
