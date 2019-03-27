import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;

public class Drop implements Node {


    @Override
    public boolean validate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Item i : Inventory.getItems()) {
            if(i != null && i.getName().contains("Raw") && i.interact("Drop")) {
                Time.sleep(75);
            }
        }
    }
}
