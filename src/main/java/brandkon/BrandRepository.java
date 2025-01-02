package brandkon;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    //특정 카테고리에 속한 브랜드 목록을 가져오긔
    List<Brand> findByCategorySlug(String slug);
}


