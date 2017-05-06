/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author aleksandrpasharin
 * @param <T> any class
 */
public class IteratorThreadA<T> extends Thread{
    
    private final Iterator<T> iterator;
    private final String name;
    
    public IteratorThreadA(Iterable<T> collection, String name){
        this.iterator = collection.iterator();
        this.name = name;
    }
    
    @Override
    public void run(){
       while(this.iterator.hasNext()){
           System.out.println("Iterator " + this.name + ": next element is " + this.iterator.next());
       }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> collection = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        
        IteratorThreadA<Integer> it1 = new IteratorThreadA<>(collection, "1");
        IteratorThreadA<Integer> it2 = new IteratorThreadA<>(collection, "2");
        
        it1.start();
        it2.start();
    }
    
    
}
 
