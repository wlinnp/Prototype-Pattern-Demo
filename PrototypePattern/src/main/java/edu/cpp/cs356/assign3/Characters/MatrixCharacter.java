package edu.cpp.cs356.assign3.Characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * A movie character class with basic features.
 * Since this is for demo purpose only, there are no set features to update the properties after creation.
 * <p>
 * @author wphyo
 */
public class MatrixCharacter implements MovieCharacter {
    private String name;
    private String nickName;
    private Image avatar;
    private String avatarURL;
    private int powerLevel;
    private String catchPhrase;

    public MatrixCharacter(String name, String nickName, String avatarURL, int powerLevel, String catchPhrase) {
        this.name = name;
        this.nickName = nickName;
        this.avatarURL = avatarURL;
        this.avatar = downloadImage(avatarURL);
        this.powerLevel = powerLevel;
        this.catchPhrase = catchPhrase;
    }

    private Image downloadImage(final String avatarURL) {
        Image image = null;
        try {
            URL url = new URL(avatarURL);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public Image getAvatar() {
        return avatar;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public MovieCharacter getClone() {
        try {
            return (MatrixCharacter)super.clone();

        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name is ").append(name).append("\n");
        result.append("NickName is ").append(nickName).append("\n");
        result.append("Power Level is ").append(powerLevel).append("\n");
        result.append("Catch Phrase is ").append(catchPhrase).append("\n");
        return result.toString();
    }
}
