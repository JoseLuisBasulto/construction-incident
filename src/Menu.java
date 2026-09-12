import java.util.Scanner;

public class Menu {
    private int id = 0;
    private final Scanner scanner;
    private final ReportManager reportManager;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.reportManager = new ReportManager();
    }

    public void start(){
        int option;

        do {
            System.out.println("\n------------Menú principal------------");
            System.out.println("1 Registrar reporte");
            System.out.println("2 Listar reportes");
            System.out.println("3 Buscar reporte");
            System.out.println("4 Cambiar estado de reporte");
            System.out.println("5 Salir del programa");
            System.out.printf("\nIngrese su elección:");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> registerView();
                case 2 -> listReportView();
                case 3 -> searchReportView();
                case 4 -> changeStateView();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida...");
            }
        }while (option != 5);
    }

    private void registerView(){
        System.out.println("------------Ingresar información------------");

        System.out.print("Equipo: ");
        String equipment = scanner.nextLine();
        System.out.print("Ubicación: ");
        String location = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
        String priority = scanner.nextLine();
        System.out.print("Estado: Pendiente");

        Priority newPriority = Validations.isValidPriority(priority);

        if(Validations.isValidInput(equipment,location,description)
                && newPriority != null){
            reportManager.registerReport(
                    new Report(id,equipment,location,description,newPriority));
            id++;
            System.out.println("\nReporte registrado de manera correcta...");
            waitForEnter();
        }else{
            System.out.println("Información en blanco o prioridad incorrecta...");
            waitForEnter();
        }
    }

    private void changeStateView(){
        if(!reportManager.getReportList().isEmpty()){
            System.out.println("Ingrese el id del reporte:");
            int id = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Estado actual: "
                                + reportManager.searchReport(id).getState());
            System.out.println("Ingrese el nuevo estado del " +
                                "reporte(PENDIENTE, PROCESANDO, RESUELTA):");
            String state = scanner.nextLine();

            State newState = Validations.isValidState(state);

            if(newState != null){
                reportManager.changeReportSate(id, newState);
                System.out.println("Estado cambiado de manera correcta...");
                waitForEnter();
            }else{
                System.out.println("Estado inválido...");
                waitForEnter();
            }
        } else {
            System.out.println("No se han registrado reportes...");
            waitForEnter();
        }
    }

    private void searchReportView(){
        if(!reportManager.getReportList().isEmpty()){
            System.out.println("Ingrese el id del reporte:");
            int id = scanner.nextInt();

            Report report = reportManager.searchReport(id);

            if(report != null){
                System.out.println(report);
                waitForEnter();
            }else{
                System.out.println("No se encontró el reporte...");
                waitForEnter();
            }
        } else {
            System.out.println("No se han registrado reportes...");
            waitForEnter();
        }
    }

    private void listReportView(){
        if(!reportManager.getReportList().isEmpty()){
            reportManager.showReports();
            waitForEnter();
        } else {
            System.out.println("No se han registrado reportes...");
            waitForEnter();
        }
    }

    private void waitForEnter(){
        System.out.printf("\nPresiona enter para continuar...");
        scanner.nextLine();
    }
}
