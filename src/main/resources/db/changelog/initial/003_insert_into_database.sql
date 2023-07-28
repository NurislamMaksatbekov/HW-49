insert into categories(TITLE)
values ('TAXI'),
       ('SERGENT');

insert into CONTACTS_TYPE(TYPE)
values ( 'PHONE_NUMBER' ),
        ( 'TELEGRAM'),
        ( 'EMAIL'),
        ( 'FACEBOOK_LINK'),
        ( 'LINKEDIN_LINK');

insert into TYPES_OF_ACCOUNT(TYPE)
values ('APPLICANT'),
       ('EMPLOYER');


insert into users(name, surname, username, email, password, photo, phone_number, ACCOUNT_TYPE)
values ('CWX.TRANSPORTATION', null, 'cwxxxx', 'cwx@mail.ru', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', null, '+996502271004',
        (select TYPE from TYPES_OF_ACCOUNT where type = 'EMPLOYER')),
       ('Azidin', 'Amankulov', 'azidinn', 'azidin@mail.ru', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', null, '+996555555555',
        (select TYPE from TYPES_OF_ACCOUNT where type = 'APPLICANT'));

insert into VACANCIES(title, salary, job_description, required_min_experience, required_max_experience, date_of_posted,
                      date_of_updated, active, category_id, author_email)
VALUES ('Taxi', 200.00, 'We are very friendly', 1, 5, now(), now(), true,
        (select id from categories where title = 'TAXI'), (select email from users where email = 'cwx@mail.ru')),
       ('Sergent', 3000.00, 'We need a man sergent', 3, 10, now(), now(), true,
        (select id from categories where title = 'SERGENT'), (select email from users where email = 'cwx@mail.ru'));


insert into RESPONDS(time_of_responds, responder_email, responded_vacancy_id)
VALUES (now(), (select email from users where name = 'Azidin'), (select id from VACANCIES where TITLE = 'Taxi')),
       (now(), (select email from users where name = 'Azidin'), (select id from VACANCIES where TITLE = 'Sergent'));

insert into RESUMES(title, required_salary, active, author_email, category_id, date_of_posted, date_of_updated)
VALUES ('TAXI', 1900, true, (select email from USERS where NAME = 'Azidin'),
        (select id from CATEGORIES where TITLE = 'TAXI'), now(), now()),
       ('SERGENT', 3500, true, (select email from USERS where NAME = 'Azidin'),
        (select id from CATEGORIES where TITLE = 'SERGENT'), now(), now());

insert into CONTACTS (contact_value, contact_type, resume_id)
values('+996555555555', (select TYPE from CONTACTS_TYPE where TYPE = 'PHONE_NUMBER'), (select id from RESUMES where title = 'TAXI')),
    ('+996555555555', (select TYPE from CONTACTS_TYPE where TYPE = 'PHONE_NUMBER'), (select id from RESUMES where title = 'SERGENT'));



insert into EDUCATIONS(EDUCATION, PLACE_OF_STUDY, STUDY_PERIOD, RESUME_ID)
values ('DRIVER', 'THE BEST DRIVER SCHOOL', 'FROM 2011 to 2012', (select id from resumes where TITLE = 'TAXI')),
       ('SERGENT', 'LA.UNIVERSITY', 'FROM 2011 TO 2022', (select id from resumes where TITLE = 'SERGENT'));



insert into EXPERIENCES(COMPANY_NAME, WORK_PERIOD, RESPONSIBILITIES, RESUME_ID)
values ('FastX', 'FROM 2018 TO 2023', 'BE FAST', (select id from resumes where TITLE = 'TAXI')),
       ('NYC.HOSPITAL', 'FROM 2022 TO 2023', 'BE CAREFULLY', (select id from resumes where TITLE = 'SERGENT'));
