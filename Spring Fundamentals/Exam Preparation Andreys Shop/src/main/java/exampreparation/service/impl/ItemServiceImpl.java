package exampreparation.service.impl;

import exampreparation.model.entity.Item;
import exampreparation.model.serviceModels.CategoryServiceModel;
import exampreparation.model.serviceModels.ItemServiceModel;
import exampreparation.model.view.ItemViewModel;
import exampreparation.repository.ItemRepository;
import exampreparation.service.CategoryService;
import exampreparation.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.modelmapper.Converters.Collection.map;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        item.setCategory(this.categoryService.findByCategoryName(itemServiceModel.getCategory().getCategoryName()));

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String
                            .format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {

        return this.itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String
                            .format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getCategoryName().name()));

                    return itemViewModel;
                }).orElse(null);


    }

    @Override
    public void delete(String id) {
        this.itemRepository
                .deleteById(id);
    }
}
