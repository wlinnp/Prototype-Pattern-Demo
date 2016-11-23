package edu.cpp.cs356.assign3;

import edu.cpp.cs356.assign3.Prototype.Driver;

/**
 * Main class calling driver and create 50 copies of same copies
 * first by using prototype pattern, using clones.
 * second by creating new instances each time.
 * <p>
 * @author wphyo
 */
public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.makeCopies(50, "smith");
        driver.makeNewInstances(50, "smith");
    }
}
