package brandkon.product;


import brandkon.brand.BrandDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    //전체 상품 목록 조회 / 리턴 상품목록
    public List<ProductDTO> getAllProducts() {

        return productRepository.findAll().stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getBrand().getName()
                )).toList();
    }
    //특정 브랜드의 상품 목록을 조회 / 리턴 브랜드 상품목록
    public List<ProductDTO> getProductsByBrand(Long brandId) {
        return productRepository.findByBrandId(brandId).stream()
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getBrand().getName()
                )).toList();
    }


    //인기 상품 목록 조회(최대 5개) @param(카테고리 Id, 브랜드 Id) / 리턴(인기상품목록)
    public List<ProductDTO> getPopularProducts(Long categoryId, Long brandId) {
        // 모든 상품 조회
        List<Product> products = productRepository.findAll();

        // 조건 필터링
        Stream<Product> filteredProducts = products.stream();

        if (categoryId != null) {
            filteredProducts = filteredProducts.filter(product ->
                    product.getBrand().getBrandCategories().stream()
                            .anyMatch(brandCategory -> brandCategory.getCategory().getId().equals(categoryId))
            );
        }

        if (brandId != null) {
            filteredProducts = filteredProducts.filter(product ->
                    product.getBrand().getId().equals(brandId)
            );
        }

        // 최대 5개로 제한
        return filteredProducts
                .limit(5)
                .map(product -> new ProductDTO(
                        product.getId(),
                        product.getProductName(),
                        product.getPrice(),
                        product.getImageUrl(),
                        product.getBrand().getName()
                )).toList();

    }


    //특정 상품의 상세 정보 조회, 리턴(상품 상세 정보)
    public ProductDetailDTO getProductDetails(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));

        BrandDto brandDTO = new BrandDto(
                product.getBrand().getId(),
                product.getBrand().getName(),
                product.getBrand().getImageUrl()
        );
        return new ProductDetailDTO(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                brandDTO,
                366 // 남은 유효기간 쓰 ~ ~
        );
    }
}