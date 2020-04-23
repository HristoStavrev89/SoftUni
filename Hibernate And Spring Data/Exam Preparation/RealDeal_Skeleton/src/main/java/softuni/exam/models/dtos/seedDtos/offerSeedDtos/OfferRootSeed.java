package softuni.exam.models.dtos.seedDtos.offerSeedDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferRootSeed {

    @XmlElement(name = "offer")
    private List<OfferRootSeedDto> offers;

    public OfferRootSeed() {
        this.offers = new ArrayList<>();
    }

    public List<OfferRootSeedDto> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferRootSeedDto> offers) {
        this.offers = offers;
    }
}
