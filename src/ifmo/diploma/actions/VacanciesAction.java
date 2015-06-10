/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.actions;

import ifmo.diploma.ApplicationActionServlet;
import ifmo.diploma.forms.VacanciesForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created: 25.10.2007 || 17:42:58
 *
 *
 */
public class VacanciesAction extends DispatchAction {

    public ActionForward unspecified(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        VacanciesForm form = (VacanciesForm) actionForm;
        form.setVacancies(ApplicationActionServlet.DATA_ACCESSOR.getPositionDAO().getVacancies());
        return actionMapping.findForward("View");
    }
}
