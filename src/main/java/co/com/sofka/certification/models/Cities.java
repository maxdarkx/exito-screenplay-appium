package co.com.sofka.certification.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Cities {
    BOGOTA("Bogotá"),
    CHIA("Chía"),
    MEDELLIN("Medellín"),
    ENVIGADO("Envigado"),
    ITAGUI("Itagüí"),
    SABANETA("Chía"),
    BELLO("Bello"),
    CALI("Cali"),
    BARRANQUILLA("Barranquilla"),
    CARTAGENA("Cartagena"),
    BUCARAMANGA("Bucaramanga"),
    FLORIDABLANCA("Floridablanca"),
    MANIZALES("Manizales"),
    VILLAMARIA("Villamaría"),
    PEREIRA("Pereira"),
    IBAGUE("Ibagué"),
    VILLAVICENCIO("Villavicencio"),
    SANTA_MARTA("Santa Marta"),
    NEIVA("Neiva"),
    SINCELEJO("Sincelejo"),
    MONTERIA("Montería"),
    ARMENIA("Armenia"),
    CUCUTA("Cúcuta"),
    VALLEDUPAR("Valledupar"),
    RIONEGRO("Rionegro"),
    SOACHA("Soacha"),
    PASTO("Pasto"),
    BUGA("Buga"),
    POPAYAN("Popayán"),
    TUNJA("Tunja"),
    CALDAS("Caldas"),
    FUSAGASUGA("Fusagasugá"),
    JAMUNDI("Jamundí"),
    LA_ESTRELLA("La Estrella"),
    TABIO("Cundinamarca"),
    TULUA("Tuluá"),
    TENJO("Tenjo"),
    COTA("Cota");
    private final String cityName;

    Cities(String city) {
        cityName = city;
    }

    public String getCityName() {
        return cityName;
    }
}
