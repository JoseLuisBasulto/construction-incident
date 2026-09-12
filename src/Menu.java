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
        int op;

        do {
            System.out.println("\n------------Menú principal------------");
            System.out.println("1 Registrar reporte");
            System.out.println("2 Listar reportes");
            System.out.println("3 Buscar reporte");
            System.out.println("4 Cambiar estado de reporte");
            System.out.println("5 Salir del programa");

            op = scanner.nextInt();
            scanner.nextLine();

            switch (op){
                case 1 -> registerView();
                case 2 -> reportManager.showReports();
                case 3 -> searchReportView();
                case 4 -> changeStateView();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida...");
            }
        }while (op != 5);
    }

    private void registerView(){
        System.out.println("------------Ingresar información------------");

        System.out.print("Equipo: ");
        String equipment = scanner.nextLine();
        System.out.print("Ubicación: ");
        String location = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Prioridad: ");
        String priority = scanner.nextLine();
        System.out.print("Estado: Pendiente");

        Priority newPriority = Validations.isValidPriority(priority);

        if(Validations.isValidInput(equipment,location,description)
                && newPriority != null){
            reportManager.registerReport(
                    new Report(id,equipment,location,description,newPriority));
            id++;
        }else{
            System.out.println("Información en blanco o prioridad incorrecta...");
        }
    }

    private void changeStateView(){
        System.out.println("Ingrese el id del reporte:");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingrese el nuevo estado del reporte:");
        String state = scanner.nextLine();

        State newState = Validations.isValidState(state);

        if(newState != null){
            reportManager.changeReportSate(id, newState);
        }else{
            System.out.println("Estado inválido...");
        }
    }

    private void searchReportView(){
        System.out.println("Ingrese el id del reporte:");
        int id = scanner.nextInt();

        Report report = reportManager.searchReport(id);

        if(report != null){
            System.out.println(report);
        }else{
            System.out.println("No se encontró el reporte...");
        }
    }
}
