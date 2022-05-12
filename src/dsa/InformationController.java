/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author suzan63
 */
public class InformationController implements Initializable {

    static String name;
    
    @FXML
    private Label notations;

    @FXML
    private ImageView image;
    
    @FXML
    private Label title;

    @FXML
    private Label txt;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        System.out.println("ALGO: "+ name);
        title.setText(name +" Sort");
        
        
        switch(name){
            case "Insertion":
                txt.setText("Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.");
                notations.setText("Worst case: O(n^2)      Average case: O(n^2)     Best case: O(n)");
                break;
            case "Merge":
                txt.setText("Merge sort is an efficient, general-purpose, and comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the order of equal elements is the same in the input and output.");
                notations.setText("Worst case: O(n log(n))      Average case: O(n log(n))     Best case: O(n log(n))");
                break;
            case "Heap":
                txt.setText("Heap sort is a comparison-based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the minimum element and place the minimum element at the beginning.");
                notations.setText("Worst case: O(n log(n))      Average case: O(n log(n))     Best case: O(n log(n))");
                break;
            case "Counting":
                txt.setText("Counting sort is a sorting technique based on keys between a specific range. It works by counting the number of objects having distinct key values (kind of hashing). Then doing some arithmetic to calculate the position of each object in the output sequence.");
                notations.setText("Worst case: O(n+k)      Average case: O(n+k)     Best case: O(n+k)");
                break;
            case "Radix":
                txt.setText("Radix sort is a non-comparative sorting algorithm. It avoids comparison by creating and distributing elements into buckets according to their radix.");
                notations.setText("Worst case: O(nk)      Average case: O(nk)     Best case: O(nk)");
                break;
            case "Quick":
                txt.setText("Quicksort is an in-place sorting algorithm. Developed by British computer scientist Tony Hoare in 1959 and published in 1961, it is still a commonly used algorithm for sorting. When implemented well, it can be somewhat faster than merge sort and about two or three times faster than heapsort.");
                notations.setText("Worst case: O(n^2)      Average case: O(n log(n))     Best case: O(n log(n))");
                break;
            case "Bubble":
                txt.setText("Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.");
                notations.setText("Worst case: O(n^2)      Average case: O(n^2)     Best case: O(n)");
                break;
            default:
                System.out.println("Error in Information");
        }
        
        
    }    

    public void setName(String name) {
        InformationController.name = name;
    }
        
    
    
    
}
