/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainevent;

/**
 *
 * @author TEBALELO MADUMETSA
 */
public class Event implements Comparable<Event>{
    
    private double priceForEvent;
    private String eventNumber;
    private int guests;
    private double pricePerGuest;
    
    private final static double HIGH_GUEST_PRICE = 50.00;
    private final static double LOW_GUEST_PRICE = 25.00;
    private final static int LARGE_EVENT = 70;
     private final static int EVENT_NUM_LENGTH = 5;
     
     
     public Event()
     {
         this("E000",0);
     }
    
     public Event(String num, int guests)
     {
         setEventNumber(num);
         setGuests(guests);
     }
     
     public int comparaTo(Event e)
     {
         int result;
         
         if(priceForEvent == e.getPriceForEvent())
         {
             result = 0;
         }
         
         else
             if(priceForEvent > e.getPriceForEvent())
             {
                 result = 1;
             }
         
         else
             {
                 result = -1;
                 
             }
         return result;
     }
     
     public String toString()
     {
         return "#" + eventNumber + "Guest: " + guests + "  Price R" + priceForEvent;
     }
     
     public void setEventNumber(String num)
     {
         boolean mumOL = true; 
         
         if(num.length() != EVENT_NUM_LENGTH ||
           !Character.isLetter(num.charAt(0)) ||     
           !Character.isLetter(num.charAt(1)) || 
           !Character.isLetter(num.charAt(2)) ||
            !Character.isLetter(num.charAt(3)))
             eventNumber = "E000";
         
         else
         {
             eventNumber = num.toUpperCase();
         }
     }
     
     public void setGuests(int gsts)
     {
         guests = gsts;
         
         if(isLargeEvent())
         {
             pricePerGuest = HIGH_GUEST_PRICE;
             priceForEvent = guests * HIGH_GUEST_PRICE;
         }
         
         else
         {
             pricePerGuest = LOW_GUEST_PRICE;
             priceForEvent = guests * LOW_GUEST_PRICE;
         }
     }
     
     public String getEventNumber()
     {
         return eventNumber;
     }
     
     public double getPriceForEvent()
     {
         return priceForEvent;
     }
     
    public double getPricePerGuest()
    {
        return pricePerGuest;
    }
    
    public boolean isLargeEvent()
    {
        boolean isLarge;
        
        if(guests > LARGE_EVENT)
        {
            isLarge = true;
        }
        
        else
        {
            isLarge = false;
        }
        return isLarge;
    }

    @Override
    public int compareTo(Event o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
