package brandkon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;


    public List<BrandDto> getBrandsByCategory(String categorySlug) {
        return brandRepository.findByCategorySlug(categorySlug).stream()
                .map(brand -> new BrandDto(brand.getId(), brand.getName(), brand.getImageUrl()))
                .toList();
    }


    public BrandDto getBrandDetails(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new RuntimeException("브랜드를 찾을 수 없습니다"));
        return new BrandDto(brand.getId(), brand.getName(), brand.getImageUrl());
    }






}
