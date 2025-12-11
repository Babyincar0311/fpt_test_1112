package org.t2404e.test1112.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.t2404e.test1112.model.Employee;
import org.t2404e.test1112.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    // 1. Trang chủ: Hiển thị danh sách
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", service.getEmployees());
        return "index"; // Trả về file index.html
    }

    // 2. Form thêm mới
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee"; // Trả về file new_employee.html
    }

    // 3. Xử lý lưu
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if(employee.getId() == null) {
            service.addEmployees(employee);
        } else {
            service.updateEmployee(employee);
        }
        return "redirect:/";
    }

    // 4. Form sửa
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "new_employee"; // Dùng chung form với thêm mới
    }

    // 5. Xóa nhân viên
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        service.deleteEmployee(id);
        return "redirect:/";
    }
}
