package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vo.*;

import java.util.*;
import java.util.List;
import java.util.Map;

@Service
public class SessionDataService {

    @Autowired
    public  Train train;
    
   


    public boolean allocateSeat(Ticket ticket){
    	
    	
    	boolean seatAlloted=false;
    	
    	if(alreadyAlloted( ticket))
    	{
    		return false;
    	}
    	
    	if(train.getSectionA().allocateSeat(ticket))return true;
    	
    	if(train.getSectionB().allocateSeat(ticket))return true;
    	
    	return seatAlloted;
    	
    }
    
    
    public boolean modifySeat(String fromSeatIndex,String toSeatIndex,String mail) {
    	boolean seatModified=false;
    	Section s1=train.getSectionA();
    	Section s2=train.getSectionB();
    	
    	if(seatMatchesForChange(fromSeatIndex,mail))
    	{
    		if(allotModifiedSeat(fromSeatIndex,toSeatIndex))
    			return true;
    			
    			
    	}
    
    	
    	return seatModified;
    	
    }
    
    
    public boolean allotModifiedSeat(String fromSeatIndex,String toSeatIndex)
    {
    	
    	//gathered the seat index information
    	boolean modified=false;
    	String from_section=String.valueOf(fromSeatIndex.charAt(0));
    	int from_index=Integer.parseInt(String.valueOf(fromSeatIndex.subSequence(1, fromSeatIndex.length())));
    	
    	String to_Section=String.valueOf(toSeatIndex.charAt(0));
    	int to_index=Integer.parseInt(String.valueOf(toSeatIndex.subSequence(1, toSeatIndex.length())));
    	
    	//getting the information out of the old ticket
    	
    	
    
    	if(from_section.equalsIgnoreCase("A")){
    		Section from_section_name=train.getSectionA();
    		Ticket [] from_tickets=from_section_name.getSeats();
    		Ticket ticket=from_tickets[from_index-1];
    		
    		User user=new User();
    		user.setEmail(ticket.getUser().getEmail());
    		user.setFirstName(ticket.getUser().getFirstName());
    		user.setLastName(ticket.getUser().getLastName());
    	
    		
    		
    		Ticket shiftingTicket=new Ticket(user,ticket.getFrom(),ticket.getTo(),ticket.getPrice());
       
    		if(to_Section.equalsIgnoreCase("A"))
    		{
    			Section allotingSection=train.getSectionA();
        		Ticket [] tickets=allotingSection.getSeats();
        		
        		if(tickets[to_index-1]!=null)
        		{
        			return false;
        		}
        		else if(tickets[to_index-1]==null)
        		{tickets[to_index-1]=shiftingTicket;
        		from_tickets[from_index-1]=null;
        		return true;
        		}
    		}
    		else if(to_Section.equalsIgnoreCase("B"))
    		{
    			Section allotingSection=train.getSectionB();
        		Ticket [] tickets=allotingSection.getSeats();
        		if(tickets[to_index-1]!=null)
        		{
        			return false;
        		}
        		else if(tickets[to_index-1]==null) {
        		tickets[to_index-1]=shiftingTicket;
        		from_tickets[from_index-1]=null;
        			return true;
        		}
    		}
    		
    	}
    	else if(from_section.equalsIgnoreCase("B")){
    		Section s2=train.getSectionB();
    		Ticket [] from_ticket_s2=s2.getSeats();
    		Ticket ticket=from_ticket_s2[from_index-1];
    		
    		User user=new User();
    		user.setEmail(ticket.getUser().getEmail());
    		user.setFirstName(ticket.getUser().getFirstName());
    		user.setLastName(ticket.getUser().getLastName());
    	
    		
    		
    		Ticket shiftingTicket=new Ticket(user,ticket.getFrom(),ticket.getTo(),ticket.getPrice());
       
    		if(to_Section.equalsIgnoreCase("A"))
    		{
    			Section allotingSection=train.getSectionA();
        		Ticket [] tickets=allotingSection.getSeats();
        		
        		if(tickets[to_index-1]!=null)
        		{
        			return false;
        		}
        		else if(tickets[to_index-1]==null) {
        		tickets[to_index-1]=shiftingTicket;
        		from_ticket_s2[from_index-1]=null;
        		return true;
        		}
    		}
    		else if(to_Section.equalsIgnoreCase("B"))
    		{
    			Section allotingSection=train.getSectionB();
        		Ticket [] tickets=allotingSection.getSeats();
        			
        		if(tickets[to_index]!=null)
        		{
        			return false;
        		}
        		else if(tickets[to_index]==null) {
            		tickets[to_index]=shiftingTicket;
            		from_ticket_s2[from_index-1]=null;
        			return true;
        		}
    		}
    		
    	}
    	
    	
    	
    	
    	
    	
    	return modified;
    }
    
