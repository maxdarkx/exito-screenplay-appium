package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.tasks.ScrollToElementTask.scrollToElement;
import static co.com.sofka.certification.tasks.SelectTheFirstStoreAvailableTask.selectTheFirstStoreAvailable;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_CHOOSE_CITY;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_CONTINUE;
import static co.com.sofka.certification.userinterfaces.SendToUI.BT_SEND_TO_LOCAL_STORE;
import static co.com.sofka.certification.userinterfaces.SendToUI.SP_CHOOSE_LOCAL_STORE;
import static co.com.sofka.certification.userinterfaces.SendToUI.TV_CHOOSE_CITY;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.HashMap;
import java.util.Map;

import co.com.sofka.certification.models.Cities;

public class EnterTheFirstLocalStoreTask implements Task {
    private String storeFromCity;

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, Integer> area = new HashMap<>();
        area.put("left", 500);
        area.put("top", 200);
        area.put("width", 100);
        area.put("height", 1600);

        actor.attemptsTo(
                Click.on(BT_SEND_TO_LOCAL_STORE),
                Click.on(BT_CHOOSE_CITY),
                scrollToElement()
                        .withScrollArea(area)
                        .lookingFor(TV_CHOOSE_CITY.of(storeFromCity))
                        .inDirection("down")
                        .andPercent(1.0)
                        .andSpeed(10000.0),
                Click.on(TV_CHOOSE_CITY.of(storeFromCity)),
                Click.on(SP_CHOOSE_LOCAL_STORE),
                selectTheFirstStoreAvailable(),
                Click.on(BT_CONTINUE)
        );
    }

    public static EnterTheFirstLocalStoreTask enterTheFirstLocalStore() {
        return new EnterTheFirstLocalStoreTask();
    }

    public EnterTheFirstLocalStoreTask fromTheCity(String city) {
        Cities enumCityes = Cities.valueOf(city);
        storeFromCity = enumCityes.getCityName();
        return this;
    }
}
