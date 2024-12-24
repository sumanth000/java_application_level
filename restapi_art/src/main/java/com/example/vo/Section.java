package com.example.vo;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public  class Section {
	
	
    public Ticket[] seats;
    

    public Section() {
        seats = new Ticket[10];
    }

    public boolean allocateSeat(Ticket ticket) {
    	
    	
    	boolean givenSeat=false;
    	
    	
    	for(int i=0;i<seats.length;i++)
    	{
    	  	if(seats[i]==null)
    	  	{
    	  		seats[i]=ticket;
    	  		givenSeat=true;
    	  		return givenSeat;
    	  	}
    	}
       
        return givenSeat;
    }

    public boolean modifySeat(int seatIndex, Ticket ticket) {
        if (seatIndex >= 0 && seatIndex < seats.length && seats[seatIndex] != null) {
            seats[seatIndex] = ticket;
            return true;
        }
        return false;
    }

    public Ticket[] getSeats() {
        return seats;
    }

	@Override
	public String toString() {
		return "Section [seats=" + Arrays.toString(seats) + "]";
	}

    
}
