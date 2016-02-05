package com.nik.jba.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.jba.entity.Role;

@Repository
@Qualifier("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
