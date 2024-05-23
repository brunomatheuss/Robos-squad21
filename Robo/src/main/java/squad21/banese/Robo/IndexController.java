package squad21.banese.Robo;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;

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


public class Robo {
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

    public void registrarAgendamento(Agendamento agendamento) {
        this.nomeCliente = agendamento.getNomeCliente();
        this.dataAgendamento = agendamento.getDataAgendamento();
        this.tipoTarefa = agendamento.getTipoTarefa();
    }
}

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    private static Agendamento agendamentoAtual;

    @PostMapping
    public void agendar(@RequestBody Agendamento agendamento) {
        agendamentoAtual = agendamento;
    }

    public static Agendamento getAgendamentoAtual() {
        return agendamentoAtual;
    }
}

	
@RestController
@RequestMapping("/registro")
public class RegistroController {

    @PostMapping
    public void registrar(@RequestBody Robo robo) {
        Agendamento agendamento = AgendamentoController.getAgendamentoAtual();
        if (agendamento != null) {
            robo.registrarAgendamento(agendamento);
            
            System.out.println("Registrando o robô para o cliente: " + robo.getNomeCliente());
        } else {
            System.out.println("Nenhum agendamento encontrado.");
        }
    }
}
	@GetMapping("/consulta/1")
	public Robo consultarStatus() {
		return consultarStatus();
	}

	
