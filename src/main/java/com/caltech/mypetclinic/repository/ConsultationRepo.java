package com.caltech.mypetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caltech.mypetclinic.entity.Consultation;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation,Integer> {

}
