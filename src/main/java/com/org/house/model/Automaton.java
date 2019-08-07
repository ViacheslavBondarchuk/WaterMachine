package com.org.house.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Automaton {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "company_id")
	private long companyId;

	@Column(name = "trade_mark")
	private String tradeMark;

	@Column(name = "master_id")
	private long masterId;

	@OneToOne
	@JoinColumn(name = "automatonState_id")
	private AutomatonState automatonState;


}
