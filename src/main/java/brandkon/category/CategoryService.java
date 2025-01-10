package brandkon.category;

import brandkon.brand.BrandCategoryRepository;
import brandkon.brand.BrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private BrandCategoryRepository brandCategoryRepository;

    //모든 카테고리 조회 , (리턴 카테고리 목록)
    public List<BrandDto> getBrandsByCategory(Long categoryId) {
        return brandCategoryRepository.findByCategoryId(categoryId).stream()
                .map(brandCategory -> new BrandDto((
                        brandCategory.getBrand().getId()),
                        brandCategory.getBrand().getName(),
                        brandCategory.getBrand().getImageUrl()
                )).toList();

}
}
