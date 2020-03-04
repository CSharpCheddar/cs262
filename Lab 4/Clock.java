/**
 * Clock class
 */
public class Clock implements Comparable<Clock> {
    private int hours,minutes,seconds;
    
    public int compareTo(Clock clock) {
        //check to see if anything is greater in this clock versus the other one
        if(getHours() > clock.getHours()) {
            return 1;
        } else if(getHours() == clock.getHours()) {
            if(getMinutes() > clock.getMinutes()) {
                return 1;
            } else if(getMinutes() == clock.getMinutes()) {
                if(getSeconds() > clock.getSeconds()) {
                    return 1;
                } else if(getSeconds() == clock.getSeconds()) {
                    //if absolutely everything is equal, return this
                    return 0;
                }
            }
        }
        //if anything at all is lesser in the given class, return this
        return -1;
    }
    
    public Clock(){
        hours = minutes = seconds = 0;
    }

    public Clock(int h, int m, int s){
        validate(h,m,s);
    }
    
    public void setHours(int h){
        validate(h,minutes,seconds);
    }

    public void setMinutes(int m){
        validate(hours,m,seconds);
    }
    
    public void setSeconds(int s){
        validate(hours,minutes,s);
    }
    
    public int getHours(){ return hours;}
    public int getMinutes(){ return minutes;}
    public int getSeconds(){ return seconds;}

    public void tick(){
        seconds++; 
        if (seconds > 59){
                seconds=0;
                minutes++;
        }
        if (minutes > 59){
                minutes=0;
                hours++;
        } 
        if (hours > 23)
            hours = 0;        
    }
    
    public boolean equals(Object obj){
        if (obj instanceof Clock){
                Clock c = (Clock)obj;
                if (this.getHours()==c.getHours() && this.getMinutes()==c.getMinutes() &&
                    this.getSeconds()==c.getSeconds())
                    return true;
        }
        return false; 
    }
    
    public String toString(){
        return hours+":"+minutes+":"+seconds;
    }
    
    private void validate(int h, int m, int s){
        if (h>=0 && h<=23)
            hours = h;
        if(m>=0 && m<=59)
            minutes = m;
        if (s>=0 && s<=59)
            seconds = s;    
    }
 
}