package com.app.Tenders.Services;

import com.app.Tenders.Entity.tender;
import com.app.Tenders.Repository.tenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tenderService {
    @Autowired
    private tenderRepo trepo;

    public tender addTender(tender t){
        return trepo.save(t);
    }

    public List<tender> getTenders(){
        return trepo.findAll();
    }
}
