package com.robsoft.agenda.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robsoft.agenda.entities.UserRole;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{

}
