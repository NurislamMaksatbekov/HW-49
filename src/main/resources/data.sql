insert into users(name, surname, username, email, password, photo, phone_number, type_id)
values ('CWX.TRANSPORTATION', null, 'cwxxxx', 'cwx@mail.ru', 'qwerty', null, '+996502271004',
        (select id from types_of_account where type = 'Employer')),
       ('Azidin', 'Amankulov', 'azidinn', 'azidin@mail.ru', 'azidinmanka', null, '+996555555555',
        (select id from types_of_account where type = 'Applicant'));


insert into categories(title)
values ('Taxi'),
       ('Sergent');


insert into contacts(PHONE_NUMBER, telegram, email, facebook_link, linkedin_link)
values ('+996555555555', 'CVK.REDAN', 'REDAN.SILA', 'https://sasaeeaessaeea', 'https://xaxaaxaxxaxaxax');


insert into vacancy(job_title, salary, job_description, required_max_exp, required_min_exp, date_of_posted, active,
                    category_id, author_email)
values ('Taxi', 200.00, 'We are very friendly', 1, 5, CURRENT_DATE, true,
        (select id from categories where title = 'Taxi'), (select email from users where email = 'cwx@mail.ru')),
       ('Sergent', 3000.00, 'We need a man sergent', 3, 10, CURRENT_DATE, true,
        (select id from categories where title = 'Sergent'), (select email from users where email = 'cwx@mail.ru'));


insert into resumes(job_title, required_salary, experience, title_of_company, responsibilities, education, active,
                    contact_id, author_email, category_id)
values ('Taxi', 100.00, 'I was taxi worker in the NY', 'FastX', 'Be friendly', 'Sergent', true,
        (select id from CONTACTS where PHONE_NUMBER = '+996555555555'),
        (select email from users where email = 'azidin@mail.ru'), (select id from categories where title = 'Taxi')),
       ('Sergent', 2500.00, 'I was a sergent in the NY central hospital for a 4 year', 'NYC', 'Be carefully', 'Sergent',
        true, (select id from CONTACTS where PHONE_NUMBER = '+996555555555'),
        (select email from users where email = 'azidin@mail.ru'), (select id from categories where title = 'Sergent'));


insert into responds(time_of_respond, respond, for_what_responded)
values (CURRENT_TIMESTAMP(), (select email from users where email = 'azidin@mail.ru'),
        (select id from vacancy where job_title = 'Taxi')),
       (CURRENT_TIMESTAMP(), (select email from users where email = 'azidin@mail.ru'),
        (select id from vacancy where job_title = 'Sergent'));

