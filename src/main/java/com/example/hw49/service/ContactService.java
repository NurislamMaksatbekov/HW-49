package com.example.hw49.service;

import com.example.hw49.dao.ContactDao;
import com.example.hw49.dto.ContactDto;
import com.example.hw49.enums.ContactType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactService {
    private final ContactDao contactDao;

    public void save(ContactDto contactDto) {
        contactDao.save(ContactDto.builder()
                        .value(contactDto.getValue())
                        .contactType(contactDto.getContactType())
                .build());
    }

    public String contactType(String type){
        return contactDao.getType(type);
    }
}
