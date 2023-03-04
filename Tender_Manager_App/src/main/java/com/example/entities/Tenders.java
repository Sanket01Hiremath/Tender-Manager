package com.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Tenders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Tid;
	private String name;
	private String type;
	private Integer minBidAmount;
	
	@JsonIgnore
	@NotNull
	private Integer status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@NotNull
	private List<Bids> bids;
	
	@OneToOne
	@JsonIgnore
	private Users vendor;
	
	
	
}
