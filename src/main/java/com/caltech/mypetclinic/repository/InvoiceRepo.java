package com.caltech.mypetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caltech.mypetclinic.entity.Invoice;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {

}
