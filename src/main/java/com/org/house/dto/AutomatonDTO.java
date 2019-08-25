package com.org.house.dto;

import com.org.house.transfer.NewAutomaton;
import com.org.house.transfer.UpdateAutomaton;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutomatonDTO {
    @Null(groups = {NewAutomaton.class})
    @NotNull(groups = {UpdateAutomaton.class})
    private long id;

    @NotNull(groups = {NewAutomaton.class, UpdateAutomaton.class})
    private String tradeMark;

    @NotNull(groups = {NewAutomaton.class, UpdateAutomaton.class})
    private long companyId;

    @NotNull(groups = {NewAutomaton.class, UpdateAutomaton.class})
    private long masterId;


}
