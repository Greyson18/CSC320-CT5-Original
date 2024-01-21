import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Create ArrayLists to store days & temperatures
        ArrayList<String> weekDay = new ArrayList<>();
        ArrayList<Double> dailyTemperatures = new ArrayList<>();
       
        //Ask user to type in a day and temperature to go with it
        for (int i=0; i<7; i++){
            System.out.print("Enter the day of the week (Monday-Sunday): ");
            String day = scanner.nextLine();
            System.out.print("Enter the average temperature for " + day + ": ");
            double temperature = scanner.nextDouble();
            
            //Consume the newline character
            scanner.nextLine();
            
            //Adds the day and temperature to the previously initialized ArrayLists
            weekDay.add(day);
            dailyTemperatures.add(temperature);
        }
        
        //Create a menu to allow the user to look up temperature by day or look at information for the entire week
        while (true){
            System.out.print("Enter the day of the week (Monday-Sunday) or 'week' for weekly average: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("week")) {
                //calculate and display the weekly average temperature
                double weeklyAverage = calculateWeeklyAverage(dailyTemperatures);
                for (int i = 0; i < 7; i++) // For loop is necessary to print each of the days the temperatures that go with them
                {
                    //.get() method is used to retrieve the values from the arraylist
                    System.out.println("Temperature for " + weekDay.get(i) + " is " + dailyTemperatures.get(i));
                }
                System.out.println("Weekly Average Temperature: " + weeklyAverage);
            } 
            else if (weekDay.contains(input)) {
                //display the temperature for the specified day
                int index = weekDay.indexOf(input);
                double temperature = dailyTemperatures.get(index);
                System.out.println("Temperature for " + input + " is " + temperature);
            } 
            else {
                System.out.println("Invalid input. Please enter a valid day or 'week'.");
            }
            
            //ask the user if they want to continue or stop
            System.out.print("Do you want to check another day or 'week' (yes/no)? ");
            String continueInput = scanner.nextLine();
            if (!continueInput.equalsIgnoreCase("yes")){
                break;
            }
        }
        scanner.close();
    }

	//This is for the calculation of the weekly average from the earlier while loop
    private static double calculateWeeklyAverage(ArrayList<Double> temperatures){
        double sum = 0;
        for (double temperature : temperatures){
            sum += temperature;
        }
        return sum / temperatures.size();
	}
}