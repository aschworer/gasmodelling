/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.AddEditEmployeeForm;
import ifmo.diploma.model.Employee;
import org.apache.commons.logging.Log; import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 20.10.2007 || 16:42:48
 *
 *
 */
public class AddEditEmployeeAction extends DispatchAction {
    private static Log logger = LogFactory.getLog(AddEditEmployeeAction.class);

    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        AddEditEmployeeForm form = (AddEditEmployeeForm) actionForm;
        Employee employeeToEdit = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employeeToEdit != null) {
            form.setEmployee(employeeToEdit);
        }
        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        form.setPositions(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositions());
        return actionMapping.findForward("View");
    }

    public ActionForward submit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        AddEditEmployeeForm form = (AddEditEmployeeForm) actionForm;
        FormFile passportCopyFile = form.getPassportCopy();
        FormFile resumeCopyFile = form.getResumeCopy();
        FormFile photoCopyFile = form.getPhotoCopy();
        if (!"".equals(passportCopyFile.getFileName())) {
            form.getEmployee().getPassport().setPassportCopyFilename(passportCopyFile.getFileName());
        }
        if (!"".equals(resumeCopyFile.getFileName())) {
            form.getEmployee().setResumeCopyFilename(resumeCopyFile.getFileName());
        }
        if (!"".equals(photoCopyFile.getFileName())) {
            form.getEmployee().setPhotoCopyFilename(photoCopyFile.getFileName());
        }

        form.getEmployee().getPassport().initDates();
        Integer employeeAddedID = ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().saveEmployee(form.getEmployee());
        form.getEmployee().setId(employeeAddedID);

        if (!"".equals(passportCopyFile.getFileName())) {
            ApplicationActionServlet.copyFileToServer(String.valueOf(form.getEmployee().getId()), passportCopyFile);
        }
        if (!"".equals(resumeCopyFile.getFileName())) {
            ApplicationActionServlet.copyFileToServer(String.valueOf(form.getEmployee().getId()), resumeCopyFile);
        }
        if (!"".equals(photoCopyFile.getFileName())) {
            ApplicationActionServlet.copyFileToServer(String.valueOf(form.getEmployee().getId()), photoCopyFile);
        }

        form.setDepartments(ApplicationActionServlet.DATA_ACCESSOR.getDepartmentDAO().getDepartments());
        form.setPositions(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getPositions());
        return actionMapping.findForward("ManageEmployees");
    }


}
