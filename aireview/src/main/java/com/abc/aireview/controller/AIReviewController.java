package com.abc.aireview.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.aireview.model.InvoiceData;
import com.abc.aireview.repository.ReviewRepository;


@RestController
@RequestMapping("/review-service")
public class AIReviewController {
	
	@Autowired
	private ReviewRepository repo;

	private int[] items = new int[]{1,2};

    private Random rand = new Random();
	
	
    @PostMapping("/saveallinvoicerecords")
	public String saveData(@RequestBody List<InvoiceData> data) {
		repo.saveAll(data);
		return "records saved successfully";
		
	}
    
    @GetMapping("/getAllRecords")
	public List<InvoiceData> getAll(){
		
		return repo.findAll();
	}
	
		
	@GetMapping("/getInvoicedata/{id}")
	public Optional<InvoiceData> getInvoiceById(@PathVariable int id) {
		Optional<InvoiceData> data=repo.findById(id);
		return data;
	}
	
	@GetMapping("/deletedata/{id}")
	public String deleteRecord(@PathVariable int id) {
		repo.deleteById(id);
		return "record deleted sucessfully.";
	}
	
    public int getRandArrayElement(){
        return items[rand.nextInt(items.length)];
    }
    
    
    
    
    @GetMapping("/getonlyuserRecords")
	public List<InvoiceData> getAllUserRecords(){
    	List<InvoiceData> listData=new ArrayList<InvoiceData>();
    	for (InvoiceData invoiceData : repo.findAll()) {
    		
    		if(invoiceData.getUser().equals("Analyst-1")|| invoiceData.getUser().equals("Analyst-2") && invoiceData.getStatus().equals("No")) {
    			listData.add(invoiceData);
    		}
			
		}
    	
		return listData;
	}
	
    
    
    @GetMapping("/getonlyuserandstatusexistRecords")
   	public List<InvoiceData> getAllUserandstausExistRecords(){
       	List<InvoiceData> listData=new ArrayList<InvoiceData>();
       	for (InvoiceData invoiceData : repo.findAll()) {
       		if(invoiceData.getUser().equals("Analyst-1")|| invoiceData.getUser().equals("Analyst-2") && invoiceData.getStatus().equals("Completed")) {
       			listData.add(invoiceData);
       		}
   			
   		}
       	
   		return listData;
   	}
    
    @GetMapping("/getnouserandstatusexistRecords")
   	public List<InvoiceData> getAllNoandstausExistRecords(){
       	List<InvoiceData> listData=new ArrayList<InvoiceData>();
       	for (InvoiceData invoiceData : repo.findAll()) {
       		if(invoiceData.getUser().equals("No")|| invoiceData.getUser().equals("No") && invoiceData.getStatus().equals("Completed")) {
       			listData.add(invoiceData);
       		}
   			
   		}
       	
   		return listData;
   	}
    
    
    
    @GetMapping("/getInvoicedatabyidandstatus/{id}")
    @ResponseBody
	public InvoiceData getInvoiceByIdandstatus(@PathVariable int id,@RequestParam String status ) {
    	InvoiceData invData=new InvoiceData();
    	boolean flag=false;
		Optional<InvoiceData> data=repo.findById(id);
		
	    if(data.isPresent()) 
	    	invData=data.get();
	    if(invData.getStatus().equals("Completed")) {
	    	flag=true;
	    }
	    	    
		return invData;
	
	}
    
    
    
    @GetMapping("/all")
    @ResponseBody
	public List<InvoiceData> getInvoiceByusernameandstatus(@RequestParam String username,@RequestParam String status ) {
    	
    	List<InvoiceData> listData=new ArrayList<InvoiceData>();
       	for (InvoiceData invoiceData : repo.findAll()) {
       		if(invoiceData.getUser().equals(username) && invoiceData.getStatus().equals(status)) {
       			listData.add(invoiceData);
       		}
   		}
		return listData;
	
	}
    
    
    
    
}
