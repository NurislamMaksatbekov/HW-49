create table if not exists types(
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
    phone_number varchar(50) not null,
    type_id bigint not null references types (id)
);

create table if not exists categories(
     id bigint auto_increment not null primary key,
     title varchar(50) not null
);

create table if not exists employers_resume(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    salary double not null,
    description varchar(150) not null,
    required_max_exp int not null,
    required_min_exp int not null,
    category_id bigint not null references categories (id),
    author_id bigint not null references users (id)
);

create table if not exists contacts(
    id bigint auto_increment not null primary key ,
    number varchar(50) not null,
    telegram varchar(150),
    email varchar(150),
    facebook_link varchar(150),
    linkedin_link varchar(150)
);

create table if not exists applicants_resume
(
    id bigint auto_increment not null primary key,
    job_title varchar(50) not null,
    required_salary double not null,
    experience varchar(100) not null,
    title_of_company varchar(50) not null,
    responsibilities varchar(150) not null,
    education varchar(100) not null,
    contact_id bigint not null references contacts (id),
    author_id bigint not null references users (id),
    category_id bigint not null references categories (id)
);



create table if not exists job_lists(
    id bigint auto_increment not null primary key,
    date_of_posted date not null,
    employer_id bigint not null references employers_resume (id),
    category_id bigint not null references categories (id)
);

create table if not exists responds(
    id bigint auto_increment not null primary key,
    time_of_respond datetime not null,
    who_responded bigint not null references applicants_resume (id),
    for_what_responded bigint not null references job_lists (id)
);



insert into types(type)
values ( 'Applicant' ),
('Employer');


insert into users(name, surname, username, email, password, phone_number, type_id)
values ( 'Nurislam', 'Maksatbekov', 'maksatbekov', 'maksatbekov@mail.ru', 'qwerty', '+996502271004', (select id from types where type = 'Employer' )),
       ('Azidin', 'Amankulov', 'azidinn', 'azidin@mail.ru', 'azidinmanka', '+996555555555', (select id from types where type = 'Applicant'));


insert into categories(title)
values ( 'Taxi'),
    ( 'Sergent');


insert into contacts(number, telegram, email, facebook_link, linkedin_link)
values ( '+996555555555', 'CVK.REDAN', 'REDAN.SILA', 'https://sasaeeaessaeea', 'https://xaxaaxaxxaxaxax' );


insert into employers_resume(job_title, salary, description, required_max_exp, required_min_exp, category_id, author_id)
values ( 'Taxi', 200.00, 'We are very friendly', 1, 5, 1, 1),
       ( 'Sergent', 3000.00, 'We need a man sergent', 3, 10, 2, 1);


insert into applicants_resume(job_title, required_salary, experience, title_of_company, responsibilities, education, contact_id, author_id, category_id)
values ( 'Taxi', 100.00, 'I was taxi worker in the NY', 'FastX', 'Be friendly', 'Sergent', 1, 2, 1),
       ( 'Sergent', 2500.00, 'I was a sergent in the NY central hospital for a 4 year', 'NYC', 'Be carefully',  'Sergent', 1, 2, 2);


insert into job_lists(date_of_posted, employer_id, category_id)
values ( CURRENT_DATE, 1, 1),
    ( CURRENT_DATE, 1, 2);


insert into responds(time_of_respond, who_responded, for_what_responded)
values ( CURRENT_TIMESTAMP(), 1, 1),
       ( CURRENT_TIMESTAMP(), 1, 2);
