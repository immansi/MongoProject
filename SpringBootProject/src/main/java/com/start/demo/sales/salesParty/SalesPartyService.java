package com.start.demo.sales.salesParty;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesPartyService {

	@Autowired
	salesPartyRepository salespartyrepository ;
	
	HashMap<String,SalesPartyModel> smap = new HashMap<String,SalesPartyModel>();
	
	public List<SalesPartyModel> getAllParty() {
		return salespartyrepository.findAll();
		
	}

	public SalesPartyModel getPartyById(String saleid) {
		Optional<SalesPartyModel> optionalparty = salespartyrepository.findById(saleid);
        if (optionalparty.isPresent()) {
            return optionalparty.get();
        }
        return null;
	
	}

	public void addParty(SalesPartyModel smodel) {
		salespartyrepository.save(smodel);
	}

	public HashMap<String, SalesPartyModel> updateParty(String saleid, SalesPartyModel smodel) {
		java.util.Optional<SalesPartyModel> srto = salespartyrepository.findById(saleid);

		  if (srto.isPresent()) {
			  SalesPartyModel ssto = srto.get();
			  ssto.setSalename(smodel.getSalename());
			  ssto.setSalecontactno(smodel.getSalecontactno());
			  ssto.setSaleopeningacc(smodel.getSaleopeningacc());
		  smodel = salespartyrepository.save(ssto);
		  smap.put("Updated", ssto);
		  return smap;
		  }else {
			  smap.put("null", null);
			  return smap;
		  }
	}

	public void deleteParty(String saleid) {
		salespartyrepository.deleteById(saleid); 
		
	}
}
