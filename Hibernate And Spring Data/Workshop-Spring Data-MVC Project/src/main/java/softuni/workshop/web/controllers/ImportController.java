package softuni.workshop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.EmployeeService;
import softuni.workshop.service.services.ProjectService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
@RequestMapping("/import")
public class ImportController extends BaseController {
    private final CompanyService companyService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @Autowired
    public ImportController(CompanyService companyService, EmployeeService employeeService, ProjectService projectService) {
        this.companyService = companyService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @GetMapping("/xml")
    public ModelAndView xmls() {
        ModelAndView modelAndView = new ModelAndView("xml/import-xml");
        boolean[] areImported = new boolean[]{
                this.companyService.areImported(), this.projectService.areImported(), this.employeeService.areImported()
        };
        modelAndView.addObject("areImported", areImported);
        return modelAndView;
    }

    @GetMapping("/companies")
    public ModelAndView companies() {
        ModelAndView modelAndView = new ModelAndView("xml/import-companies");
        String xmlContent = "";
        try {
             xmlContent = this.companyService.readCompaniesXmlFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("companies", xmlContent);
        return modelAndView;
    }

    @PostMapping("/companies")
    public ModelAndView companiesConfirm() throws JAXBException {
        this.companyService.importCompanies();

        return this.redirect("/import/xml");
    }

    @GetMapping("/projects")
    public ModelAndView projects() throws IOException {
        ModelAndView modelAndView = new ModelAndView("xml/import-projects");
        String xmlContent = this.projectService.readProjectsXmlFile();
        modelAndView.addObject("projects", xmlContent);
        return modelAndView;
    }

    @PostMapping("/projects")
    public ModelAndView projectsConfirm() throws JAXBException {
        this.projectService.importProjects();

        return this.redirect("/import/xml");
    }


    @GetMapping("/employees")
    public ModelAndView employees() {
        ModelAndView modelAndView = new ModelAndView("xml/import-employees");
        modelAndView.addObject("employees", this.employeeService.readEmployeesXmlFile());
        return modelAndView;
    }

    @PostMapping("/employees")
    public ModelAndView employeesConfirm() throws JAXBException {
        this.employeeService.importEmployees();
        return this.redirect("/import/xml");
    }
}
