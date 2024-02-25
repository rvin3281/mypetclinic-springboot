package com.caltech.mypetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caltech.mypetclinic.entity.Pet;

@Repository
public interface PetRepo extends JpaRepository<Pet,Integer> {

}
