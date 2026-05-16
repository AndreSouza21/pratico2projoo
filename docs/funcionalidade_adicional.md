## Sistema de Gerenciamento de Reserva de Salas de Estudo

**Funcionalidade:** Consulta de salas disponíveis por data e horário, com cache automático para evitar buscas repetidas no sistema. Antes dessa implementação, não havia uma forma direta de verificar a disponibilidade de salas sem percorrer manualmente todas as reservas ativas — o que, em um sistema com grande volume de reservas e consultas frequentes, representaria um custo desnecessário a cada requisição. Com a funcionalidade adicionada, o usuário consegue, via terminal, informar uma data e um intervalo de horário e receber instantaneamente a lista de salas livres naquele período, tornando o fluxo de reserva mais eficiente e orientado à decisão.

**Padrão utilizado:** Proxy — ambas as classes `ConsultaSalasProxy` e `ConsultaSalasService` implementam a interface `ConsultaSalas`, garantindo que o proxy seja transparente para o restante do sistema. A classe `ConsultaSalasProxy` intercepta as chamadas ao serviço real, gerando uma chave composta por data e horário para identificar consultas já realizadas. Quando a chave existe no cache (`HashMap`), o resultado é retornado imediatamente sem acionar o serviço; caso contrário, a consulta é delegada ao `ConsultaSalasService`, que percorre as reservas ativas verificando conflitos de sala, data e horário, e o resultado é armazenado para uso futuro.

**Como testar:** No terminal do sistema, use o comando `consultar`, informe data e horário, e repita a mesma consulta — na segunda vez, o retorno virá do cache, exibindo a mensagem `[PROXY] Consulta retornada do cache.` Também é possível testar diretamente via código:

```java
ConsultaSalasProxy proxy = new ConsultaSalasProxy(sistema);

// Primeira chamada: aciona o serviço real
List<Sala> resultado = proxy.consultarSalasDisponiveis(
    faculdade.getSalas(),
    LocalDate.of(2025, 6, 10),
    LocalTime.of(10, 0),
    LocalTime.of(12, 0)
);

// Segunda chamada com os mesmos parâmetros: retorna do cache
List<Sala> resultadoCache = proxy.consultarSalasDisponiveis(
    faculdade.getSalas(),
    LocalDate.of(2025, 6, 10),
    LocalTime.of(10, 0),
    LocalTime.of(12, 0)
);
// Saída esperada: [PROXY] Consulta retornada do cache.
```
