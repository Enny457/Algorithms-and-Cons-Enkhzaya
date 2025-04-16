package cakeovenapp;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author ennyy
// Represents a Cake with name, weight, best before date, and time it was added
public class Cake {
    private String name;
    private int weight;
    private LocalDate bestBefore;
    private LocalDateTime addedTime;
// Constructor to intialize a new cake object
    public Cake(String name, int weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.addedTime = LocalDateTime.now(); 
// Auto set the time when the cakes added
    }
//Getters
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
// Added toString for displaying the cake nicelyyy
    @Override
    public String toString() {
        return name + " (" + weight + "g, Best Before: " + bestBefore + ", Added: " + addedTime + ")";
    }
}
