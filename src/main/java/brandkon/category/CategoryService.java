package brandkon.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //모든 카테고리 조회 , (리턴 카테고리 목록)
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName(), category.getSlug(), category.getImageUrl()))
                .toList();

    }

}
