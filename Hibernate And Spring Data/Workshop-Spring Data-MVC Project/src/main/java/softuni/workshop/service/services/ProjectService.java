package softuni.workshop.service.services;

import softuni.workshop.web.models.ProjectViewModel;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface ProjectService {

    void importProjects() throws JAXBException;

    boolean areImported();

    String readProjectsXmlFile() throws IOException;

    String exportFinishedProjects();

    List<ProjectViewModel> finishedProjects();
}
