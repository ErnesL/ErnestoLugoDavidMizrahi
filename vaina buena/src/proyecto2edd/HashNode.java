/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2edd;

/**
 *
 * @author davidmizrahi
 */
public class HashNode<T> {
    
    private int key;
    
    private T value;
    
    private HashNode<T> next;
    
    public HashNode(int key, T value){
    
        this.key = key;
        
        this.value = value;
        
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HashNode<T> getNext() {
        return next;
    }

    public void setNext(HashNode<T> next) {
        this.next = next;
    }
    
}
