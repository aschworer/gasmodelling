/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.ExtraInfoForm;
import ifmo.diploma.model.Employee;
import ifmo.diploma.model.ExtraItem;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 19.11.2007 || 13:32:19
 *
 *
 */
public class EditExtraInfoAction extends DispatchAction {
    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ExtraInfoForm form = (ExtraInfoForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }
        form.getNewHistoryItem().setEmployee(employee);
        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getExtra(employee.getId()));

        return actionMapping.findForward("View");
    }

    public ActionForward addHistoryItem(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ExtraInfoForm form = (ExtraInfoForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }

        FormFile documentFile = form.getFileToAdd();
        if (!"".equals(documentFile.getFileName())) {
            form.getNewHistoryItem().setDocumentCopyFilename(documentFile.getFileName());
            ApplicationActionServlet.copyFileToServer(String.valueOf(employee.getId()), documentFile);
        }

        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().addExtraItem(form.getNewHistoryItem());

        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getExtra(employee.getId()));
        return actionMapping.findForward("View");
    }

    public ActionForward updateList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ExtraInfoForm form = (ExtraInfoForm) actionForm;

        Employee employee = (Employee) httpServletRequest.getSession().getAttribute("employee");
        if (employee == null) {
            return actionMapping.findForward("ManageEmployees");
        }

        for (ExtraItem historyItem : form.getHistory()) {
            if (historyItem.getDocumentCopy().getFileName() != null) {
                if (!"".equals(historyItem.getDocumentCopy().getFileName())) {
                    ApplicationActionServlet.copyFileToServer(String.valueOf(employee.getId()), historyItem.getDocumentCopy());
                    historyItem.setDocumentCopyFilename(historyItem.getDocumentCopy().getFileName());
                }
            }
        }
        ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().updateExtraHistoryItem(form.getHistory());

        form.setHistory(ApplicationActionServlet.DATA_ACCESSOR.getEmployeeDAO().getExtra(employee.getId()));
        return actionMapping.findForward("View");
    }
}