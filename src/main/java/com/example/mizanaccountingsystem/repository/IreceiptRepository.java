package com.example.mizanaccountingsystem.repository;

import com.example.mizanaccountingsystem.model.Member;
import com.example.mizanaccountingsystem.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IreceiptRepository extends JpaRepository<Receipt,Long> {
}
