package com.example.mizanaccountingsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ReceiptId;
    private int Amount;
    private String Remark;

    @ManyToOne
    @JoinColumn(name = "MemberId")
    //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Member.class)
    private Member members;

    public Long getReceiptId() {
        return ReceiptId;
    }


}
