create table pet_peticao (
  pet_id bigint generated always as identity,
  pet_texto varchar(150) not null,
  pet_data_hora_criacao timestamp not null,
  pet_data_hora_submissao timestamp,
  pet_prioridade int,
  pet_status varchar(5) not null
);

insert into pet_peticao (pet_texto, pet_data_hora_criacao, pet_prioridade, pet_status)
  values ('Exijo uma nota boa', current_timestamp, null, 'PEN'),
         ('Socorro', current_timestamp, 3, 'CAN');


GRANT SELECT ON TABLE pet_peticao TO spring;

GRANT INSERT, UPDATE, DELETE ON TABLE pet_peticao TO spring;

SELECT CURRENT_USER;