    public boolean seatMatchesForChange(String seatIndex,String mail) {
    	boolean matches=false;
    	
    	String section=String.valueOf(seatIndex.charAt(0));
    	int index=Integer.parseInt(String.valueOf(seatIndex.subSequence(1, seatIndex.length())));
    	
    	if(section.equalsIgnoreCase("A")){
    		Section s1=train.getSectionA();
    		Ticket [] t=s1.getSeats();
    		Ticket ticket=t[index-1];
    		
    		
    		if(ticket.getUser().getEmail().equalsIgnoreCase(mail))
    		return true;	
    	}
    	
    	if(section.equalsIgnoreCase("B")){
    		Section s2=train.getSectionB();
    		Ticket [] t=s2.getSeats();
    		Ticket ticket=t[index-1];
    		
    		
    		if(ticket.getUser().getEmail().equalsIgnoreCase(mail))
    		return true;	
    	}
    	
    	
    	
    	return matches;
    	
    }
    public boolean alreadyAlloted(Ticket ticket) {
    	
    	Section s1=train.getSectionA();
    	Section s2=train.getSectionB();
    	
    	boolean Matched=false;
    	for(Ticket t:s1.getSeats()) {
    		
    		if(t!=null)
    		{
    			boolean sameMail=t.getUser().getEmail().equalsIgnoreCase(ticket.getUser().getEmail());
        		boolean sameFirstName=t.getUser().getFirstName().equalsIgnoreCase(ticket.getUser().getFirstName());
        		boolean sameLastName=t.getUser().getLastName().equalsIgnoreCase(ticket.getUser().getLastName());
              
        		if(sameMail && sameFirstName && sameLastName)
        			return true;
        		
    		}
    		
    		
    	}
    	for(Ticket t:s2.getSeats()) {
    		if(t!=null)
    		{
    			boolean sameMail=t.getUser().getEmail().equalsIgnoreCase(ticket.getUser().getEmail());
        		boolean sameFirstName=t.getUser().getFirstName().equalsIgnoreCase(ticket.getUser().getFirstName());
        		boolean sameLastName=t.getUser().getLastName().equalsIgnoreCase(ticket.getUser().getLastName());
              
        		if(sameMail && sameFirstName && sameLastName)
        			return true;
        		
    		}
    		
    		
    	}
    	return Matched;
    }
    
    public List<Map<String,Ticket>> getSeatsInSection(String RequestedSection){
    
//    	List<Ticket> result=new ArrayList<>();
    	Section section=RequestedSection.equalsIgnoreCase("A")?train.getSectionA():train.getSectionB();
    	
    	System.out.println("A"+Arrays.toString(train.getSectionA().getSeats()));
    	System.out.println("B"+Arrays.toString(train.getSectionB().getSeats()));


    	Ticket[] tickets=section.getSeats();
//    	result=Arrays.asList(tickets);
    	
    	List<Map<String,Ticket>> ticketDataList=new ArrayList<>();

    	int index=1;
    	for(Ticket t:tickets)
    	{
    		Map<String,Ticket> ticketData=new HashMap<>();
    		ticketData.put(RequestedSection+""+index++, t);
    		ticketDataList.add(ticketData);
    		
    	}
    	
    	
    	
    	
    	return ticketDataList;
    }
    
    
    public boolean removeUser(String mail,String seatNumber)
    {
    	boolean removed=false;
    	
    	if(seatMatchesForChange(seatNumber,mail))
    	{
    		if(removeSeat(seatNumber))
    		{
    			return true;
    		}
    	}
    	
    	return removed;
    }
    
    public boolean removeSeat(String fromSeatIndex ) {

    	
    	//gathered the seat index information
    	boolean modified=false;
    	String from_section=String.valueOf(fromSeatIndex.charAt(0));
    	int from_index=Integer.parseInt(String.valueOf(fromSeatIndex.subSequence(1, fromSeatIndex.length())));
    	
    	
    	
    	
    
    	if(from_section.equalsIgnoreCase("A")){
    		Section from_section_name=train.getSectionA();
    		Ticket [] from_tickets=from_section_name.getSeats();
    		
    		
    		from_tickets[from_index-1]=null;
    		return true;
    		
    		
    		
    	}
    	else if(from_section.equalsIgnoreCase("B")){
    		Section s2=train.getSectionB();
    		Ticket [] from_ticket_s2=s2.getSeats();
    		from_ticket_s2[from_index-1]=null;
    		return true;
    		
    	}
    	
    	
    	
    	
    	
    	
    	return modified;
    
    }
    
    public List<Map<String,Ticket>> getSeatsPerUser(String mail){
        
    	
    	List<Map<String,Ticket>> ticketList=new ArrayList<>();

    	Section sectionA=train.getSectionA();
    			Section sectionB=train.getSectionB();
    	
    	System.out.println("A"+Arrays.toString(train.getSectionA().getSeats()));
    	System.out.println("B"+Arrays.toString(train.getSectionB().getSeats()));

    	
    	//section A
    	int index1=1;
    	for(Ticket t:sectionA.getSeats()) {
    		
    		if(t!=null)
    		if(t.getUser().getEmail().equalsIgnoreCase(mail))
    		{
    			
    			Map<String,Ticket> ticket=new HashMap<>();
    			ticket.put("A"+index1,t);
    			ticketList.add(ticket);
    		
    		}
    		index1++;
    	}
    	
    	
    	
    	//section B
    	
    	int index2=1;
		for (Ticket t : sectionB.getSeats()) {
            if(t!=null)
			if (t.getUser().getEmail().equalsIgnoreCase(mail)) {
				Map<String, Ticket> ticket = new HashMap<>();
				ticket.put("B"+index2, t);
				ticketList.add(ticket);

			}
			index2++;
		}
 
    return ticketList;
    	
    	
    	
    	
    
    }
}
