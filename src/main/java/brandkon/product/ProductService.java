package brandkon.product;


import brandkon.brand.BrandDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    //모든 상품 목록 조회 , 리턴(상품목록)
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(new ProductDTO(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    product.getBrand().getName()
            ));
        }
        return productDTOs;
    }
    //특정 목록에 있는 상품 목록조회, @param(브랜드 고유 Id) , 리턴(해당 브랜드의 상품목록)
    public List<ProductDTO> getProductsByBrand(Long brandId) {
        List<Product> products = productRepository.findByBrand_Id(brandId);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(new ProductDTO(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    product.getBrand().getName()
            ));
        }
        return productDTOs;
    }


    //인기 상품 목록 조회(최대 5개) @param(카테고리 Id, 브랜드 Id) / 리턴(인기상품목록)
    public List<ProductDTO> getPopularProducts(Long categoryId, Long brandId) {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> popularProducts = new ArrayList<>();
        int count = 0;

        for (Product product : products) {
            if (categoryId != null && !product.getBrand().getCategory().getId().equals(categoryId)) {
                continue;
            }
            if (brandId != null && !product.getBrand().getId().equals(brandId)) {
                continue;
            }
            popularProducts.add(new ProductDTO(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getImageUrl(),
                    product.getBrand().getName()
            ));
            count++;
            if (count == 5) {
                break;
            }
        }
        return popularProducts;
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