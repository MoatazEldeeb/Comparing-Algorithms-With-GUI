
package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.swap;


public class Algorithm {
    private double timeTaken;
    private double numberOfSteps;
    private String name;
    
    
    
    public Algorithm() {
    }

    public Algorithm(String name) {
        this.name = name;
        
    }
 
    public void sort(ArrayList<Integer> Array){
        double time1,time2;
                
        switch (name)
        {
            case "Insertion":
                
                numberOfSteps=insertionSortSteps(Array);
                
                break;
            case "Merge":
                
                numberOfSteps= mergeSortSteps(Array, 0, Array.size()-1);
                
                break;
            
            case "Radix":
                 
                numberOfSteps=radixSortSteps(Array, Array.size());
                 
                break;
            case "Counting":
                 
                numberOfSteps=countingSortSteps(Array,10000);
                break;    
            case "Quick":
                 
                numberOfSteps=quickSortSteps(Array,0,Array.size()-1);
                break; 
            case "Bubble":
                
                numberOfSteps=bubbleSortSteps(Array);
                break;     
            case "Heap":
                numberOfSteps=heapSortSteps(Array);
                break;
                
//            case "Insertion":
//                time1 = System.nanoTime();
//                insertionSort(Array);
//                time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;
//            case "Merge":
//                time1 = System.nanoTime();
//                mergeSort(Array, 0, Array.size()-1);
//                 time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;
//            case "Heap":
//                 time1 = System.nanoTime();
//                heapSort(Array);
//                 time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;
//            case "Radix":
//                 time1 = System.nanoTime();
//                radixSort(Array, Array.size());
//                 time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;
//            case "Counting":
//                 time1 = System.nanoTime();
//                countingSort(Array,10000);
//                 time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;    
//            case "Quick":
//                 time1 = System.nanoTime();
//                quickSort(Array,0,Array.size()-1);
//                 time2 = System.nanoTime();
//                timeTaken=(time2-time1)/1000000;
//                break;    
            default:System.err.println("Sort Not Available");
        }
            
                
        
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfSteps() {
        return numberOfSteps;
    }

    public void setNumberOfSteps(double numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }
    
    
    
    
    public static void insertionSort(ArrayList<Integer> Array) {
    for (int i = 1; i < Array.size(); i++) {
        int key=Array.get(i);
        int j=i-1;
        while(j>=0 && key<Array.get(j))
        {
            
            Array.set(j+1, Array.get(j));
            j--;
        }
        Array.set(j+1,key);
    }
}
    
    public static double insertionSortSteps(ArrayList<Integer> Array) {
        double s=0;
    for (int i = 1; i < Array.size(); i++) {
        int key=Array.get(i);
        int j=i-1;
        while(j>=0 && key<Array.get(j))
        {
            Array.set(j+1, Array.get(j));
            j--;
            s+=2;
        }
        Array.set(j+1,key);
        s+=3;
    }
    return s;
}
    
    public static double mergeSteps(ArrayList<Integer> array,int l,int m,int r)
    {
        double s1=0;
        int i, j, k, nl, nr;
        //size of left and right sub-arrays
        nl = m-l+1; nr = r-m;
        
        ArrayList<Integer> larr =new ArrayList<Integer>();
        ArrayList<Integer> rarr =new ArrayList<Integer>();
        
        //fill left and right sub-arrays
        for(i = 0; i<nl; i++){
            larr.add(array.get(l+i));
            s1++;
        }
        for(j = 0; j<nr; j++){
            rarr.add(array.get(j+m+1));
            s1++;
        }

        larr.add(999999);
        rarr.add(999999);
        
        i = 0; j = 0;
        //merge temp arrays to real array
        for(k=l;k<=r;k++)
        {
            if(larr.get(i) <= rarr.get(j)){
                array.set(k, larr.get(i));
                i++;
                s1+=2;
            }
            else{
                array.set(k, rarr.get(j));
                j++;
                s1+=2;
            }
        }
        s1+=3;
        return s1;

    }
    
    public static double mergeSortSteps(ArrayList<Integer> array, int l, int r) {
        double s=0;
        if(l < r) {
        int m = l+(r-l)/2;
        // Sort first and second arrays
        s+=mergeSortSteps(array, l, m);
        s+=mergeSortSteps(array, m+1, r);
        s+=mergeSteps(array, l, m, r);
        }
        return s;
    }
    
    public static void merge(ArrayList<Integer> array,int l,int m,int r)
    {
        int i, j, k, nl, nr;
        //size of left and right sub-arrays
        nl = m-l+1; nr = r-m;
        
        ArrayList<Integer> larr =new ArrayList<Integer>();
        ArrayList<Integer> rarr =new ArrayList<Integer>();
        
        //fill left and right sub-arrays
        for(i = 0; i<nl; i++)
            larr.add(array.get(l+i));
        for(j = 0; j<nr; j++)
            rarr.add(array.get(j+m+1));

        larr.add(999999);
        rarr.add(999999);
        
        i = 0; j = 0;
        //merge temp arrays to real array
        for(k=l;k<=r;k++)
        {
            if(larr.get(i) <= rarr.get(j)){
                array.set(k, larr.get(i));
                i++;
            }
            else{
                array.set(k, rarr.get(j));
                j++;
            }
        }
        

    }
    
    public static void mergeSort(ArrayList<Integer> array, int l, int r) {
        
        if(l < r) {
        int m = l+(r-l)/2;
        // Sort first and second arrays
        mergeSort(array, l, m);
        mergeSort(array, m+1, r);
        merge(array, l, m, r);
        }
    }
    
//    public static int mergeSteps(ArrayList<Integer> array,int l,int m,int r)
//    {
//        int s1=0;
//        int i, j, k, nl, nr;
//        //size of left and right sub-arrays
//        nl = m-l+1;
//        nr = r-m;
//        
//        ArrayList<Integer> larr =new ArrayList<Integer>();
//        ArrayList<Integer> rarr =new ArrayList<Integer>();
//        
//        //fill left and right sub-arrays
//        for(i = 0; i<nl; i++){
//            larr.add(array.get(l+i));
//            s1++;
//        }
//            for(j = 0; j<nr; j++){
//            rarr.add(array.get(j+m+1));
//            s1++;
//        }
//        larr.add(999999);
//        rarr.add(999999);
//        
//        i = 0; j = 0;
//        //merge temp arrays to real array
//        for(k=l;k<=r;k++)
//        {
//            if(larr.get(i) <= rarr.get(j)){
//                array.set(k, larr.get(i));
//                i++;
//                s1+=2;
//            }
//            else{
//                array.set(k, rarr.get(j));
//                j++;
//                s1+=2;
//            }
//        }
//        s1+=8;
//        return s1;
//    }
//    
//    public static int mergeSortSteps(ArrayList<Integer> array, int l, int r) {
//        int s=0;
//        if(l < r) {
//        int m = l+(r-l)/2;
//        // Sort first and second arrays
//        s+=mergeSortSteps(array, l, m);
//        s+=mergeSortSteps(array, m+1, r);
//        s+=mergeSteps(array, l, m, r);
//        }
//        s+=2;
//        return s;
//    }

    public static void heapSort(ArrayList<Integer> arr)
    {
        int n = arr.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    }
    
    public static void maxHeapify(ArrayList<Integer> arr, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr.get(l) > arr.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }
    
    public static double heapSortSteps(ArrayList<Integer> arr)
    {
        double s=0;
        int n = arr.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            s+=maxHeapifySteps(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // call max heapify on the reduced heap
            s+=maxHeapifySteps(arr, i, 0);
        }
        return s;
    }
    
    public static double maxHeapifySteps(ArrayList<Integer> arr, int n, int i)
    {
        double s=0;
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr.get(l) > arr.get(largest)){
            largest = l;
            s++;
        }

        // If right child is larger than largest so far
        if (r < n && arr.get(r) > arr.get(largest)){
            largest = r;
            s++;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            s+=3;
            // Recursively heapify the affected sub-tree
            s+=maxHeapifySteps(arr, n, largest);
        }
        return s;
    }
    
