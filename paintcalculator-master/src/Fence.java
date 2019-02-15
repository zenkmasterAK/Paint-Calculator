

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andyk
 */
public class  Fence implements Paintable{

     public int segment;
     
   public Fence(){ 
   this.segment=12;
   
   
   } 
    @Override
    public double getPremiumCost() {
        return 65.99;
    }

    @Override
    public double getStandardCost() {
        return 25.99;
    }

  
   
}

