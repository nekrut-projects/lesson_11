create table users (
  id                    bigserial,
  name              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

create table authorities (
    id                  serial,
    name                varchar(100) not null,
    primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

CREATE TABLE users_authorities (
  user_id               bigint not null,
  authority_id               int not null,
  primary key (user_id, authority_id),
  foreign key (user_id) references users (id),
  foreign key (authority_id) references authorities (id)
);

insert into roles (name)
values
('ROLE_READER'), ('ROLE_WRITER'), ('ROLE_ADMIN');

insert into users (name, password, email)
values
('user_1', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user_1_@gmail.com'),
('user_2', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user_2_@gmail.com'),
('user_3', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user_3_@gmail.com');

insert into authorities (name)
values
('ONLY_READ'),
('READ_AND_WRITE'),
('SUPER_ADMIN');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2),
(3, 3);

insert into users_authorities (user_id, authority_id)
values
(1, 1),
(2, 2),
(3, 2);


