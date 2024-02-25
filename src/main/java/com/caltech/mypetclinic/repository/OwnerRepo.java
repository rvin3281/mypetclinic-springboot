package com.caltech.mypetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caltech.mypetclinic.entity.Owner;

@Repository
public interface OwnerRepo extends JpaRepository<Owner,Integer> {

}
