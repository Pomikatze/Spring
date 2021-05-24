drop table if exists
"ru.geekbrains".product cascade;

drop table if exists
"ru.geekbrains".person cascade;

create table "ru.geekbrains".product (id serial, title varchar(255), price integer,primary key (id));

create table "ru.geekbrains".person (id serial, name varchar(255),
					 product_id integer references "ru.geekbrains".product (id), primary key (id));

alter table "ru.geekbrains".product add column person_id integer references "ru.geekbrains".person (id);

insert into "ru.geekbrains".person (name) values ('Ann');
insert into "ru.geekbrains".person (name) values ('Roman');
insert into "ru.geekbrains".product (title, price) values ('jeans', 1200);
insert into "ru.geekbrains".product (title, price) values ('jacket', 1000);