package components;

import java.awt.*;
import java.util.HashMap;

public enum ColorEnum {
    RED("Red", Color.red), GREEN("Green",Color.GREEN), BLUE("Blue",Color.blue),
    YELLOW("Yellow",Color.yellow), CYAN("Cyan",Color.cyan), GRAY("Gray",Color.gray),
    MAGENTA("Magenta",Color.magenta), ORANGE("Orange",Color.orange),
    PINK("Pink", Color.pink), WHITE("White", Color.white),
    DARK_GRAY("Dark gray",Color.darkGray), BLACK("Black",Color.black);

    private String name;
    private Color color;
    private static HashMap<String, Color> colorMap = new HashMap<>();

    ColorEnum(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    static {
        for (ColorEnum colors : ColorEnum.values()){
            colorMap.put(colors.name,colors.color);
        }
    }
}
