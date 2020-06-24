package exampreparation.service;

import exampreparation.model.entity.Category;
import exampreparation.model.entity.CategoryName;
import exampreparation.model.serviceModels.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryName categoryName);
}
