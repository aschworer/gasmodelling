/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.EditDepartmentForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 14.11.2007 || 12:55:16
 *
 * 
 */
public class EditDepartmentsAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EditDepartmentForm form = (EditDepartmentForm) actionForm;

        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        if (!form.getDepartments().isEmpty()) {
            form.setDepartmentIDChoosed(String.valueOf(form.getDepartments().get(0).getId()));
        }
        return actionMapping.findForward("View");
    }

    public ActionForward addDepartment(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EditDepartmentForm form = (EditDepartmentForm) actionForm;

        ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().addDepartment(form.getNewDepartment());

        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        form.setDepartmentIDChoosed(String.valueOf(form.getDepartments().get(0).getId()));
        return actionMapping.findForward("View");
    }

    public ActionForward deleteDepartment(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        EditDepartmentForm form = (EditDepartmentForm) actionForm;

        ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().
                deleteDepartment(Integer.parseInt(form.getDepartmentIDChoosed()));

        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        form.setDepartmentIDChoosed(String.valueOf(form.getDepartments().get(0).getId()));
        return actionMapping.findForward("View");
    }
}
