package com.fuzaro.dao;

import com.fuzaro.entity.UserInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationDAO extends JpaRepository<UserInformationEntity, String> {

}
