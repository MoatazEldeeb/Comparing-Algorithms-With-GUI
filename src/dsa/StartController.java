/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StartController implements Initializable {

    AlgorithmType a;
    
    protected Algorithm algo=new Algorithm();
    ArrayList<Integer> A =new ArrayList<>();
    
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox<AlgorithmType> selection1;
    
    @FXML
    private Slider slider;
    
    @FXML
    private TextField num;
    
    @FXML
    private Label error;
    
    @FXML
    private RadioButton fileRadio;

    @FXML
    public void sortbtn(ActionEvent event)throws FileNotFoundException,IOException {
        if(fileRadio.isSelected()){
            if(selection1.getValue() == null)
            {
                error.setText("Please select a sorting algorithm!");
            }
            else
            {
                
                algo.setName(((AlgorithmType)this.selection1.getValue()).toString());
                FileChooser fc = new FileChooser();
                File file = fc.showOpenDialog(null);
//                FileReader file = new FileReader("NUMBERS.txt");
                
                if(file != null)
                {
                    
                    Scanner s=new Scanner(file);
                    System.out.println("can read: "+file.canRead());
                    A.clear();
                    while (s.hasNextInt()) {
                        
                        A.add(s.nextInt());
                    }
                    printArray(A);
                    algo.sort(A);
                    
                    
                    PrintWriter pw =new PrintWriter(file);
                    
                    for(int i=0;i<A.size();i++)
                    {
                        pw.println(A.get(i));
                    }
                    pw.close();
                    
                    A.clear();
                }
            else{
                error.setText("File not Available");
            }
        }
        }
        else{
            if(num.getText().trim().isEmpty()){
                error.setText("Please Enter number of elements");
                System.out.println("Error");
            }
            else{
            System.out.println(num.getText());
            algo.setName(((AlgorithmType)this.selection1.getValue()).toString());
            int n= Integer.parseInt(num.getText());
            A= RandomArray(n);
            printArray(A);
            algo.sort(A);

            printArray(A);
            System.out.println(algo.getTimeTaken());
            label.setText(""+algo.getTimeTaken());
            }
        }
    }
    
    @FXML
    void plot(ActionEvent event) throws Exception{
        
        
        Stage userStage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        Pane root = (Pane) loader.load(getClass().getResource("Chart.fxml"));
        
        ChartController chartCtrl = new ChartController();
        loader.setController(chartCtrl);
        
        
        Scene scene = new Scene(root);
        userStage.setScene(scene);
        userStage.setTitle("Chart");
        userStage.show();
    }
    
    @FXML
    void info(ActionEvent event) throws Exception {
        if(selection1.getValue() == null){
            error.setText("Please select a sorting algorithm!");
                   
        }
        else{
            algo.setName(((AlgorithmType)this.selection1.getValue()).toString());
        Stage userStage = new Stage();

        InformationController infoCtrl = new InformationController();
        InformationController.name= ((AlgorithmType)this.selection1.getValue()).toString() ;
        
        FXMLLoader loader = new FXMLLoader();
        Pane root = (Pane) loader.load(getClass().getResource("Information.fxml"));
        
        
        loader.setController(infoCtrl);
        
        Scene scene = new Scene(root);
        userStage.setScene(scene);
        userStage.setTitle(algo.getName());
        userStage.show();
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.selection1.setItems(FXCollections.observableArrayList(AlgorithmType.values()));
    }    
    
    private static ArrayList<Integer> RandomArray(int n)
    {
        
        ArrayList<Integer> arrayRandom = new ArrayList<>(n);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0;i<n; i++)
        {
            Integer r = rand.nextInt(10000);
            arrayRandom.add(r);

        }
        return arrayRandom;
    }

    static void printArray(ArrayList<Integer> A)
    {
        int n=A.size();
        for(int i=0;i<n;i++)
        {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
    }
    
}
