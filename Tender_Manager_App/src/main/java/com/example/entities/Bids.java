package com.example.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bids {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Bid;
	private Integer bidAmount;
	
	@ManyToOne
	private Users vendor;
	
	@ManyToOne
	private Tenders tender;
}
