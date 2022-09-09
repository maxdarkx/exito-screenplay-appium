package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.tasks.ScrollTask.scroll;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_ADD_ADDRESS;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_CHOOSE_CITY;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_SEND_TO_HOME;
import static co.com.sofka.certification.userinterfaces.SendToUI.ET_ADDRESS;
import static co.com.sofka.certification.userinterfaces.SendToUI.TV_CHOOSE_CITY;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import co.com.sofka.certification.models.Cities;

public class EnterAdressTask implements Task {
    private String city;
    private String address;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BT_SEND_TO_HOME),
                Click.on(BT_CHOOSE_CITY),
                scroll().lookingFor(city),
                Click.on(TV_CHOOSE_CITY.of(city)),
                Enter.theValue(address).into(ET_ADDRESS),
                Click.on(BT_ADD_ADDRESS)
        );
    }

    public static EnterAdressTask enterAdress() {
        return new EnterAdressTask();
    }

    public EnterAdressTask withCity(String city) {
        Cities enumCityes = Cities.valueOf(city);
        this.city = enumCityes.getCityName();
        return this;
    }

    public EnterAdressTask andAdress(String address) {
        this.address = address;
        return this;
    }
}
