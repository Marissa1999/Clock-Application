//Programmer: Marissa Gonçalves
//Date: November 19, 2017
//Purpose: To create a digital clock where the hours, minutes and seconds can be altered based whether the time is in 12-hour or 24-hour format

public class Clock 

{
    
    //mention the instant and static fields being used in the program 
    private int seconds_since_midnight;
    private boolean amPmEnabled;
    private boolean secondsDisplayed;
    public final static int HOURS_PER_DAY = 24;
    public final static int MINUTES_PER_HOUR = 60;
    public final static int SECONDS_PER_MINUTE = 60;
    public final static int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    public final static int SECONDS_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    
    
    
    
    //set the hour between an appropriate range and save the calculated seconds_since_midnight
    public void setHour(int h)
    {
        
         if (h < 0 || h > 23)
        {
           throw new IllegalArgumentException("Invalid hours: " + h);  
        }
        
        
        int m = this.getMinute();
        int s = this.getSecond();
        this.seconds_since_midnight = (SECONDS_PER_HOUR * h) + (SECONDS_PER_MINUTE * m) + s;
        
      
        
    }
    
    
    
    
    //set the minute between an appropriate range and save the calculated seconds_since_midnight
    public void setMinute(int m)
    {
        
            if (m < 0 || m > 59)
        {
           throw new IllegalArgumentException("Invalid minutes: " + m);  
        }
       
            
        int h = this.getHour();
        int s = this.getSecond();
        this.seconds_since_midnight = (SECONDS_PER_HOUR * h) + (SECONDS_PER_MINUTE * m) + s;
        
       
    }
    
    
   
    
    //set the second between an appropriate range and save the calculated seconds_since_midnight
    public void setSecond(int s)
    {
       
        if (s < 0 || s > 59)
        {
           throw new IllegalArgumentException("Invalid seconds: " + s);  
        }
        
        int h = this.getHour();
        int m = this.getMinute();
        this.seconds_since_midnight = (SECONDS_PER_HOUR * h) + (SECONDS_PER_MINUTE * m) + s;
        
       
    }

     
    
    
    //make sure that hours, minutes and seconds are located before continuing
    public Clock(int h, int m, int s)
    {
        
        
        if (h < 0 && h > 23 && m < 0 && m > 59 && s < 0 && s > 59)
        {
            throw new IllegalArgumentException("There is an error with the clock time.");  
        }
        
      
        //if the range is applicable, allow the instance fields amPmEnabled and secondsDisplayed to be set properly, as well as calculaing the retrieved seconds_since_midnight
        else
        {
            this.amPmEnabled = false;
            this.secondsDisplayed = true;
            this.seconds_since_midnight = (SECONDS_PER_HOUR * h) + (SECONDS_PER_MINUTE * m) + s;
        }
            
        
    }
    
     
    
    //based on the Clock method with three parameters, set the variables accordingly
    public Clock (int h, int m) 
    {  
        this(h, m, 0);
    }
    
    
    
    
    //based on the Clock method with three parameters, set the variables accordingly
    public Clock (int h)
    {
        this(h, 0, 0);
    }
    
    
    
    
    //based on the Clock method with three parameters, set the variables accordingly
    public Clock()
    {
        this(0, 0, 0);
    }
    
    
    
    
    
    //create the "other" object by cloning the "this" object    
    public Clock (Clock other)
    {
        this(other.getHour(), other.getMinute(), other.getSecond()); 
    }
    
    
    
    
    
    //calculate the number of hours based on the total seconds_since_midnight
    public int getHour()
    {
        return this.seconds_since_midnight / SECONDS_PER_HOUR;
    }
    
    
    
    
    
    
    //calculate the number of minutes based on the total seconds_since_midnight
    public int getMinute()
    {
        return this.seconds_since_midnight % SECONDS_PER_HOUR / MINUTES_PER_HOUR;
    }
      
        
           
     
    
    
    //calculate the number of seconds based on the total seconds_since_midnight
    public int getSecond()
    {
          return this.seconds_since_midnight % SECONDS_PER_HOUR % MINUTES_PER_HOUR;
    }
    
    
    
    
    
    //return the variable amPmEnabled
    public boolean isAmPmEnabled()
    {
        return this.amPmEnabled;
    }
    
    
    
    
    
