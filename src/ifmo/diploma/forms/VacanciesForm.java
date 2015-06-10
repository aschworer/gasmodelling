/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.forms;

import ifmo.diploma.model.Position;
import org.apache.struts.validator.ValidatorForm;

import java.util.List;

/**
 * Created: 25.10.2007 || 17:43:09
 *
 *
 */
public class VacanciesForm extends ValidatorForm {
    private List<Position> vacancies;


    public List<Position> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Position> vacancies) {
        this.vacancies = vacancies;
    }
}
