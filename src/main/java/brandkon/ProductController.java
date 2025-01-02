package brandkon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    //모든 상품 목록 조회, 리턴(상품 목록)
    @GetMapping
    public List<ProductDTO> getAllProducts(@RequestParam(required = false) Long brandId) {
        if (brandId != null) {
            return productService.getProductsByBrand(brandId);
        }
        return productService.getAllProducts();
    }
    //인기 상품 목록조회(최대 5개), @Param(카테고리 Id, 브랜드Id), 리턴(인기상품목록)
    @GetMapping("/popular")
    public List<ProductDTO> getPopularProducts(@RequestParam(required = false) Long categoryId, @RequestParam(required = false) Long brandId) {
        return productService.getPopularProducts(categoryId, brandId);
    }


    //특정 상품 상세 정보 조회, @Param(productId), 리턴(상품 상세 정보)
    @GetMapping("/{productId}")
    public ProductDetailDTO getProductDetails(@PathVariable Long productId) {
        return productService.getProductDetails(productId);
    }
}
