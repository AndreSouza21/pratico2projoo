## Sistema de Gerenciamento de Reserva de Salas de Estudo

**Funcionalidade:** Consulta de salas disponíveis por data e horário, com cache automático para evitar buscas repetidas no sistema. Antes dessa implementação, não havia uma forma direta de verificar a disponibilidade de salas sem percorrer manualmente todas as reservas ativas — o que, em um sistema com grande volume de reservas e consultas frequentes, representaria um custo desnecessário a cada requisição. Com a funcionalidade adicionada, o usuário consegue, via terminal, informar uma data e um intervalo de horário e receber instantaneamente a lista de salas livres naquele período, tornando o fluxo de reserva mais eficiente e orientado à decisão.

