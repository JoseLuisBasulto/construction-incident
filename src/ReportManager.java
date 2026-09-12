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
        Report newReport = searchReport(idReport);

        if(newReport != null){
            newReport.setState(state);
        }
    }

    public Report searchReport(int idReport){
        Report report = null;

        if(!reportList.isEmpty()){
            for(Report currentReport : reportList){
                if(currentReport.getIdReport() == idReport){
                    report = currentReport;
                    break;
                }
            }
        }

        return report;
    }

    public List<Report> getReportList() {
        return reportList;
    }
}
