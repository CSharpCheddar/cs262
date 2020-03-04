
/**
 * Reads in input from a file with weather data, then provides a summary of the data.
 *
 * @author Martin Mueller
 * @version 04/10/2018
*/

import java.util.Scanner;
import java.lang.Math;
import java.io.*;

public class WeatherProcess {
    public static void main(String args[]) {
        try {
            //read in the file to be scanned
            Scanner input = new Scanner(new File(args[0]));
            //create printwriter
            PrintWriter writer = new PrintWriter(args[1]);
            //stores information about the currently queued month, year, and station
            String station = "";
            String stationName = "";
            String date = "";
            double tavg = 0.0;
            double avgwndchl = 0.0;
            //both used to calculate averages
            double tempCount = 0;
            double chillCount = 0;
            //skip first line
            input.nextLine();
            //print out a header in the output file
            writer.println("STATION,STATION_NAME,DATE,TAVG,AVGWNDCHL");
            //read in each line...
            while(input.hasNextLine()) {
                //split up the line into chuncks
                String nextLine = input.nextLine();
                String array[] = nextLine.split(",");
                //make the date the month and year only
                array[2] = array[2].substring(0,6);
                //if the station, month, and year are currently queued...
                if(station.equals(array[0]) &&
                   stationName.equals(array[1]) &&
                   date.equals(array[2])) {
                    //these handle temperature and windchill averages
                    if(!array[3].equals("N/A")) {
                        if(!array[4].equals("N/A")) {
                            double dailyAvg = 18.0*((Double.parseDouble(array[3]) + Double.parseDouble(array[4]))/2.0) + 32.0;
                            tavg += dailyAvg;
                            tempCount++;
                            //this block handles windchill conversion
                            if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                            }
                        } else {
                            double dailyAvg = 18.0*Double.parseDouble(array[3]) + 32.0;
                            tavg += dailyAvg;
                            tempCount++;
                            if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                            }
                        }
                    } else if(!array[4].equals("N/A")) {
                        double dailyAvg = 18.0*Double.parseDouble(array[4]) + 32.0;
                        tavg += dailyAvg;
                        tempCount++;
                        if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                        }
                    }
                } else {
                    //prints a new line
                    if(!station.equals("")) {
                        String tempAvg = "";
                        String chillAvg = "";
                        if(tempCount == 0) {
                            tempAvg = "N/A";
                        } else {
                            tempAvg = ""+(tavg/tempCount);
                        }
                        if(chillCount == 0) {
                            chillAvg = "N/A";
                        } else {
                            chillAvg = ""+(avgwndchl/chillCount);
                        }
                        writer.println(station+","+stationName+","+date+","+tempAvg+","+chillAvg);
                        tavg = 0.0;
                        tempCount = 0;
                        avgwndchl = 0.0;
                        chillCount = 0;
                    }
                    //starts a fresh line
                    station = array[0];
                    stationName = array[1];
                    date = array[2];
                    //these handle temperature and windchill averages
                    if(!array[3].equals("N/A")) {
                        if(!array[4].equals("N/A")) {
                            double dailyAvg = 18.0*((Double.parseDouble(array[3]) + Double.parseDouble(array[4]))/2.0) + 32.0;
                            tavg += dailyAvg;
                            tempCount++;
                            //this part handles windchill (as do the other similar blocks)
                            if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                            }
                        } else {
                            double dailyAvg = 18.0*Double.parseDouble(array[3]) + 32.0;
                            tavg += dailyAvg;
                            tempCount++;
                            if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                            }
                        }
                    } else if(!array[4].equals("N/A")) {
                        double dailyAvg = 18.0*Double.parseDouble(array[4]) + 32.0;
                        tavg += dailyAvg;
                        tempCount++;
                        if(!array[5].equals("N/A") && dailyAvg >= -58 && dailyAvg <= 41) {
                                avgwndchl = 35.74 + (0.6215*dailyAvg) - (35.75*Math.pow(22.369*Double.parseDouble(array[5]),0.16))
                                + (0.4275*dailyAvg*Math.pow(22.369*Double.parseDouble(array[5]), 0.16));
                                chillCount++;
                        }
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
