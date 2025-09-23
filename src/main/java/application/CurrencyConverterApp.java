package application;
import entity.*;
import dao.*;
import view.CurrencyView;

public class CurrencyConverterApp {
    public static void main(String[] args) {

        CurrencyConverterDao curdao = new CurrencyConverterDao();
        CurrencyView.launch(CurrencyView.class);
    }
}


/*
package application;

import entity.*;
import dao.*;
public class CompanyApp {
    public static void main(String[] args) {

        EmployeeDao empdao = new EmployeeDao();

        empdao.persist(new Employee("Viivi", "Puro", "viivip@mymail.fi", 7300.00));
        empdao.persist(new Employee("Tero", "Koski", "tero.koski@mymail.fi", 3750.00));

        Employee emp = empdao.find(1);
        System.out.println(emp.getFirstName() + " " + emp.getLastName());

        emp.setLastName("Koski");
        empdao.update(emp);
    }
}

 */