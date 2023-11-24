package co.com.sofka.certification.models;

public enum Departments {
    CUNDINAMARCA("Cundinamarca"),
    ANTIOQUIA("Antioquia"),
    VALLE_DEL_CAUCA("Valle del Cauca"),
    ATLANTICO("Atlántico"),
    BOLIVAR("Bolívar"),
    SANTANDER("Santander"),
    CALDAS("Caldas"),
    RISARALDA("Risaralda"),
    TOLIMA("Tolima"),
    META("Meta"),
    MAGDALENA("Magdalena"),
    HUILA("Huila"),
    SUCRE("Sucre"),
    CORDOBA("Cordoba"),
    QUINDIO("Quindio"),
    NORTE_DE_SANTANDER("Norte de Santander"),
    CESAR("Cesar"),
    NARIÑO("Nariño"),
    CAUCA("Cauca"),
    BOYACA("Boyaca"),
    SAN_ANDRES("San Andrés y Providencia");

    private final String DepartmentName;

    Departments(String dpto) {
        DepartmentName = dpto;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }
}
