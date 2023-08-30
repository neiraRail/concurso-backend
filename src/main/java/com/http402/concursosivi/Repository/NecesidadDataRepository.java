package com.http402.concursosivi.Repository;
import com.http402.concursosivi.Entity.NecesidadDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NecesidadDataRepository extends JpaRepository<NecesidadDataEntity, Long> {
    @Query(value = "SELECT * FROM necesidad_data_entity LIMIT :startIndex, :pageSize", nativeQuery = true)
    List<NecesidadDataEntity> findNecesidadesByStart(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
    @Query(value = "SELECT palabras_clave FROM necesidad_data_entity", nativeQuery = true)
    List<String> findAllPalabrasClave();



}
