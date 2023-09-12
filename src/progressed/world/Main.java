package progressed.world;

import arc.*;
import arc.audio.Sound;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;

import java.util.Random;

public class Main extends Plugin {
    @Override
    public void init() {
        Sound sam_ow;
        Sound sam_im_hurt;
        Sound sam_ouch;

        sam_ow = Vars.tree.loadSound("sam-ow");
        sam_ouch = Vars.tree.loadSound("sam-ouch");
        sam_im_hurt = Vars.tree.loadSound("sam-im-hurt");

        Events.on(UnitDamageEvent.class, e -> {
            if (!e.unit.isPlayer()) return;
            if (!String.valueOf(e.unit.type()).equals("dagger")) return;

            Random rand = new Random();
            int num = rand.nextInt(3);

            if (num == 0) sam_ow.at(e.unit.x, e.unit.y);
            else if (num == 1) sam_ouch.at(e.unit.x, e.unit.y);
            else if (num == 2) sam_im_hurt.at(e.unit.x, e.unit.y);
        });
    }
}