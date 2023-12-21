package com.example.mizanaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.ast.tree.from.MappedByTableGroup;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberId;
    private String FullName;
    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Receipt> receipts;
    //private int Age;
    //private String States;

    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    //private LocalDate RegistrationDate;
    //private int  SavingAmount;
    //private String Telephone;

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
