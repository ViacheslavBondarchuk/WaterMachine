package com.org.house.dto;

import com.org.house.transfer.NewAutomaton;
import com.org.house.transfer.NewUser;
import com.org.house.transfer.UpdateAutomaton;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.sql.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
public class AutomatonDTO {
    @Null(groups = {NewAutomaton.class})
    @NotNull(groups = {UpdateAutomaton.class})
    private int id;
    @NotBlank(groups = {NewAutomaton.class, UpdateAutomaton.class})
    private String tradeMark;
    @NotBlank(groups = {NewAutomaton.class, UpdateAutomaton.class})
    private long company_id;


}
