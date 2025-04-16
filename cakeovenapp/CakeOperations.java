/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;

/**
 *
 * @author ennyy
 */
  public interface CakeOperations {
    void addCake(Cake cake);
    Cake removeCake();
    Cake peekCake();
    boolean isFull();
    boolean isEmpty();
    void displayCakes();
}
  
