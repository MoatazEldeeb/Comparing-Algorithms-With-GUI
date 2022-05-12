
package dsa;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;


public class ChartController implements Initializable {
    
    AlgorithmType a;
    
    Algorithm algo1 = new Algorithm();
    Algorithm algo2 = new Algorithm();
    
    ArrayList<Integer> A =new ArrayList<>();
    ArrayList<Integer> A1 =new ArrayList<>();
    
    
    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    private RadioButton opt1;

    @FXML
    private RadioButton opt2;
    
    @FXML
    private ToggleGroup tg;
    
    @FXML
    private TextField total;

    @FXML
    private TextField st;

    @FXML
    private Label error;

    @FXML
    private ComboBox<AlgorithmType> sel1;

    @FXML
    private ComboBox<AlgorithmType> sel2;
    
     @FXML
    void sel1Action(ActionEvent event) {
        this.sel2.setItems(FXCollections.observableArrayList(AlgorithmType.values()));
        sel2.getItems().remove(sel1.getValue());
    }
    @FXML
    void sel2Action(ActionEvent event) {
        this.sel1.setItems(FXCollections.observableArrayList(AlgorithmType.values()));
        sel1.getItems().remove(sel2.getValue());
    }

    @FXML
    void load(ActionEvent event) {
        chart.getData().clear();
        
        
        XYChart.Series<Number,Number> s= new XYChart.Series<>();
        XYChart.Series<Number,Number> s1= new XYChart.Series<>();
        
        if(total.getText().trim().isEmpty() && st.getText().trim().isEmpty()){
            this.error.setText("Please Enter number of elements and/or steps");
        }
        if(!opt1.isSelected()&& !opt2.isSelected()){
            this.error.setText("Please select an option");
        }
        else if(opt1.isSelected())
        {
            int totalN =Integer.parseInt(total.getText());
            int step =Integer.parseInt(st.getText());
            algo1.setName(((AlgorithmType)this.sel1.getValue()).toString());
            for(int i=0;i<=totalN;i+=step)
            {

                System.out.println("Name : "+ algo1.getName());
                algo1.sort(RandomArray(i));
                StartController.printArray(A);
                System.out.println(algo1.getNumberOfSteps());
                s.getData().add(new XYChart.Data<>(i,algo1.getNumberOfSteps()));
                switch(algo1.getName())
                {
                    case "Insertion":
                        s1.getData().add(new XYChart.Data<>(i,i*i));
                        break;
                    case "Counting":
                        s1.getData().add(new XYChart.Data<>(i,i+10000));
                        break;
                    case "Radix":
                        s1.getData().add(new XYChart.Data<>(i,(int)(i*(Math.log(i) / Math.log(2)))));
                        break;
                    case "Bubble":    
                        s1.getData().add(new XYChart.Data<>(i,i*i));
                        break;
                    case "Heap":
                        s1.getData().add(new XYChart.Data<>(i,(int)(i*(Math.log(i) / Math.log(2)))));
                        break;
                    case "Merge": 
                        s1.getData().add(new XYChart.Data<>(i,(int)(i*(Math.log(i) / Math.log(2)))));
                        break;
                    case "Quick": 
                        s1.getData().add(new XYChart.Data<>(i,(int)(i*(Math.log(i) / Math.log(2)))));
                        break;
                    default:
                        System.out.println("Error while configuring sort type!");

                }
                s.setName(algo1.getName());
                s1.setName("f(n)");
            }   
        }else if(opt2.isSelected())
        {
            int totalN =Integer.parseInt(total.getText());
            int step =Integer.parseInt(st.getText());
            
            for(int j=0;j<totalN;j+=step)
            {
                algo1.setName(((AlgorithmType)this.sel1.getValue()).toString());
                algo2.setName(((AlgorithmType)this.sel2.getValue()).toString());
                A = RandomArray(j);
                A1=RandomArray(j);
                
                algo2.sort(A1);
                algo1.sort(A);
                s.getData().add(new XYChart.Data<>(j,algo1.getNumberOfSteps()));
                s1.getData().add(new XYChart.Data<>(j,algo2.getNumberOfSteps()));
            }
            s.setName(algo1.getName());
            s1.setName(algo2.getName());
        }
        
        chart.getData().add(s);
        chart.getData().add(s1);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        this.sel1.setItems(FXCollections.observableArrayList(AlgorithmType.values()));
        this.sel2.setItems(FXCollections.observableArrayList(AlgorithmType.values()));
    }
    
    private static ArrayList<Integer> RandomArray(int n)
    {

        ArrayList<Integer> arrayRandom = new ArrayList<>(n);
        arrayRandom.clear();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++)
        {
            Integer r = rand.nextInt(10000);
            arrayRandom.add(r);
        }
        return arrayRandom;
    }

}
