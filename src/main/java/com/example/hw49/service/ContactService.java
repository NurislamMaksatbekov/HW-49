package com.example.hw49.service;

import com.example.hw49.dao.ContactDao;
import com.example.hw49.dto.ContactDto;
import com.example.hw49.entity.Contact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ContactService {
    private final ContactDao contactDao;

    public void save(Contact contact) {
        contactDao.save(contact);
    }

    public ContactDto getContactByResumeId(Long id) {
        return ContactDto.builder()
                .contactValue(contactDao.getContactsByResumeId(id).getContactValue())
                .contactType(contactDao.getContactsByResumeId(id).getContactType())
                .build();
    }

    public void change(ContactDto contactDto) {
        contactDao.change(Contact
                .builder()
                .contactValue(contactDto.getContactValue())
                .contactType(contactDto.getContactType())
                .resumeId(contactDto.getResumeId())
                .build());
    }
}
