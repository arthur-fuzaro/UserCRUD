package com.fuzaro.business;

import com.fuzaro.dao.UserInformationDAO;
import com.fuzaro.dto.request.UserInformation;
import com.fuzaro.entity.UserInformationEntity;
import com.fuzaro.mapper.UserInformationMapper;
import com.fuzaro.validator.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    private final UserInformationMapper userInformationMapper;
    private final UserInformationDAO userInformationDAO;

    public UserBusiness(UserInformationDAO userInformationDAO) {
        this.userInformationDAO = userInformationDAO;
        userInformationMapper = new UserInformationMapper();
    }

    public UserInformation createUser(UserInformation userInformation) {
        UserValidator.validCreateUser(userInformation);
        UserInformationEntity userInformationEntity = userInformationMapper.toEntity(userInformation, true);
        userInformationEntity = userInformationDAO.save(userInformationEntity);

        return userInformationMapper.toUserInformationDTO(userInformationEntity);
    }
}
