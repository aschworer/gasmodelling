/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.forms;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.DAO.ConnectionFailedException;
import ifmo.diploma.DAO.GettingDataFailedException;
import ifmo.diploma.model.Employee;
import ifmo.diploma.model.JobHistoryItem;
import ifmo.diploma.model.PositionHistoryItem;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created: 30.10.2007 || 15:48:37
 *
 *
 */
public class JobHistoryForm extends ValidatorForm {
    private List<PositionHistoryItem> historyCurrentCompany;
    private List<JobHistoryItem> historyEarlier;
    private JobHistoryItem newHistoryItem;
    private List<JobHistoryItem> jobs;


    public JobHistoryForm() {
        newHistoryItem = new JobHistoryItem();
    }


    public List<PositionHistoryItem> getHistoryCurrentCompany() {
        return historyCurrentCompany;
    }

    public void setHistoryCurrentCompany(List<PositionHistoryItem> historyCurrentCompany) {
        this.historyCurrentCompany = historyCurrentCompany;
    }

    public JobHistoryItem getNewHistoryItem() {
        return newHistoryItem;
    }

    public void setNewHistoryItem(JobHistoryItem newHistoryItem) {
        this.newHistoryItem = newHistoryItem;
    }

    public List<JobHistoryItem> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobHistoryItem> jobs) {
        this.jobs = jobs;
    }


    public List<JobHistoryItem> getHistoryEarlier() {
        return historyEarlier;
    }

    public void setHistoryEarlier(List<JobHistoryItem> historyEarlier) {
        this.historyEarlier = historyEarlier;
    }


    public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        try {
            Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
            if (employee == null) {
                return;
            }
            if (newHistoryItem == null) {
                newHistoryItem = new JobHistoryItem();
                newHistoryItem.setEmployee(employee);
                newHistoryItem.setCompany("");
                newHistoryItem.setNote("");
                newHistoryItem.setPosition("");
            }
            historyEarlier = ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getJobHistory(employee.getId());
            historyCurrentCompany = ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositionHistory(employee.getId());
        } catch (GettingDataFailedException e) {
        } catch (ConnectionFailedException e) {
        }
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest) {
        ActionErrors errors = super.validate(actionMapping, httpServletRequest);
        if ("submit".equals(httpServletRequest.getParameter("method"))) {
            if (newHistoryItem.getPosition().length() == 0) {
                ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED, new String[]{"Position"});
                return errors;
            }
            if (newHistoryItem.getPosition().length() == 0) {
                ApplicationActionServlet.bindArgumentError(errors, ApplicationActionServlet.ERROR_REQUIRED, new String[]{"Company"});
                return errors;
            }

            try {
                java.sql.Date.valueOf(newHistoryItem.getFrom());
                java.sql.Date.valueOf(newHistoryItem.getTill());
            } catch (Exception e) {
                ApplicationActionServlet.bindError(errors, ApplicationActionServlet.ERROR_DATE);
            }
        }

        return errors;
    }

}
