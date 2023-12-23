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


public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MemberId;
    private String FullName;
    /*@OneToMany(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference*/
    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Receipt> receipts;
    private int Age;

    //@DateTimeFormat(pattern = "yyyy-mm-dd")
   private String RegistrationDate;
    private int  SavingAmount;
    private String Telephone;

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

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {

        this.receipts = receipts;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public int getSavingAmount() {
        return SavingAmount;
    }

    public void setSavingAmount(int savingAmount) {
        SavingAmount = savingAmount;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }
}
