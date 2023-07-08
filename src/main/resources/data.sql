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
     title varchar(50) not null
);

create table if not exists employer_resume(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    salary double not null,
    description varchar(150) not null,
    required_max_exp int not null,
    required_min_exp int not null,
    category_id bigint not null references category (id),
    user_id bigint not null references users (id)
);

create table if not exists contact(
    id bigint auto_increment not null primary key ,
    number varchar(50) not null,
    telegram varchar(150),
    email varchar(150),
    facebook_link varchar(150),
    linkedin_link varchar(150)
);

create table if not exists employee_resume
(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    required_salary double not null,
    experience varchar(100) not null,
    education varchar(100) not null,
    contact_id bigint not null references contact (id),
    user_id bigint not null references users (id)
);



create table if not exists job_list(
    id bigint auto_increment not null primary key,
    date_of_posted date not null,
    employer_id bigint not null references employer_resume (id),
    category_id bigint not null references category (id)
);

create table if not exists responds(
    id bigint auto_increment not null primary key,
    time_of_respond datetime not null,
    who_responded bigint not null references employee_resume (id),
    for_what_responded bigint not null references job_list (id)
);

insert into type(type)
values ( 'Employer' ),
('Employee');


insert into users(name, surname, username, email, password, type_id)
values ( 'Nurislam', 'Maksatbekov', 'maksatbekov', 'maksatbekov@mail.ru', 'qwerty', 1),
       ('Azidin', 'Amankulov', 'azidinn', 'azidin@mail.ru', 'azidinmanka', 2);


insert into category(title)
values ( 'Taxi'),
    ( 'Sergent');


insert into contact(number, telegram, email, facebook_link, linkedin_link)
values ( '+996555555555', 'CVK.REDAN', 'REDAN.SILA', 'https://sasaeeaessaeea', 'https://xaxaaxaxxaxaxax' );


insert into employer_resume(job_title, salary, description, required_max_exp, required_min_exp, category_id, user_id)
values ( 'Taxi', 200.00, 'We are very friendly', 1, 5, 1, 1),
       ( 'Sergent', 3000.00, 'We need a man sergent', 3, 10, 2, 1);


insert into employee_resume(job_title, required_salary, experience, education, contact_id, user_id)
values ( 'Taxi', 100.00, 'I was taxi worker in the NY', 'Sergent', 1, 2),
       ( 'Sergent', 2500.00, 'I was a sergent in the NY central hospital for a 4 year', 'Sergent', 1, 2);


insert into job_list(date_of_posted, employer_id, category_id)
values ( CURRENT_DATE, 1, 1),
    ( CURRENT_DATE, 1, 2);


insert into responds(time_of_respond, who_responded, for_what_responded)
values ( CURRENT_TIMESTAMP(), 1, 1),
       ( CURRENT_TIMESTAMP(), 1, 2);
