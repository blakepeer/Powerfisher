import org.rspeer.runetek.api.movement.position.Position;

public enum FishData {

    SHRIMPS_ANCHOVIES(new Position(3240,3153), "Net", new String[]{"Small fishing net"}, 1),
    SARDINE_HERRING(new Position(3240,3153), "Bait", new String[]{"Fishing rod", "Bait"}, 5),
    TROUT_SALMON(new Position(3242,3246), "Lure", new String[]{"Fly fishing rod", "Feather"}, 20);


    private final Position position;

    private final String action;

    private final String[] requiredItems;

    private final int requiredLevel;


    FishData(final Position position, final String action, final String[] requiredItems, final int requiredLevel){
        this.position = position;
        this.action = action;
        this.requiredItems = requiredItems;
        this.requiredLevel = requiredLevel;
    }

    public Position getPosition() {
        return position;
    }

    public String getAction() {
        return action;
    }

    public String[] getRequiredItems() {
        return requiredItems;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

}
