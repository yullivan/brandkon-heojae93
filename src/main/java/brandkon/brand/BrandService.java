package brandkon.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    //특정 카테고리에 속한 브랜드 목록을 조회
    //@param categorySlug 카테고리 slug
    //@return 해당 카테고리에 속한 브랜드 목록
    public List<BrandDto> getBrandsByCategory(String categorySlug) {
        return brandRepository.findByCategorySlug(categorySlug).stream()
                .map(brand -> new BrandDto(
                        brand.getId(),
                        brand.getName(),
                        brand.getImageUrl()
                ))
                .toList();
    }

    //특정 브랜드 상세 조회
    //@param brandId 브랜드 ID
    //@return 브랜드 상세 정보
    public BrandDto getBrandDetails(Long brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("브랜드를 찾을 수 없습니다."));
        return new BrandDto(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
