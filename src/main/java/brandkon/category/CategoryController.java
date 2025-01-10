package brandkon.category;


import brandkon.brand.BrandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //특정 카테고리에 속한 브랜드 목록을 조회

    @GetMapping("/{id}/brands")
    public List<BrandDto> getBrandsByCategory(@PathVariable Long id) {
        return categoryService.getBrandsByCategory(id);
    }

}
