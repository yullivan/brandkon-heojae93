package brandkon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @GetMapping
    public List<BrandDto> getBrandsByCategory(@RequestParam String category) {
        return brandService.getBrandsByCategory(category);
    }


    //브랜드 상세 조회
    @GetMapping("/{brandId}")
    public BrandDto getBrandDetails(@PathVariable Long brandId) {
        return brandService.getBrandDetails(brandId);
    }
}