    //return the variable secondsDisplayed
    public boolean isSecondsDisplayed()
    {
        return this.secondsDisplayed;
    }
    
    
    
    
    //print out the correct time, according to whether it is military or standard
    @Override
    public String toString()
    {
        String result = "";
        
        
        //print out the following time if amPmEnabled is false an secondsDisplayed is true
        if (amPmEnabled == false)
        {
            if (secondsDisplayed == true)
            {  
                
                //implement the 0 in the time, whether the number of seconds/minutes/hours is less than 10 
                if (getHour() < 10 && getMinute() < 10 && getSecond() < 10)
                {
                    result += "0" + getHour() + ":0" + getMinute() + ":0" + getSecond() + "   ";  
                }
                
                
                else if (getHour() < 10 && getMinute() >= 10 && getSecond() >= 10)
                {
                    result += "0" + getHour() + ":" + getMinute() + ":" + getSecond() + "   ";  
                }
                
                
                else if (getHour() >= 10 && getMinute() < 10 && getSecond() >= 10)
                {
                    result += getHour() + ":0" + getMinute() + ":" + getSecond() + "   ";  
                }
                
                
                else if (getHour() >= 10 && getMinute() < 10 && getSecond() >= 10)
                {
                    result += getHour() + ":0" + getMinute() + ":" + getSecond() + "   ";  
                }
                 
                
                else if (getHour() >= 10 && getMinute() >= 10 && getSecond() < 10)
                {
                    result += getHour() + ":" + getMinute() + ":0" + getSecond() + "   ";  
                }
                
                
                else if (getHour() >= 10 && getMinute() < 10 && getSecond() < 10)
                {
                    result += getHour() + ":0" + getMinute() + ":0" + getSecond() + "   ";  
                }
                
                
                else if (getHour() < 10 && getMinute() < 10 && getSecond() >= 10)
                {
                    result += "0" + getHour() + ":0" + getMinute() + ":" + getSecond() + "   ";  
                }
                
                
                else if (getHour() < 10 && getMinute() >= 10 && getSecond() < 10)
                {
                    result += "0" + getHour() + ":" + getMinute() + ":0" + getSecond() + "   ";  
                }
                
                
                else
                {
                     result += getHour() + ":" + getMinute() + ":" + getSecond() + "   "; 
                }
            }
            
            
            
            
            
            //print out the following time if amPmEnabled is false an secondsDisplayed is false
            else
            {
                
                //implement the 0 in the time, whether the number of seconds/minutes/hours is less than 10 
                if (getHour() < 10 && getMinute() < 10)
                {
                    result += "0" + getHour() + ":0" + getMinute() + "      ";  
                }
                
                
                else if (getHour() >= 10 && getMinute() >= 10)
                {
                    result += getHour() + ":" + getMinute() + "      ";    
                }
                
                
                else if (getHour() < 10 && getMinute() >= 10)
                {
                    result += "0" + getHour() + ":" + getMinute() +  "      ";  
                }
                
                else
                {
                    result += getHour() + ":0" + getMinute() +  "      ";   
                }
               
            }
            
        }
        
        
        //print out the following time if amPmEnabled is true an secondsDisplayed is true
        if (amPmEnabled == true)
        {   
            if (secondsDisplayed == true)
            {
             
            //print out the time when the hour is supposed to be greater than 12, showing the seconds   
            if (getHour() > 12)
            {
               
               //implement the 0 in the time, whether the number of seconds/minutes is less than 10 
               if (getMinute() < 10 && getSecond() < 10)
               {
                   result += (getHour() - 12) + ":0" + getMinute() + ":0" + getSecond() + " PM";   
               }
               
               else if (getMinute() < 10 && getSecond() >= 10)
               {
                   result += (getHour() - 12) + ":0" + getMinute() + ":" + getSecond() + " PM"; 
               }
                   
               else if (getMinute() >= 10 && getSecond() < 10)
               {
                   result += (getHour() - 12) + ":" + getMinute() + ":0" + getSecond() + " PM";
               }
               
               else
               {
                   result += (getHour() - 12) + ":" + getMinute() + ":" + getSecond() + " PM";
               }
               
            }
            
            //print out the time when the hour is supposed to equal 0, indicating that the hour should show 12 A.M., showing the seconds
            else if (getHour() == 0)
            {
                
                //implement the 0 in the time, whether the number of seconds/minutes is less than 10  
               if (getMinute() < 10 && getSecond() < 10)
               {
                   result += "12:0" + getMinute() + ":0" + getSecond() + " AM";   
               }
               
               else if (getMinute() < 10 && getSecond() >= 10)
               {
                   result += "12:0" + getMinute() + ":" + getSecond() + " AM";        
               }
               
               else if (getMinute() >= 10 && getSecond() < 10)
               {
                   result += "12:" + getMinute() + ":0" + getSecond() + " AM"; 
               }
               
               else
               {
                   result += "12:" + getMinute() + ":" + getSecond() + " AM";
               }
                
            }
            
            
            //print out the time when the hour is between the range of 1 to 12, showing the seconds
            else if (getHour() <= 12 && getHour() >= 1)
            {
               //implement the 0 in the time, whether the number of seconds/minutes is less than 10 
               if (getMinute() < 10 && getSecond() < 10)
               {
                   result += getHour() + ":0" + getMinute() + ":0" + getSecond() + " AM";   
               }
               
               else if (getMinute() < 10 && getSecond() >= 10)
               {
                   result += getHour() + ":0" + getMinute() + ":" + getSecond() + " AM"; 
               }
                   
               else if (getMinute() >= 10 && getSecond() < 10)
               {
                   result += getHour() + ":" + getMinute() + ":0" + getSecond() + " AM";
               }
               
               else
               {
                  result += getHour() + ":" + getMinute() + ":" + getSecond() + " AM";
               }
                
            }
            
            }
            
            
            
            
            
            //print out the following time if amPmEnabled is true an secondsDisplayed is false
            else
            {
             
             //print out the time when the hour is supposed to be greater than 12, showing no seconds
             if (getHour() > 12)
             {
                 
               //implement the 0 in the time, whether the number of minutes is less than 10 
               if (getMinute() < 10)
               {
                   result += (getHour() - 12) + ":0" + getMinute() + "    PM";   
               }
               else
               {
                   result += (getHour() - 12) + ":" + getMinute() + "    PM";
               }
              
             }
             
             
            //print out the time when the hour is supposed to equal 0, indicating that the hour should show 12 A.M., showing no seconds
            else if (getHour() == 0)
            {
                //implement the 0 in the time, whether the number of minutes is less than 10 
                if (getMinute() < 10)
                {
                   result += "12:0" + getMinute() + "    AM";   
                }
                else 
                {
                   result += "12:" + getMinute() + "    AM";
                }
             
            }
             
             //print out the time when the hour is between the range of 1 to 12, showing no seconds
             else if (getHour() <= 12 && getHour() >= 1)
             {
                 
                 //implement the 0 in the time, whether the number of minutes is less than 10 
                 if (getMinute() < 10)
                 {
                     result += getHour() + ":0" + getMinute() + "    AM";      
                 }
                 else
                 {
                     result += getHour() + ":" + getMinute() + "    AM";
                 }
               
             } 
             
            }
            
        }
        
        
        return result;
    }
    
    
    
    
    //allow the "this" and "other" objects to compare with one another, by checking to see if they equal
    public boolean equals(Clock other)
    {
        //when the statement is considered correct according to the result, the boolean result is true
        return this.getHour() == other.getHour() && this.getMinute() == other.getMinute() && this.getSecond() == other.getSecond();
     
    }
    
    
    
