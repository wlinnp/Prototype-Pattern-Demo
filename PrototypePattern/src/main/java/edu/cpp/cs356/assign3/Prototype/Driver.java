package edu.cpp.cs356.assign3.Prototype;

import edu.cpp.cs356.assign3.Characters.MatrixCharacter;
import edu.cpp.cs356.assign3.Characters.MovieCharacter;

import java.util.List;
import java.util.ArrayList;
/**
 * A driver which has 2 methods.
 * 1st method: creating copies by using prototype pattern.
 * 2nd method: creating copies by creating new instances.
 * <p>
 * Printing number of copies being created.
 * Printing memory address of new copies / instances to prove that they are new objects.
 * Printing total time for each method to compare.
 * <p>
 * NOTE: this class have code duplication which can be improve by using Command Pattern
 * <p>
 * @author wphyo
 */
public class Driver {
    public List<MovieCharacter> makeCopies(final int number, final String name) {
        List<MovieCharacter> copies = new ArrayList<MovieCharacter>();
        CachedPrototype cachedPrototype = CachedPrototype.getInstance();
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++) {
            MovieCharacter clonedCharacter = cachedPrototype.getClonedCharacter(name);
            System.out.println(i + ": " + ((MatrixCharacter)clonedCharacter).getCatchPhrase());
            System.out.println(System.identityHashCode(clonedCharacter));
            copies.add(clonedCharacter);
        }
        long endTime = System.nanoTime();
        System.out.println("making " + number + " of clones take " + (endTime - startTime) + " nanoseconds");
        return copies;
    }

    public List<MovieCharacter> makeNewInstances(final int number, final String name) {
        List<MovieCharacter> copies = new ArrayList<MovieCharacter>();
        CachedPrototype cachedPrototype = CachedPrototype.getInstance();
        long startTime = System.nanoTime();
        for (int i = 0; i < number; i++) {
            MatrixCharacter character = (MatrixCharacter)cachedPrototype.getCharacter(name);
            MatrixCharacter newCharacter = new MatrixCharacter(character.getName(), character.getNickName(), character.getAvatarURL(), character.getPowerLevel(), character.getCatchPhrase());
            System.out.println(i + ": " + newCharacter.getCatchPhrase());
            System.out.println(System.identityHashCode(newCharacter));
            copies.add(newCharacter);
        }
        long endTime = System.nanoTime();
        System.out.println("making " + number + " of clones take " + (endTime - startTime) + " nanoseconds");
        return copies;
    }
}
