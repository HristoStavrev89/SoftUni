package softuni.workshop.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.workshop.data.dto.projectDto.ProjectDto;
import softuni.workshop.data.dto.projectDto.ProjectRootDto;
import softuni.workshop.data.entities.Project;
import softuni.workshop.data.repositories.ProjectRepository;
import softuni.workshop.service.services.CompanyService;
import softuni.workshop.service.services.ProjectService;
import softuni.workshop.util.XmlParser;
import softuni.workshop.web.models.ProjectViewModel;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectServiceImpl implements ProjectService {
    private final String XML_PROJECTS_PATH = "src/main/resources/files/xmls/projects.xml";

    private final ProjectRepository projectRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final CompanyService companyService;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, XmlParser xmlParser, ModelMapper modelMapper, CompanyService companyService) {
        this.projectRepository = projectRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
    }


    @Override
    public void importProjects() throws JAXBException {

        ProjectRootDto projectRootDto = this.xmlParser.importXML(ProjectRootDto.class, XML_PROJECTS_PATH);

        for (ProjectDto projectDto : projectRootDto.getProjectDtos()) {

            Project project = this.modelMapper.map(projectDto, Project.class);
            project.setCompany(this.companyService.findCompanyByName(projectDto.getCompany().getName()));

            this.projectRepository.save(project);
        }

    }

    @Override
    public boolean areImported() {
        return this.projectRepository.count() > 0;
    }

    @Override
    public String readProjectsXmlFile() {
        String xml = "";
        try {
            xml = Files.readString(Path.of(XML_PROJECTS_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;

    }

    @Override
    public String exportFinishedProjects() {
        StringBuilder sb = new StringBuilder();

        finishedProjects()
                .forEach(p ->
                        sb.append(p.toString())
                                .append(System.lineSeparator())
                );

        return sb.toString().trim();
    }

    @Override
    public List<ProjectViewModel> finishedProjects() {
        return this.projectRepository
                .findByFinishedIsTrue()
                .stream()
                .map(project -> this.modelMapper.map(project, ProjectViewModel.class))
                .collect(Collectors.toList());
    }
}
