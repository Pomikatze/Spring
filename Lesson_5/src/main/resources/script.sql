create table product (
    id serial primary key
    title varchar(128)
    price int not null
)

insert into product(title, price) values ('jacket', 1000);
insert into product(title, price) values ('t-shirt', 500);
insert into product(title, price) values ('jeans', 700);