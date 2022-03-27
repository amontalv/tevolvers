package co.tevolvers.reto.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitInteraction implements Interaction {

    private int var;

    protected WaitInteraction(int var) {
        this.var = var;
    }

    public static WaitInteraction waitClass(int var) {
        return instrumented(WaitInteraction.class, var);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(var);
    }
}
