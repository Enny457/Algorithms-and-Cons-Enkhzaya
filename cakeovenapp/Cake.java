/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author ennyy
 */
public class Cake {
    private String name;
    private int weight;
    private LocalDate bestBefore;
    private LocalDateTime addedTime;

    public Cake(String name, int weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.addedTime = LocalDateTime.now(); // Auto timestamp
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "g, Best Before: " + bestBefore + ", Added: " + addedTime + ")";
    }
}
