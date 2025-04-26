create table age_agendamento (
  age_id bigint generated always as identity,
  age_instrucoes varchar(150),
  age_valor float,
  age_data_hora_inicio timestamp not null,
  age_duracao_prevista int,
  primary key(age_id)
);

insert into age_agendamento (age_instrucoes, age_data_hora_inicio, age_duracao_prevista)
  values ('Chegue meia hora antes', '2025-04-24 19:35', 15),
         (null, current_timestamp, null);


