package exampreparation.service;

import exampreparation.model.serviceModels.ItemServiceModel;
import exampreparation.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
