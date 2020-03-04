
/**
 * MyDate description
 * @author Martin
 * @version 01/31/2018
 */
public class MyDate {
    private int year;
    private int month;
    private int day;
    
    //Other instance variables, if needed
   

    //Constructors (1) and (2)
    public MyDate(int day, int month, int year) {
        if(year >= 1600 && year <= 3000) {
            if(month >= 1 && month <= 12) {
                if(month == 1 || month == 3 || month == 5 ||
                   month == 7 || month == 8 || month == 10 || month == 12) {
                    if(day < 1 || day > 31) {
                        this.day = -1;
                        this.month = -1;
                        this.year = -1;
                    } else {
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                //check for a leap year
                } else if(month == 2 &&
                          ((year%4 == 0 && year%100 != 0) || year%400 == 0)) {
                    if(day < 1 || day > 29) {
                        this.day = -1;
                        this.month = -1;
                        this.year = -1;
                    } else {
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                } else if(month == 2 && year%4 != 0) {
                    if(day < 1 || day > 28) {
                        this.day = -1;
                        this.month = -1;
                        this.year = -1;
                    } else {
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                } else {
                    if(day < 1 || day > 30) {
                        this.day = -1;
                        this.month = -1;
                        this.year = -1;
                    } else {
                        this.day = day;
                        this.month = month;
                        this.year = year;
                    }
                }
            } else {
                this.day = -1;
                this.month = -1;
                this.year = -1;
            }
        } else {
            this.day = -1;
            this.month = -1;
            this.year = -1;
        }
    }
    
    public MyDate(int year) {
        this(1, 1, year);
    }
    
    //Accessors for the three instance variables
    public int getDay() {
        return day;
    }
    
    public int getMonth() {
        return month;
    }
  
    public int getYear() {
        return year;
    }

    //The advance method as stubbed out below
    public void advance(){
        if(month == 12 && day == 31) {
            year++;
            month = 1;
            day = 1;
        } else if(month == 1 || month == 3 || month == 5 || month == 7 ||
                  month == 8 || month == 10 || month == 12) {
            if(day == 31) {
                month++;
                day = 1;
            } else {
                day++;
            }
        } else if(month == 4 || month == 6 || month == 9 || month == 11) {
            if(day == 30) {
                month++;
                day = 1;
            } else {
                day++;
            }
        } else if(month == 2 && 
                  ((year%4 == 0 && year%100 != 0) || year%400 == 0)) {
            if(day == 29) {
                month++;
                day = 1;
            } else {
                day++;
            }
        } else if(month == 2 && year%4 != 0) {
            if(day == 28) {
                month++;
                day = 1;
            } else {
                day++;
            }
        }
    }


    //Keep this equals method unmodified
    public boolean equals(Object o){
        if (o instanceof MyDate)
        {
            MyDate date = (MyDate)o;
            if (this.day == date.getDay() &&
                this.month == date.getMonth() &&
                this.year == date.getYear())        
                    return true;
        }
        return false;
    }

    //The standard toString method stubbed out below that returns a string in prescribed format:
    public String toString() {
        String date = "";
        //append month to the date in text format
        switch(month) {
            case 1:
                date += "January ";
                break;
            case 2:
                date += "February ";
                break;
            case 3:
                date += "March ";
                break;
            case 4:
                date += "April ";
                break;
            case 5:
                date += "May ";
                break;
            case 6:
                date += "June ";
                break;
            case 7:
                date += "July ";
                break;
            case 8:
                date += "August ";
                break;
            case 9:
                date += "September ";
                break;
            case 10:
                date += "October ";
                break;
            case 11:
                date += "November ";
                break;
            case 12:
                date += "December ";
                break;
        }
        //apend the day and year to the date in number format
        date += day+", ";
        date += year;
        //return the date
        return date;
    }

   //Use this method to test your code. You should not have to modify this. 
   public static void main(String[] args){   
        //Check whether a user input advances correctly
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter a date to advance, in format day month year: ");
        int year,month,day;       
        day = scan.nextInt();
        month = scan.nextInt();
        year = scan.nextInt();
        MyDate date = new MyDate(day, month, year);
       
        //Manual verification - tests advance and toString
        System.out.println("Entered date is "+ date);
        date.advance();
        System.out.println("Advanced date is "+ date);
        
        //Now check test cases - tests advance and accessors
        MyDate correctDate;
        
        //TC 1 : one parameter constructor
        date = new MyDate(2013);
        correctDate = new MyDate(1,1,2013);
        if (date.equals(correctDate))
            System.out.println("TC 1 passed");
        else
            System.out.println("TC 1 failed");

        //TC 2 : 1/01/2013 advances to 01/02/2013
        date = new MyDate(1,1,2013);
        date.advance();
        correctDate = new MyDate(2,1,2013);
        if (date.equals(correctDate))
            System.out.println("TC 2 passed");
        else
            System.out.println("TC 2 failed");     
            
        //TC 3 : 1/31/2013 advances to 02/01/2013
        date = new MyDate(31,1,2013);
        date.advance();
        correctDate = new MyDate(1,2,2013);
        if (date.equals(correctDate))
            System.out.println("TC 3 passed");
        else
            System.out.println("TC 3 failed");                

        //TC 4 : 02/28/2013 advances to 03/01/2013
        date = new MyDate(28,2,2013);
        date.advance();
        correctDate = new MyDate(1,3,2013);
        if (date.equals(correctDate))
            System.out.println("TC 4 passed");
        else
            System.out.println("TC 4 failed");            

        //TC 5 : 04/30/2013 advances to 05/01/2013
        date = new MyDate(30,4,2013);
        date.advance();
        correctDate = new MyDate(1,5,2013);
        if (date.equals(correctDate))
            System.out.println("TC 5 passed");
        else
            System.out.println("TC 5 failed");                 
        
        //TC 6 : 12/31/2013 advances to 01/01/2014
        date = new MyDate(31,12,2013);
        date.advance();
        correctDate = new MyDate(1,1,2014);
        if (date.equals(correctDate))
            System.out.println("TC 6 passed");
        else
            System.out.println("TC 6 failed");                         
 
        //TC 7 : 02/28/2012 advances to 02/29/2012
        date = new MyDate(28,2,2012);
        date.advance();
        correctDate = new MyDate(29,2,2012);
        if (date.equals(correctDate))
            System.out.println("TC 7 passed");
        else
            System.out.println("TC 7 failed");   

        //Check validity of ranges
        date = new MyDate(28,2,1599);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 8 passed");
        else
            System.out.println("TC 8 failed");   

        date = new MyDate(28,2,3001);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 9 passed");
        else
            System.out.println("TC 9 failed");   
  
        date = new MyDate(28,13,2012);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 10 passed");
        else
            System.out.println("TC 10 failed");   


        date = new MyDate(28,0,2012);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 11 passed");
        else
            System.out.println("TC 11 failed");   
 

        date = new MyDate(29,2,2013);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 12 passed");
        else
            System.out.println("TC 12 failed");   
 

        date = new MyDate(31,4,2013);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 13 passed");
        else
            System.out.println("TC 13 failed");   


        date = new MyDate(32,1,2012);
        if (date.getDay()==-1 && date.getMonth()==-1 && date.getYear()==-1)
            System.out.println("TC 14 passed");
        else
            System.out.println("TC 14 failed");           
        
   }
}
