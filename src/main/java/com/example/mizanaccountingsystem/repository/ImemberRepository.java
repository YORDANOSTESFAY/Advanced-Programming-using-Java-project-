package com.example.mizanaccountingsystem.repository;

import com.example.mizanaccountingsystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImemberRepository extends JpaRepository<Member,Long> {
}
