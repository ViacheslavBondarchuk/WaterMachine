package com.org.house.model;

import com.org.house.dto.TransactionDTO;
import com.org.house.security.SecurityInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    public final static AutomatonState buildAutomatonState(TransactionDTO transactionDTO) {
        return new AutomatonState().builder()
                .automatonId(transactionDTO.getAutomaticId())
                .companyId(SecurityInformation.getUserCompanyId())
                .water(transactionDTO.getQuantityWater())
                .money(transactionDTO.getCost())
                .build();

    }


}
