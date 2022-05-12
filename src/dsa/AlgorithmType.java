
package dsa;

public enum AlgorithmType {
    Insertion,Merge,Heap,Radix,Counting,Quick,Bubble;
    
    private AlgorithmType(){
        
    }
    public String value(){
        return name();
    }
    public static AlgorithmType fromvalue(String v){
        return valueOf(v);
    }
}
