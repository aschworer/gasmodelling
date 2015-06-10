/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.JobHistoryForm;
import ifmo.diploma.model.Employee;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 30.10.2007 || 15:43:23
 *
 *
 */
public class JobHistoryAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JobHistoryForm form = (JobHistoryForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.setHistoryEarlier(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getJobHistory(employee.getId()));
        form.setHistoryCurrentCompany(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositionHistory(employee.getId()));
        return actionMapping.findForward("View");
    }

    public ActionForward submit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JobHistoryForm form = (JobHistoryForm) actionForm;
        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.getNewHistoryItem().initDates();
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().addJobHistoryItem(form.getNewHistoryItem());
        form.setHistoryEarlier(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getJobHistory(employee.getId()));
        form.setHistoryCurrentCompany(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositionHistory(employee.getId()));
        return actionMapping.findForward("View");
    }

    public ActionForward updateList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        JobHistoryForm form = (JobHistoryForm) actionForm;
        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().updateJobHistoryList(form.getHistoryEarlier());
        form.setHistoryEarlier(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getJobHistory(employee.getId()));
        form.setHistoryCurrentCompany(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositionHistory(employee.getId()));
        return actionMapping.findForward("View");

    }

}