/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author ennyy
 */
public class CakeOven implements CakeOperations {
    private final int MAX_CAPACITY = 5;
    private Queue<Cake> oven;

    public CakeOven() {
        oven = new LinkedList<>();
    }

    @Override
    public void addCake(Cake cake) {
        if (isFull()) {
            System.out.println("Oven is full. Cannot add more cakes.");
        } else {
            oven.add(cake);
            System.out.println("Cake added: " + cake);
        }
    }

    @Override
    public Cake removeCake() {
        if (isEmpty()) {
            System.out.println("Oven is empty.");
            return null;
        }
        Cake removed = oven.poll();
        System.out.println("Cake removed: " + removed);
        return removed;
    }

    @Override
    public Cake peekCake() {
        return oven.peek();
    }

    @Override
    public boolean isFull() {
        return oven.size() >= MAX_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return oven.isEmpty();
    }

    @Override
    public void displayCakes() {
        if (isEmpty()) {
            System.out.println("No cakes in the oven.");
        } else {
            System.out.println("Cakes currently in oven:");
            for (Cake cake : oven) {
                System.out.println(cake);
            }
        }
    }

public int getRemainingCapacity() {
        return MAX_CAPACITY - oven.size();
    }

    public Queue<Cake> getCakes() {
        return oven;
    }
}
