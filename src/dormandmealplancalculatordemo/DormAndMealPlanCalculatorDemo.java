/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dormandmealplancalculatordemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 *
 * @author orlandomarin
 */

/*
DIRECTIONS IN BLACKBOARD:
Using constructs from this chapter or earlier, complete either:
Programming Challenges #1, Dorm and Meal Plan Calculator, OR
Programming Challenges #2, Skateboard Designer.
State which programming challenge you are submitting. In addition to your
program running correctly, you will be graded on: 
Use of comments. Your program needs to be properly commented.
Use of appropriate variable names.
Use of proper formatting of your output.
Your GUI layout.
Each class should be in a separate file (except for event listeners).
When you're done, find the source files in the project directory, find your
java files there and attach them to this assignment. You also need to include
a screenshot of the results. Your screenshot needs to display your name
somewhere in the results.
*/

/*
INSTRUCTIONS FROM BOOK (Dorm and Meal Plan Calculator)
A university has the following dormitories: 
Allen Hall: $1,800 per semeester
Pike Hall: $2,200 per semester
Farthing Hall: $2,800 per semester
University Suites: $3,000 per semester
The university also offers the following meal plans:
7 meals per week: $600 per semester
14 meals per week: $1,100 per semester
Unlimited meals: $1,800 per semester
Create an application with 2 ComboBox controls. One should hold the names of
the dormitories, and the other should hold the meal plans. The user should
select a dormitory and a meal plan, and the application should show the total
charges for the semester.
*/
public class DormAndMealPlanCalculatorDemo extends Application
{
    // String variables for dorms
    final String allenHall = "Allen Hall: $1,800 per semester";
    final String pikeHall = "Pike Hall: $2,200 per semester";
    final String farthingHall = "Farthing Hall: $2,800 per semester";
    final String universitySuites = "University Suites: $3,000 per semester";
    
    // String variables for meal plans
    final String sevenMeals = "7 meals per week: $600 per semester";
    final String fourteenMeals = "14 meals per week: $1,100 per semester";
    final String unlimitedMeals = "Unlimited meals: $1,800 per semester";
    
    // Double variables for dorm prices
    final double allenHallPrice = 1800.00;
    final double pikeHallPrice = 2200.00;
    final double farthingHallPrice = 2800.00;       
    final double universitySuitesPrice = 3000.00;
    
    // Double variables for meal plan prices
    final double sevenMealsPrice = 600.00;
    final double fourteenMealsPrice = 1100.00;
    final double unlimitedMealsPrice = 1800.00;
    
    // Double variables for the dorm, meal plan, and total cost
    double dormCost;
    double mealPlanCost;
    double totalCost;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // launch the application
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage)
    {
    
        // set the stage title
        primaryStage.setTitle("Dorm and Meal Plan Calculator");
        
        // MESSAGES
        // Create a message welcoming students to Java University
        Label welcomeMessage = new Label("Welcome to Java University in Seattle, Washington!");
        
        // Create a message telling the user to pick a dormitory
        Label dormitoryMessage = new Label("Please select a dormitory below.");
        
        // Creeate a message asking the usere to pick a meal plan
        Label mealPlanMessage = new Label("Please select a meal plan below.");
        
        // Create a message that will show the total charges for the semester
        Label totalChargesMessage = new Label("Your total charges for the semester will appear here once you make your selections.");
        
        // COMBOBOXES
        // Create a dormitories ComboBox that lists the dormitory options
        ComboBox<String> dormitories = new ComboBox<>();
        dormitories.getItems().addAll(allenHall, pikeHall, farthingHall, universitySuites);
        
        // Create an event handler to calculate the dorm cost based on the user's selection
        // Calculate the total cost and display the total charges for the semester in an updated totalCharges message
        dormitories.setOnAction(event ->
        {
            if (dormitories.getValue().equals(allenHall))
            {
                dormCost = allenHallPrice;
            }
            else if (dormitories.getValue().equals(pikeHall))
            {
                dormCost = pikeHallPrice;
            }
            else if (dormitories.getValue().equals(farthingHall))
            {
                dormCost = farthingHallPrice;
            }
            else if (dormitories.getValue().equals(universitySuites))
            {
                dormCost = universitySuitesPrice;
            }
            else dormCost = 0.00;
            
            totalCost = dormCost + mealPlanCost;
            
            totalChargesMessage.setText(String.format("Your total for the semester is $%,.2f, Orlando Marin.", totalCost));
        });
        
        // Create a meal plans ComboBox that lists the meal plan options 
        ComboBox<String> mealPlans = new ComboBox<>();
        mealPlans.getItems().addAll(sevenMeals, fourteenMeals, unlimitedMeals);
        
        // Create an event handler to calculate the meal plan cost based on the user's selection
        // Calculate the total cost and display the total charges for the semester in an updated totalCharges message
        mealPlans.setOnAction(event ->
        {
            if (mealPlans.getValue().equals(sevenMeals))
            {
                mealPlanCost = sevenMealsPrice;
            }
            else if (mealPlans.getValue().equals(fourteenMeals))
            {
                mealPlanCost = fourteenMealsPrice;
            }
            else if (mealPlans.getValue().equals(unlimitedMeals))
            {
                mealPlanCost = unlimitedMealsPrice;
            }
            else mealPlanCost = 0.00;
            
            totalCost = dormCost + mealPlanCost;
            
            totalChargesMessage.setText(String.format("Your total for the semester is $%,.2f, Orlando Marin.", totalCost));
        });
        
        // create a vbox to add the messages and ComboBoxes and center everything
        VBox vbox = new VBox(30, welcomeMessage, dormitoryMessage, dormitories, mealPlanMessage, mealPlans, totalChargesMessage);
        vbox.setAlignment(Pos.CENTER);
        
        // create a scene with the vbox as its root node
        Scene scene = new Scene(vbox, 500, 400);
        
        // add the scene to the stage
        primaryStage.setScene(scene);
        
        // show the window
        primaryStage.show();
    }
    
}
