package com.example.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.service.SessionDataService;
import com.example.vo.*;

@RestController
@RequestMapping("/api2")
public class TicketController {

    private final SessionDataService sessionDataService;

    public TicketController(SessionDataService sessionDataService) {
        this.sessionDataService = sessionDataService;
    }

    @PostMapping("/purchase")
    public String purchaseTicket(@RequestParam String email,
    		@RequestParam String name,
    		@RequestParam String from,
    		@RequestParam String to
    		) {
    	
    	
    	String [] nameSplit=name.split(" ");
    	String firstName=nameSplit[0];
    	String secondName=nameSplit[1];
    	
    	
    	
        User user = new User(firstName,secondName, email); 
        Ticket ticket=new Ticket(user,from,to,20);
        boolean success = sessionDataService.allocateSeat(ticket);
        return success ? "Ticket purchased successfully!" : "Seat allocation failed!";
    }

    @PostMapping("/modifySeat")
    public String modifySeat(@RequestParam String fromSeatIndex,
                             @RequestParam String toSeatIndex,
                             @RequestParam String mail) {
    	
    	
    	
    	boolean success=sessionDataService.modifySeat(fromSeatIndex,toSeatIndex,mail);
    	return success ? "Ticket modified successfully!" : "Seat allocation failed!";
      
    }
    
    

    @GetMapping("/seats")
    public List<Map<String,Ticket>> getSeatsInSection(@RequestParam String sectionName) {
        return sessionDataService.getSeatsInSection(sectionName);
    }
    @GetMapping("/seats/user")
    public List<Map<String,Ticket>> getSeatsPerUser(@RequestParam String mail) {
        return sessionDataService.getSeatsPerUser(mail);
    }

    @DeleteMapping("/removeUser")
    public String removeUser(@RequestParam String email, @RequestParam String seatNumber) {
        boolean success = sessionDataService.removeUser(email,seatNumber);
        return success ? "User removed successfully!" : "Removal failed!";
    }
}
