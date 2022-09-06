package co.com.sofka.certification.models;

public enum Cities {
    BOGOTA(""),
    MEDELLIN,
    ENVIGADO,
    ITAGUI,
    SABANETA,
    BELLO,
    CALI,
    BARRANQUILLA,
    CARTAGENA,
    BUCARAMANGA,
    FLORIDABLANCA


}
/*
public enum Countries {
    INDIA("India"),
    USA("USA"),
    ICELAND("Iceland"),
    GREENLAND("Greenland"),
    SWITZERLAND("Switzerland"),
    NORWAY("Norway"),
    NEW_ZEALAND("New Zealand"),
    GREECE("Greece"),
    ITALY("Italy"),
    IRELAND("Ireland"),
    CHINA("China"),
    JAPAN("Japan"),
    FRANCE("France"),
    RUSSIA("Russia"),
    AUSTRALLIA("Australlia"),
    CANADA("Canada");

    private final String countryName;

    Countries(String country)
    {
        countryName = country;
    }

    public static List<String> asList()
    {
        return Arrays.stream(values()).map(Enum::name).collect(Collectors.toList());
    }

    public static Boolean find(String lookingForCountry)
    {
        return asList().contains(lookingForCountry);
    }

    public String getCountryName()
    {
        return countryName;
    }

}

 */