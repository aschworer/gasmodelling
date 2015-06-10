/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.ManageEmployeesForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created: 12.10.2007 || 12:34:26
 *
 *
 */
public class ManageEmployeesAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.getSession().removeAttribute("employee");

        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        form.setEmployees(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployees());
        return actionMapping.findForward(ApplicationActionServlet.VIEW);
    }

    public ActionForward addEmployee(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return actionMapping.findForward("AddEditEmployee");
    }

    public ActionForward editEmployee(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String idStr = httpServletRequest.getParameter("id");
        if (idStr != null) {
            httpServletRequest.getSession().setAttribute("employee",
                    ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(idStr)));
        } else {
            ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
            httpServletRequest.getSession().setAttribute("employee",
                    ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        }
        return actionMapping.findForward("AddEditEmployee");
    }

    public ActionForward deleteEmployee(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().
                deleteEmployee(Integer.parseInt(form.getEmployeeID()));
        form.setEmployees(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployees());
        return actionMapping.findForward(ApplicationActionServlet.VIEW);
    }

    public ActionForward editDepartmentHistory(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        httpServletRequest.getSession().setAttribute("employee", ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        return actionMapping.findForward("DepartmentHistory");
    }

    public ActionForward editPositionHistory(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        httpServletRequest.getSession().setAttribute("employee", ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        return actionMapping.findForward("PositionHistory");
    }

    public ActionForward editJobHistory(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        httpServletRequest.getSession().setAttribute("employee", ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        return actionMapping.findForward("JobHistory");
    }

    public ActionForward editEducationHistory(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        httpServletRequest.getSession().setAttribute("employee", ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        return actionMapping.findForward("EducationHistory");
    }

    public ActionForward editExtra(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ManageEmployeesForm form = (ManageEmployeesForm) actionForm;
        httpServletRequest.getSession().setAttribute("employee", ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getEmployee(Integer.parseInt(form.getEmployeeID())));
        return actionMapping.findForward("Extra");
    }


}

