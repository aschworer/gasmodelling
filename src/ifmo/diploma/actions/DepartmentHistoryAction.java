/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.DepartmentHistoryForm;
import ifmo.diploma.model.Employee;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 26.10.2007 || 13:40:44
 *
 * 
 */
public class DepartmentHistoryAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        DepartmentHistoryForm form = (DepartmentHistoryForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartmentHistory(employee.getId()));

        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        return actionMapping.findForward("View");
    }

    public ActionForward submit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        DepartmentHistoryForm form = (DepartmentHistoryForm) actionForm;
        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.getNewHistoryItem().initDate();
        ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().addDepartmentHistoryItem(form.getNewHistoryItem());
        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartmentHistory(employee.getId()));
        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        return actionMapping.findForward("View");
    }


    public ActionForward updateList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        DepartmentHistoryForm form = (DepartmentHistoryForm) actionForm;
        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().updateDepartmentHistoryList(form.getHistory());

        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartmentHistory(employee.getId()));
        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        return actionMapping.findForward("View");
    }

}
