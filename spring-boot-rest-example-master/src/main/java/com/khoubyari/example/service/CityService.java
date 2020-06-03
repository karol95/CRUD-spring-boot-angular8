
package com.khoubyari.example.service;

import com.khoubyari.example.dao.jpa.CityRepository;
import com.khoubyari.example.domain.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {

    private static final Logger log = LoggerFactory.getLogger(CityService.class);
    //dlaczego repozytoria nie mają odpowiedniej adnotacji ?

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public CityService(){
    }

    public City createCity(City city){
        return cityRepository.save(city);
    }

    public City getCity(long id){
        return cityRepository.findOne(id);
    }

    public City getCity(String name){ return cityRepository.findCityByName(name); }

    public City getCityDescription(String description){ return cityRepository.findCityByDescription(description); }

    public City getCityLength(Long length){ return cityRepository.findCityByLength(length); }

    public void updateCity(City city){
        cityRepository.save(city);
    }

    public void deleteCity(Long id){
        cityRepository.delete(id);
    }

    public void deleteCityByName(String name){ cityRepository.deleteCityByName(name); }

    public List<City> getAllCities(Integer page, Integer size){


      return  cityRepository.findAll();

       /*  Page pageOfCities = cityRepository.findAll(new PageRequest(page, size));
           log.info("getAllCities");
        if (size > 50){
            counterService.increment("Khoubyari.CityService.getAll.largePayload");
        }




        return pageOfCities;*/
    }


}
