import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;


@ScriptMeta(desc = "fishes things", developer = "blake", name = "Powerfisher")


public class Powerfisher extends Script {

    private final Node[] nodes = new Node[] {new Fish(), new Drop()};

    public static FishData fishData;



    @Override
    public void onStart() {
        new GUI().setVisible(true);
    }


    @Override
    public int loop() {

        if(fishData != null) {
            for (Node node : nodes) {
                final Node n = node;
                if (n.validate()) {
                    n.execute();
                    break;
                }
            }
        } else {
            Log.info("fish is null");
        }

        return Random.nextInt(400,600);
    }
}
