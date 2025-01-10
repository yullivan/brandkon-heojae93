package brandkon.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandCategoryRepository extends JpaRepository<BrandCategory, Long> {

    List<BrandCategory> findByCategoryId(long categoryId);

    List<BrandCategory> findByBrandId(Long brandId);


}
