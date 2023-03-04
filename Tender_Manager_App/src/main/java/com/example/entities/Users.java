package com.example.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@NotNull
	private List<Bids> bids;
	
	@OneToMany
	@JsonIgnore
	@NotNull
	private List<Tenders> tenders;
}