    //allow the "this" and "other" objects to compare with one another, by checking to see if the "this" object precedes with the "other" object 
    public boolean precedes(Clock other)
    {
       
        boolean result = false;
        
        
        //if both objects have the military time format, then compare the hours, minutes and seconds until they both contrast one another
        if (this.amPmEnabled == false && other.amPmEnabled == false)
        {
            if (this.getHour() == other.getHour())
            {
                if (this.getMinute() == other.getMinute())
                { 
                    if (this.getSecond() >= other.getSecond())
                    {
                        return result;
                    }
                    
                    //if the seconds from the "other" object is greater, then the statement remains true 
                    else
                    {
                        return true;
                    }
                }
                
                //if the minutes from the "other" object is less, then the statement remains false
                else if (this.getMinute() > other.getMinute())
                {
                    return result;
                }
                
                //if the minutes from the "other" object is greater, then the statement remains true 
                else 
                {
                    return true;
                }
            }
            
            //if the hours from the "other" object is less, then the statement remains false
            else if (this.getHour() > other.getHour())
            {
                return result;
            }
            
            //if the hours from the "other" object is greater, then the statement remains true 
            else
            {
                return true;
            }
        }
        
        
        
        
        //when each object has a contrasting time, (one military and the other standard, or both have standard time), then the seconds_since_midnight must be compared
        else if (this.amPmEnabled == true && other.amPmEnabled == false || 
                 this.amPmEnabled == false && other.amPmEnabled == true || 
                 this.amPmEnabled == true && other.amPmEnabled == true)
        
            
        //make sure that the "this" object has a lower value
        return this.seconds_since_midnight < other.seconds_since_midnight;
 
        
    
    return result;
    
    }

            
   
    
    //based on the tickSecond method, indicate the number of seconds based on multiplying the specified hours with the SECONDS_PER_MINUTE final variable
    public void tickHour(int h)
    {
         
       tickSecond(SECONDS_PER_HOUR * h);
          
    }
    
    
    
    //based on the tickSecond method, indicate the number of seconds based on multiplying the specified minutes with the SECONDS_PER_MINUTE final variable
    public void tickMinute(int m)
    {    
        
       tickSecond(SECONDS_PER_MINUTE * m);
       
    }
    
    
    
    //allowing that the time remains in an appropriate range between [0-864000), calculate the seconds_since_midnight based on the called seconds 
    public void tickSecond(int s)
    {  
        
               seconds_since_midnight += s;
               seconds_since_midnight = seconds_since_midnight % SECONDS_PER_DAY;
               
               if (seconds_since_midnight < 0)
               {
                  seconds_since_midnight += SECONDS_PER_DAY;
               }
             
    }
    
    
    
    
    //set the amPmEnabled variable to true
    public void switchToStandardTime()
    {
        this.amPmEnabled = true;
    }
    
  
    
    
    //set the amPmEnabled variable to false
    public void switchToMilitaryTime()
    {
        this.amPmEnabled = false;
    }
    
    
    
    
    //set the secondsDisplayed variable to true
    public void showSeconds()
    {
        this.secondsDisplayed = true;
    }
    
    
    
    
    //set the secondsDisplayed variable to false
    public void hideSeconds()
    {
        this.secondsDisplayed = false;
    }
    
    
}
