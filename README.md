# Sistema de Reservas de Salas de Estudo

## Visão Geral

Sistema de gerenciamento de reservas de salas universitárias, desenvolvido em Java. Permite que alunos e professores reservem diferentes tipos de salas — aulas teóricas, laboratórios, cabines individuais e salas de grupo — com controle de conflitos de horário, histórico de reservas, geração de relatórios e consulta de disponibilidade com cache via padrão Proxy.

## Instruções de Uso

Compile e execute o projeto a partir da classe `App.java`. O sistema inicializa automaticamente os usuários e salas e abre um terminal interativo com os seguintes comandos:

| Comando | Descrição |
|---|---|
| `rsala` | Reservar uma sala |
| `crsala` | Cancelar uma reserva |
| `relat` | Gerar relatório de reservas |
| `usuarios` | Listar usuários cadastrados |
| `consultar` | Consultar salas disponíveis por data e horário |
| `exit` | Encerrar o sistema |

Ao usar o comando `consultar`, informe a data no formato `AAAA-MM-DD` e os horários no formato `HH:MM`. Repetindo a mesma consulta, o resultado será retornado do cache automaticamente.

## Autores

- Autor 1
- Autor 2
