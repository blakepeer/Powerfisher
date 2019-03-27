import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Dialog;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Position;
import org.rspeer.runetek.api.scene.Npcs;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.ui.Log;

public class Fish implements Node {


    @Override
    public boolean validate() {
        return !Inventory.isFull();
    }

    @Override
    public void execute() {
        final Position position = Powerfisher.fishData.getPosition();
        final String action = Powerfisher.fishData.getAction();
        Log.info("Fish");
        if(Npcs.getNearest(x -> x.getName().equals("Fishing spot") && x.containsAction(action)) == null) {
            Movement.walkTo(position.randomize(2));
        } else if((Players.getLocal().getTarget() == null || Dialog.isOpen() && Npcs.getNearest(x -> x.getName().equals("Fishing spot") && x.containsAction(action)) != null)
                && Npcs.getNearest(x -> x.getName().equals("Fishing spot") && x.containsAction(action)).interact(action)) {
            Time.sleepUntil(() -> Players.getLocal().isAnimating(), 200, Random.nextInt(3000,4000));
        }
    }
}
