insert into categories(TITLE)
values ('TAXI'),
       ('SERGENT');

insert into CONTACTS_TYPE(TYPE)
values ( 'Phone_number' ),
        ( 'Telegram'),
        ( 'Email'),
        ( 'Facebook_Link'),
        ( 'LinkedIn_Link');

insert into TYPES_OF_ACCOUNT(TYPE)
values ('Applicant'),
       ('Employer');

insert into EDUCATIONS(EDUCATION, PLACE_OF_STUDY, STUDY_PERIOD)
values ('DRIVER', 'THE BEST DRIVER SCHOOL', 'FROM 2011 to 2012'),
       ('SERGENT', 'LA.UNIVERSITY', 'FROM 2011 TO 2022');



insert into EXPERIENCES(COMPANY_NAME, YEAR_OF_WORK, RESPONSIBILITIES)
values ('FastX', 'FROM 2018 TO 2023', 'BE FAST'),
       ('NYC.HOSPITAL', 'FROM 2022 TO 2023', 'BE CAREFULLY');


insert into EDUCATIONS_INFO (EDUCATION_ID)
values ((select id from EDUCATIONS where EDUCATION = 'DRIVER')),
       ((select id from EDUCATIONS where EDUCATION = 'SERGENT'));


insert into EXPERIENCES_INFO (EXPERIENCE_ID)
values ((select id from EXPERIENCES where COMPANY_NAME = 'FastX')),
       ((select id from EXPERIENCES where COMPANY_NAME = 'NYC.HOSPITAL'));



insert into users(name, surname, username, email, password, photo, phone_number, ACCOUNT_TYPE)
values ('CWX.TRANSPORTATION', null, 'cwxxxx', 'cwx@mail.ru', 'qwerty', null, '+996502271004',
        (select TYPE from TYPES_OF_ACCOUNT where type = 'Employer')),
       ('Azidin', 'Amankulov', 'azidinn', 'azidin@mail.ru', 'azidinmanka', null, '+996555555555',
        (select TYPE from TYPES_OF_ACCOUNT where type = 'Employer'));

insert into VACANCIES(title, salary, job_description, required_min_experience, required_max_experience, date_of_posted,
                      date_of_updated, active, category_id, author_email)
VALUES ('Taxi', 200.00, 'We are very friendly', 1, 5, now(), now(), true,
        (select id from categories where title = 'TAXI'), (select email from users where email = 'cwx@mail.ru')),
       ('Sergent', 3000.00, 'We need a man sergent', 3, 10, now(), now(), true,
        (select id from categories where title = 'SERGENT'), (select email from users where email = 'cwx@mail.ru'));


insert into RESPONDS(time_of_responds, responder_email, responded_vacancy_id)
VALUES (now(), (select email from users where name = 'Azidin'), (select id from VACANCIES where TITLE = 'Taxi')),
       (now(), (select email from users where name = 'Azidin'), (select id from VACANCIES where TITLE = 'Sergent'));

insert into RESUMES(title, required_salary, active, author_email, experience_info_id, education_info_id, category_id)
VALUES ('TAXI', 1900, true, (select email from USERS where NAME = 'Azidin'),
        (select id from EXPERIENCES_INFO where EXPERIENCE_ID = 1),
        (select id from EDUCATIONS_INFO where EDUCATION_id = 1),
        (select id from CATEGORIES where TITLE = 'TAXI')),
       ('SERGENT', 3500, true, (select email from USERS where NAME = 'Azidin'),
        (select id from EXPERIENCES_INFO where EXPERIENCE_ID = 2),
        (select id from EDUCATIONS_INFO where EDUCATION_ID = 2),
        (select id from CATEGORIES where TITLE = 'SERGENT'));

insert into CONTACTS ("value", contact_type, resume_id)
values('+996555555555', (select TYPE from CONTACTS_TYPE where TYPE = 'Phone_number'), (select id from RESUMES where title = 'TAXI')),
    ('+996555555555', (select TYPE from CONTACTS_TYPE where TYPE = 'Phone_number'), (select id from RESUMES where title = 'SERGENT'));

