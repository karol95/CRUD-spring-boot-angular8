

package com.khoubyari.example.dao.jpa;

import com.khoubyari.example.domain.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    City findCityByDescription(String description); //???
    List<City> findAll();
    City findCityByName(String name);
    City findCityByLength(Long length);
    void deleteCityByName(String name);




}