    static int getMax(ArrayList<Integer> arr)
    {
        Integer maximum = arr.get(0);
        for (int i = 1; i < arr.size(); i++){
            if (arr.get(i) > maximum)
                maximum = arr.get(i);
        }
        return maximum;
    }
    
    static void countSort(ArrayList<Integer> arr, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr.get(i) / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr.get(i) / exp) % 10] - 1] = arr.get(i);
            count[(arr.get(i) / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr.set(i, output[i]);
    }
    
    static void radixSort(ArrayList<Integer> arr, int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    static double countSortSteps(ArrayList<Integer> arr, int n, int exp)
    {
        double s1=0;
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++){
            count[(arr.get(i) / exp) % 10]++;
            s1++;
        }
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
            s1++;
        }
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr.get(i) / exp) % 10] - 1] = arr.get(i);
            count[(arr.get(i) / exp) % 10]--;
            s1+=2;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++){
            arr.set(i, output[i]);
            s1++;
        }
        s1+=4;
        return s1;
    }
    
    static double radixSortSteps(ArrayList<Integer> arr, int n)
    {
        double s=0;
        // Find the maximum number to know number of digits
        int m = 10000;
        
        
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            s+=countSortSteps(arr, n, exp);
        return s;
    }
    
    static void countingSort(ArrayList<Integer> arr,int max)
    {
        int n = arr.size();
 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[max];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr.get(i)];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= max-1; ++i)
            count[i] += count[i - 1];
 
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.get(i)] - 1] = arr.get(i);
            --count[arr.get(i)];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr.set(i, output[i]);
    }
    
    static double countingSortSteps(ArrayList<Integer> arr,int max)
    {
        double s=0;
        int n = arr.size();
 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[max];
        for (int i = 0; i < max; ++i){
            count[i] = 0;
            s++;
        }
            
 
        // store count of each character
        for (int i = 0; i < n; ++i){
            ++count[arr.get(i)];
            s++;
        }
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= max-1; ++i){
            count[i] += count[i - 1];
            s++;
        }
 
        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr.get(i)] - 1] = arr.get(i);
            --count[arr.get(i)];
            s++;
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i){
            arr.set(i, output[i]);
            s++;
        }
        s+=3;
        return s;
    }
    
    static double quickSortSteps(ArrayList<Integer> arr, int low, int high)
    {
        double s=0;
        if (low < high) 
        {
            // pi is partitioning index, arr[p]
            // is now at right place 
            int pi = partition(arr, low, high);
            s+= (pi - low + 1);
            // Separately sort elements before
            // partition and after partition
            s+= quickSortSteps(arr, low, pi - 1);
            s+= quickSortSteps(arr, pi + 1, high);
        }
        return s;
    }
    
    static int partition(ArrayList<Integer> arr, int low, int high)
    {
        // pivot
        int pivot = arr.get(high); 

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1); 

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller 
            // than the pivot
            if (arr.get(j) < pivot) 
            {

                // Increment index of 
                // smaller element
                i++; 
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void quickSort(ArrayList<Integer> arr, int low, int high)
    {
        if (low < high) 
        {

            // pi is partitioning index, arr[p]
            // is now at right place 
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
   
    private void bubbleSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr.get(j) > arr.get(j+1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
    }
    private double bubbleSortSteps(ArrayList<Integer> arr)
    {
        double s=0;
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++){
                if (arr.get(j) > arr.get(j+1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                    s+=3;
                }
                
            }
        s++;
        return s;
    }
    
}
