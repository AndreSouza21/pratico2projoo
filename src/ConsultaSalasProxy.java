import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultaSalasProxy implements ConsultaSalas {

    private ConsultaSalasService service;

    // cache das consultas
    private Map<String, List<Sala>> cache;

    public ConsultaSalasProxy(SistemaDeReservas sistema) {

        this.service = new ConsultaSalasService(sistema);

        this.cache = new HashMap<>();
    }

    @Override
    public List<Sala> consultarSalasDisponiveis(
            List<Sala> salas,
            LocalDate data,
            LocalTime inicio,
            LocalTime fim
    ) {

        String chave =
                data.toString()
                + "_"
                + inicio.toString()
                + "_"
                + fim.toString();

        // verifica cache
        if (cache.containsKey(chave)) {

            System.out.println(
                    "[PROXY] Consulta retornada do cache."
            );

            return cache.get(chave);
        }

        System.out.println(
                "[PROXY] Consultando serviço real..."
        );

        List<Sala> resultado =
                service.consultarSalasDisponiveis(
                        salas,
                        data,
                        inicio,
                        fim
                );

        cache.put(chave, resultado);

        return resultado;
    }

    public void limparCache() {
        cache.clear();
    }
}