/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac Time.java
 *  Execution:    java Time minutes
 *
 *  Description: Takes one non-negative interger, minutes, entered by user 
 *  and calculates the end time from the start time had the given number of 
 *  minutes elapsed, outputting the start time and the end time according to
 *  the specified format. Although, starting time is declared as a constant
 *  at 12:00pm, this program can accomodate other starting times.
 *
 *  Dependencies: None.
 * 
 *  % java Time 50
 *  Start time: 12:00pm
 *  End time: 12:50pm
 *
 *  % java Time 100
 *  Start time: 12:00pm
 *  End time: 1:40pm
 *
 *  % java Time 720
 *  Start time: 12:00pm
 *  End time: 12:00am 
 *
 *************************************************************************/

public class Time 
{
    public static void main(String[] args) 
    {
        //  initializes start time as constants
        int START_HOUR = 12;
        int START_MINUTE = 0;
        String START_AM_OR_PM = "pm";
        
        //  initializes end time as start time
        int endHour = START_HOUR;
        String endAMorPM = START_AM_OR_PM;
        
        //  accepts input from user into variable that will funciton as ending
        //  minute
        int minutes = Integer.parseInt(args[0]);
        
        //  adds starting minute to accomodate for starting minute constant 
        //  greater than 0
        minutes += START_MINUTE;
        
        //  switches from am to pm or vice versa for each 12 period that has 
        //  elapsed
        while (minutes/720 >= 1)
        {
            minutes -= 720;
            if (endAMorPM.equals("pm")) endAMorPM = "am";
            else endAMorPM = "pm";           
        }
        
        //  increments ending hour for each 60 minute period that has elapsed
        while (minutes >= 60) 
        {
            minutes -= 60;
            endHour++;
            
            //  if ending hour goes above 12, reset back to 12-hour clock format
            if (endHour > 12) endHour -= 12;
           
        }
 
        //  converts starting and ending minute values into a string that 
        //  complies with the specified output format
        String startMinuteOutput = Integer.toString(START_MINUTE/10) 
                                   + Integer.toString(START_MINUTE % 10);
        String endMinuteOutput = Integer.toString(minutes/10) 
                                 + Integer.toString(minutes % 10);        
        
        
        //  outputs starting and ending times
        System.out.println("Start time: " + START_HOUR + ":" + startMinuteOutput
                           + START_AM_OR_PM);
        System.out.println("End time: " + endHour  + ":" + endMinuteOutput 
                           + endAMorPM);
        
    }
}