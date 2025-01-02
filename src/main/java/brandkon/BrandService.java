package brandkon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandService {


    //특정 카테고리에 속한 브랜드 목록을 조회
    @Autowired
    private BrandRepository brandRepository;

    //categorySlug 카테고리의 슬러그
    public List<BrandDto> getBrandsByCategory(String categorySlug) {

        //해당 카테고리의 브랜드 목록 (List<BrandDTO>) 리턴
        return brandRepository.findByCategorySlug(categorySlug).stream()
                .map(brand -> new BrandDto(brand.getId(), brand.getName(), brand.getImageUrl()))
                .toList();
    }

    //특정 브랜드 상세조회 / @Param(브랜드 고유 Id)
    //브랜드 상세 정보를 포함한 BrandDTO 리턴
    public BrandDto getBrandDetails(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(() -> new RuntimeException("브랜드를 찾을 수 없습니다"));
        return new BrandDto(brand.getId(), brand.getName(), brand.getImageUrl());
    }


}
