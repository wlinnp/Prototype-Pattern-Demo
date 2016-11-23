package edu.cpp.cs356.assign3.Prototype;

import edu.cpp.cs356.assign3.Characters.MatrixCharacter;
import edu.cpp.cs356.assign3.Characters.MovieCharacter;

import java.util.Map;
import java.util.HashMap;

/**
 * A cached class with pre existing characters.
 * This will create mostly used characters at the beginning of program and store in hash map.
 * Singleton class to avoid creating the same map multiple times.
 * <p>
 * @author wphyo
 */
public class CachedPrototype {
    private static CachedPrototype INSTANCE = null;
    private Map<String, MovieCharacter> allCharacters = new HashMap<String, MovieCharacter>();
    private CachedPrototype() {
        allCharacters.put("neo", new MatrixCharacter("Thomas A. Anderson", "The ONE", "http://carboncostume.com/wordpress/wp-content/uploads/2014/09/neo.jpg", 99, "I know kung fu"));
        allCharacters.put("smith", new MatrixCharacter("Agent Smith", "Agent", "http://dreamcatcherreality.com/wp-content/uploads/2015/07/Agent-Smith-Matrix-Replicas-Drones.png", 70, "Never send a human to do a machine's job"));
    }

    public static CachedPrototype getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CachedPrototype();
        }
        return INSTANCE;
    }

    public MovieCharacter getClonedCharacter(final String name) {
        return allCharacters.get(name).getClone();
    }

    public MovieCharacter getCharacter(final String name) {
        return allCharacters.get(name);
    }

}
