package com.example.vo;

import org.springframework.stereotype.Component;

@Component
public class Train {


    public Section sectionA;
   public Section sectionB;

    

    public Train(Section sectionA, Section sectionB) {
        this.sectionA = new Section();
        this.sectionB = new Section();
    }

    public Section getSectionA() {
        return sectionA;
    }
    
    

    public Section getSectionB() {
        return sectionB;
    }

	@Override
	public String toString() {
		return "Train [sectionA=" + sectionA + ", sectionB=" + sectionB + "]";
	}
}
