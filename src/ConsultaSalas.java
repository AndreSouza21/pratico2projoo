import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaSalas {

    List<Sala> consultarSalasDisponiveis(
            List<Sala> salas,
            LocalDate data,
            LocalTime inicio,
            LocalTime fim
    );
}