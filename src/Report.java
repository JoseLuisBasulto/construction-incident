public class Report{
    private final int idReport;
    private String equipment;
    private String location;
    private String description;
    private Priority priority;
    private State state;

    public Report(int idReport, String equipment, String location,
                  String description, Priority priority) {
        this.idReport = idReport;
        this.equipment = equipment;
        this.location = location;
        this.description = description;
        this.priority = priority;
        this.state = State.PENDIENTE;
    }

    @Override
    public String toString() {
        return String.format("INC-%03d\nEquipo: %s\nUbicación: %s" +
                        "\nDescripción: %s\nPrioridad: %s\nEstado: %s"
                ,getIdReport(),getEquipment(),getLocation(),
                getDescription(),getPriority(),getState());
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getIdReport(){
        return idReport;
    }
}
