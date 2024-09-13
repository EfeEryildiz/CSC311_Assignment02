package org.example.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class LoanCalculatorApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * Create text fields for the input values and output values
         */
        TextField tfInterestRate = new TextField();
        TextField tfNumberOfYears = new TextField();
        TextField tfLoanAmount = new TextField();
        TextField tfMonthlyPayment = new TextField();
        TextField tfTotalPayment = new TextField();

        /**
         * Set the default values for the input fields
         */
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);

        /**
         * Create a button to calculate the monthly and total payments
         */
        Button btCalculate = new Button("Calculate");

        /**
         * Create a GridPane to organize the input fields, labels, and button
         */
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        /**
         *  Add the input fields, labels, and button to the grid pane
         */
        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(tfInterestRate, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment:"), 0, 3);
        gridPane.add(tfMonthlyPayment, 1, 3);
        gridPane.add(new Label("Total Payment:"), 0, 4);
        gridPane.add(tfTotalPayment, 1, 4);
        gridPane.add(btCalculate, 1, 5);

        /**
         *  Event handler for Calculate button
         */
        btCalculate.setOnAction(e -> {

            /**
             * Get the input values from the text fields
             */
            double interestRate = Double.parseDouble(tfInterestRate.getText());
            int numberOfYears = Integer.parseInt(tfNumberOfYears.getText());
            double loanAmount = Double.parseDouble(tfLoanAmount.getText());

            /**
             * Calculate the monthly and total payments
             */
            double monthlyInterestRate = interestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate /
                    (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;

            /**
             * Display the results in the output fields
             */
            tfMonthlyPayment.setText(String.format("$%.2f", monthlyPayment));
            tfTotalPayment.setText(String.format("$%.2f", totalPayment));
        });

        /**
         * Create a scene and place it in the stage
         */
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}