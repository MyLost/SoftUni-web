package bg.softuni.mobilele.services.offers;

import bg.softuni.mobilele.services.init.DataBaseInitService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService, DataBaseInitService {
    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return false;
    }
}