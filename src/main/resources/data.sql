create table if not exists type(
   id bigint auto_increment not null primary key ,
   type varchar(50) not null
);

create table if not exists users(
    id bigint auto_increment not null primary key ,
    name varchar(50) not null,
    surname varchar(50) not null,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(50) not null,
    type_id bigint not null references type (id)
);

create table if not exists category(
     id bigint auto_increment not null primary key,
     title varchar(50) not null ,
     category_id bigint not null references category (id)
);

create table if not exists employer(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    salary double not null,
    description varchar(150) not null,
    required_max_exp int not null,
    required_min_exp int not null,
    category_id bigint not null references category (id)
);

create table if not exists contact(
    id bigint auto_increment not null primary key ,
    number varchar(50) not null,
    telegram varchar(150),
    email varchar(150),
    facebook_link varchar(150),
    linkedin_link varchar(150)
);

create table if not exists employee(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    required_salary double not null,
    experience varchar(100) not null,
    education varchar(100) not null,
    contact_id bigint not null references contact (id)
);



create table if not exists job_list(
    id bigint auto_increment not null primary key,
    date_of_posted date not null,
    employer_id bigint not null references employer (id),
    category_id bigint not null references category (id)
);

create table if not exists responds(
    id bigint auto_increment not null primary key,
    time_of_respond datetime not null,
    who_responded bigint not null references employee (id),
    for_what_responded bigint not null references job_list (id)
);

insert into type(type)
values ( 'Employer' ),
('Employee');

insert into users(name, surname, username, email, password, type_id)
values ( 'Nurislam', 'Maksatbekov', 'maksatbekov', 'maksatbekov@mail.ru', 'qwerty', 1);

