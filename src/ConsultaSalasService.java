import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaSalasService implements ConsultaSalas {

    private SistemaDeReservas sistema;

    public ConsultaSalasService(SistemaDeReservas sistema) {
        this.sistema = sistema;
    }

    @Override
    public List<Sala> consultarSalasDisponiveis(
            List<Sala> salas,
            LocalDate data,
            LocalTime inicio,
            LocalTime fim
    ) {

        List<Sala> disponiveis = new ArrayList<>();

        for (Sala sala : salas) {

            boolean ocupada = false;

            for (Reserva reserva :
                    sistema.getRepositorioReservas().getReservasAtivas()) {

                boolean mesmaSala =
                        reserva.getSala().getNome()
                                .equalsIgnoreCase(sala.getNome());

                boolean mesmaData =
                        reserva.getData().equals(data);

                boolean conflitoHorario =
                        reserva.getHorarioFim().isAfter(inicio)
                        &&
                        reserva.getHorarioInicio().isBefore(fim);

                if (mesmaSala && mesmaData && conflitoHorario) {
                    ocupada = true;
                    break;
                }
            }

            if (!ocupada) {
                disponiveis.add(sala);
            }
        }

        return disponiveis;
    }
}