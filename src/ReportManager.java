import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    private final List<Report> reportList = new ArrayList<>();

    public void registerReport(Report report){
        reportList.add(report);
    }

    public void showReports(){
        if(!reportList.isEmpty()){
            for(Report currentReport : reportList){
                System.out.println(currentReport);
            }
        }
    }

    public void changeReportSate(int idReport, State state){
        Report report = searchReport(idReport);

        if (report == null){
            return;
        }

        Priority priority = report.getPriority();
        if(priority == Priority.ALTA){
            switch (report.getState()){
                case PENDIENTE -> report.setState(State.PROCESANDO);
                case PROCESANDO -> report.setState(State.RESUELTA);
            }
        }else{
            report.setState(state);
        }

    }

    public Report searchReport(int idReport){
        if (reportList.isEmpty()){
            return null;
        }

        for(Report currentReport : reportList){
            if(currentReport.getIdReport() == idReport){
                return currentReport;
            }
        }

        return null;
    }

    public List<Report> getReportList() {
        return reportList;
    }
}
