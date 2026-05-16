## Sistema de Gerenciamento de Reserva de Salas de Estudo

**Funcionalidade:** Consulta de salas disponíveis por data e horário, com cache automático para evitar buscas repetidas no sistema.

**Padrão utilizado:** Proxy — a classe `ConsultaSalasProxy` intercepta as chamadas ao serviço real (`ConsultaSalasService`), armazenando resultados em cache e os reutilizando quando a mesma consulta é repetida.

**Como testar:** No terminal do sistema, use o comando `consultar`, informe data e horário, e repita a mesma consulta — na segunda vez, o retorno virá do cache, exibindo a mensagem `[PROXY] Consulta retornada do cache.`
