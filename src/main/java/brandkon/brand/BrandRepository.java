package brandkon.brand;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    // 특정 카테고리 slug로 Brand 목록을 조회
    @Query("SELECT b FROM Brand b JOIN b.brandCategories bc WHERE bc.category.slug = :slug")
    List<Brand> findByCategorySlug(@Param("slug") String slug);
}


