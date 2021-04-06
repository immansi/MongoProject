package com.start.demo.purchase.party;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PurchaseService {

	@Autowired
	PurchaseRepository purchaserepository ;
	HashMap<String,PurchaseModel> pumap = new HashMap<String,PurchaseModel>();
	
	public List<PurchaseModel> getAllParty() {
		return purchaserepository.findAll();
		
	}

	public PurchaseModel getPartyById(String puid) {
		Optional<PurchaseModel> optionalparty = purchaserepository.findById(puid);
        if (optionalparty.isPresent()) {
            return optionalparty.get();
        }
        return null;
	
	}

	public void addParty(PurchaseModel pumodel) {
		purchaserepository.save(pumodel);
	}

	public HashMap<String, PurchaseModel> updateParty(String puid, PurchaseModel pumodel) {
		java.util.Optional<PurchaseModel> rto = purchaserepository.findById(puid);

		  if (rto.isPresent()) {
			  PurchaseModel sto = rto.get();
		    sto.setParname(pumodel.getParname());
		   sto.setContactno(pumodel.getContactno());
		  sto.setOpeningacc(pumodel.getOpeningacc());
		  pumodel = purchaserepository.save(sto);
		  pumap.put("Updated", sto);
		  return pumap;
		  }else {
			  pumap.put("null", null);
			  return pumap;
		  }
	}

	public void deleteParty(String puid) {
		purchaserepository.deleteById(puid); 
		
	}
}
