package com.fuzaro.mapper;

import com.fuzaro.dto.request.UserContacts;
import com.fuzaro.dto.request.UserInformation;
import com.fuzaro.entity.UserContactEntity;
import com.fuzaro.entity.UserInformationEntity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor
public class UserInformationMapper {

    public UserInformationEntity toEntity(UserInformation userInformation, boolean create) {
        final UserInformationEntity userInformationEntity = new UserInformationEntity();
        if (create) {
            userInformationEntity.setCreatedAt(LocalDateTime.now());
            userInformationEntity.setId(UUID.randomUUID().toString());
        }

        userInformationEntity.setName(userInformation.getName());
        userInformationEntity.setEmail(userInformation.getEmail());
        userInformationEntity.setAddress(userInformation.getAddress());
        userInformationEntity.setBirthDate(userInformation.getBirthDate());
        userInformationEntity.setContact(userInformation.getContact().stream().map(this::toContactEntity).collect(toList()));
        userInformationEntity.setUpdateAt(LocalDateTime.now());

        return userInformationEntity;
    }

    private UserContactEntity toContactEntity(UserContacts userContacts) {
        final UserContactEntity userContactEntity = new UserContactEntity();
        userContactEntity.setType(userContacts.getType());
        userContactEntity.setDetails(userContacts.getDetail());
        return userContactEntity;
    }

    public UserInformation toUserInformationDTO(UserInformationEntity userInformationEntity) {
        final UserInformation userInformation = new UserInformation();
        userInformation.setId(userInformationEntity.getId());
        userInformation.setName(userInformationEntity.getName());
        userInformation.setEmail(userInformationEntity.getEmail());
        userInformation.setBirthDate(userInformationEntity.getBirthDate());
        userInformation.setAddress(userInformationEntity.getAddress());
        userInformation.setContact(userInformationEntity.getContact().stream().map(this::toUserContacts).collect(toList()));
        return userInformation;
    }

    private UserContacts toUserContacts(UserContactEntity userContactEntity) {
        final UserContacts userContacts = new UserContacts();
        userContactEntity.setType(userContactEntity.getType());
        userContactEntity.setDetails(userContactEntity.getDetails());
        return userContacts;
    }
}
