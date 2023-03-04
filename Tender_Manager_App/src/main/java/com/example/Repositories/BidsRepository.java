package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Bids;
import com.example.entities.Tenders;
import com.example.entities.Users;

@Repository
public interface BidsRepository extends JpaRepository<Bids, Integer>{
	public List<Bids> findBidsBytender(Tenders tender);
	public List<Bids> findBidsByvendor(Users vendor);
}
