package softuni.exam.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.common.GlobalConstants;
import softuni.exam.common.GlobalPaths;
import softuni.exam.models.dtos.seedDtos.seedXmls.seedTicket.TicketRootSeedDto;
import softuni.exam.models.dtos.seedDtos.seedXmls.seedTicket.TicketSeedDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.xmlParser.XmlParser;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final XmlParser xmlParser;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final PlaneService planeService;
    private final PassengerService passengerService;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, XmlParser xmlParser, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService, PlaneService planeService, PassengerService passengerService) {
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }


    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return this.fileUtil.readFile(GlobalPaths.TICKETS_PATH);
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        TicketRootSeedDto ticketRootSeedDto = this.xmlParser.importFromXml(GlobalPaths.TICKETS_PATH, TicketRootSeedDto.class);


        for (TicketSeedDto ticketDto : ticketRootSeedDto.getTickets()) {

            if (this.validationUtil.isValid(ticketDto)) {

                if (this.ticketRepository.findBySerialNumber(ticketDto.getSerialNumber()) == null) {


                    //Getting from-town
                    Town fromTown = this.townService.getTownByName(ticketDto.getFromTown().getName());

                    //Getting to-town
                    Town toTown = this.townService.getTownByName(ticketDto.getToTown().getName());

                    //Getting the passenger
                    Passenger passenger = this.passengerService.getPassengerByEmail(ticketDto.getPassenger().getEmail());

                    //Getting the plane
                    Plane plane = this.planeService.getPlaneByRegisterNumber(ticketDto.getPlane().getRegisterNumber());

                    if (fromTown != null && toTown != null && passenger != null && plane != null) {

                        Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);

                        ticket.setFromTownId(fromTown);
                        ticket.setToTown(toTown);
                        ticket.setPassenger(passenger);
                        ticket.setPlane(plane);

                        sb.append(String.format(GlobalConstants.SUCCESSFULLY_IMPORTED_TICKET, ticketDto.getFromTown().getName(), ticketDto.getToTown().getName()))
                                .append(System.lineSeparator());

                        this.ticketRepository.saveAndFlush(ticket);
                    }
                }

            } else {
                sb.append(GlobalConstants.INVALID_TICKET)
                        .append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
