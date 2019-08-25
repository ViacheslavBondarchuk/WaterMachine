package com.org.house.dto;

import com.org.house.model.TransactionType;
import com.org.house.transfer.NewTransaction;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {
    @Null(groups = {NewTransaction.class})
    private long id;

    @NotBlank(groups = NewTransaction.class)
    private long accountId;

    @NotBlank(groups = {NewTransaction.class})
    private long automaticId;

    @NotBlank(groups = {NewTransaction.class})
    private long companyId;

    @NotBlank(groups = {NewTransaction.class})
    private double cost;

    @NotBlank(groups = {NewTransaction.class})
    private Date date;

    @NotBlank(groups = {NewTransaction.class})
    private double quantityWater;

    @NotBlank(groups = {NewTransaction.class})
    private TransactionType type;

    @NotBlank(groups = {NewTransaction.class})
    private boolean byCard;

}
