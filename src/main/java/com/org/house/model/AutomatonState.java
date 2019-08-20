package com.org.house.model;

import com.org.house.dto.TransactionDTO;
import com.org.house.security.SecurityInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutomatonState {
    @Id
    @Column(name = "automaton_id")
    private long automatonId;

    @Column(name = "quantity_money")
    private double money;

    @Column(name = "quantity_water")
    private double water;

    @Column(name = "company_id")
    private long companyId;

    @OneToOne
    @JoinColumn(name = "automaton_id")
    private Automaton automaton;

    public final static AutomatonState buildAutomatonState(TransactionDTO transactionDTO) {
        SecurityInformation securityInformation;
        return new AutomatonState().builder()
                .automatonId(transactionDTO.getAutomaticId())
                .companyId(transactionDTO.getCompanyId())
                .water(transactionDTO.getQuantityWater())
                .money(transactionDTO.getCost())
                .build();

    }


}
