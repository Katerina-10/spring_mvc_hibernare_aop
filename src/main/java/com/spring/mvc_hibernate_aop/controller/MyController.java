package com.spring.mvc_hibernate_aop.controller;

//import com.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.spring.mvc_hibernate_aop.entity.Employee;
import com.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    //private EmployeeDAO employeeDAO; //зависимость нампярмую от DAO
    private EmployeeService employeeService;//зависимость от Service

    @RequestMapping("/")
    public String ShowAllEmployees(Model model)
    {
        //List<Employee> allEmployees = employeeDAO.getAllEmployees(); //зависимость нампярмую от DAO
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";


    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployeemethod(Model model)
    {
        Employee employee = new Employee();
        model.addAttribute("employeeAttribute", employee);

        return "employeeInfo";
    }

    @RequestMapping("/saveNewEmployee")
    public String saveNewEmployeemethod(@ModelAttribute("employeeAttribute") Employee emp) //получение данных с формы
    {
        System.out.println("------------" + emp);
        employeeService.saveEmpl(emp); //сохранение нового работника с данными из формы
        return "redirect:/"; //перенаправление на страницу /
    }

    @RequestMapping("updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model)
    {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employeeAttribute", employee);

        return "employeeInfo";
    }

    @RequestMapping("deleteEmpl")
    public String deleteEmployee(@RequestParam("empId") int id)
    {
        employeeService.deleteEmployee(id);
        return "redirect:/"; //перенаправление на страницу /
    }
}
