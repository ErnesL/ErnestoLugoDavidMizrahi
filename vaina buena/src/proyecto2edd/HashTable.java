/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author davidmizrahi
 */
public class HashTable <T>{
    
    private HashNode[] bucketArray;
    
    private int capacity;
    
    private int size;
    
   
    public HashTable(int capacity){
    
        this.capacity = capacity;
        
        this.bucketArray = new HashNode[this.capacity];
        
        this.size = 0;
    }

    public HashNode[] getBucketArray() {
        return bucketArray;
    }

    public void setBucketArray(HashNode[] bucketArray) {
        this.bucketArray = bucketArray;
    }

    

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //METODOS PRIMITIVOS
    public boolean isEmpty(){
    
        return size == 0;
    }
    public int stringtoNum(String s){
    
        int ascii = 0;
        
        String str = s;
  
        // Creating array of string length
        // using length() method
        char[] ch = new char[str.length()];
  
        // Copying character by character into array
        // using for each loop
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
//        char character = 'a';   
        for (int i = 0; i < ch.length; i++) {
            
             ascii += (int) ch[i];
            
        }
        return ascii;
    }
    public int getBucketIndex(int key){
    
        int index = key % this.capacity;
        
        return index;
    
        
    }
    public void put_listas(Nodo art, T value){
    
        int key = stringtoNum(art.getInfo().toString());

        int bucketIndex = getBucketIndex(key);
            System.out.println(bucketIndex);

        HashNode head = bucketArray[bucketIndex];
        
        while(head != null){
        
            if(head.getKey() == key){
            
                head.setValue(value);
                
                return;
            }
            head = head.getNext();
        }
        size++;
        head = bucketArray[bucketIndex];
        
        HashNode<T> node = new HashNode<>(key, value);
        
        node.setNext(head);
        bucketArray[bucketIndex] = node;
    
    }
    public void put(Articulo articulo, T value){
        
        int key = stringtoNum(articulo.getTitulo());

        int bucketIndex = getBucketIndex(key);
            System.out.println(bucketIndex);

        HashNode head = bucketArray[bucketIndex];
        
        while(head != null){
        
            if(head.getKey() == key){
            
                head.setValue(value);
                
                return;
            }
            head = head.getNext();
        }
        size++;
        head = bucketArray[bucketIndex];
        
        HashNode<T> node = new HashNode<>(key, value);
        
        node.setNext(head);
        bucketArray[bucketIndex] = node;
//        System.out.println(bucketArray[6].getValue());
        
    }
    
    
}
