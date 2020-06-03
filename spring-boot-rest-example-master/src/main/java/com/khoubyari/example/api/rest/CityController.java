
package com.khoubyari.example.api.rest;

import com.khoubyari.example.domain.City;
import com.khoubyari.example.exception.DataFormatException;
import com.khoubyari.example.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@CrossOrigin(origins = "*" )
@RequestMapping(value = "/example/v1/cities")
@Api(tags = {"cities"}) //???
public class CityController extends AbstractRestHandler{

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a city resource.", notes ="Returns the URL of the new resource in the Location header.")/*Opisuje operację lub zazwyczaj metodę HTTP w odniesieniu do określonej ścieżki.*/
    public void createCity(@RequestBody City city,HttpServletRequest request, HttpServletResponse response){
        City createdCity = this.cityService.createCity(city);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdCity.getId()).toString());
    }

  //  @GetMapping
   @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all cities.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    List<City> getAllCity(@ApiParam(value ="The page number (zero-based)", required = true)
                          @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                          @ApiParam(value = "The page size", required = true)
                          @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                          HttpServletRequest request, HttpServletResponse response){
        return this.cityService.getAllCities(page, size);
    }

    @RequestMapping(value = "/id/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single city.", notes = "You have to provide a valid city ID.")
    public
    @ResponseBody
    City getCity(@ApiParam(value = "The ID of the city.", required = true)
                            @PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        City city = this.cityService.getCity(id);
        checkResourceFound(city);
        return city;
    }

    @RequestMapping(value = "/name/{name}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a city by name.", notes = "You have to provide a city name.")
    public
    @ResponseBody
    City getCityByName(@ApiParam(value = "The name of the city.", required = true)
                 @PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) throws Exception {
        City city = this.cityService.getCity(name);
        checkResourceFound(city);
        return city;
    }

    @RequestMapping(value = "/desc/{description}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a city by description.", notes = "You have to provide a city description.")
    public
    @ResponseBody
    City getCityDescription(@ApiParam(value = "The description of the city.", required = true)
                 @PathVariable("description") String description, HttpServletRequest request, HttpServletResponse response) throws Exception {
        City city = this.cityService.getCityDescription(description);
        checkResourceFound(city);
        return city;
    }

    @RequestMapping(value = "/length/{length}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a hotel by length.", notes = "You have to provide a hotel description.")
    public
    @ResponseBody
    City getCityLength(@ApiParam(value = "The length of the city.", required = true)
                            @PathVariable("length") Long length, HttpServletRequest request, HttpServletResponse response) throws Exception {
        City city = this.cityService.getCityLength(length);
        checkResourceFound(city);
        return city;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a city resourse", notes ="You have to provide a valid city ID in the URL and in the payload. The ID attribute can not be updated." )
    public void updateCity(@ApiParam(value = "The ID of the existing City resource.", required = true)
                           @PathVariable("id") Long id, @RequestBody City city,
                           HttpServletRequest request, HttpServletResponse response){
        checkResourceFound(this.cityService.getCity(id));
        if (id != city.getId()) throw new DataFormatException("ID doesn't match!");
        this.cityService.updateCity(city);
    }


    @CrossOrigin(origins = "*" )
    @RequestMapping(value = "/id/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a city resource.", notes = "You have to provide a valid city ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteCity(@ApiParam(value = "The ID of the existing city resource.", required = true)
                           @PathVariable("id") Long id, HttpServletRequest request,
                           HttpServletResponse response){
        checkResourceFound(this.cityService.getCity(id));
        this.cityService.deleteCity(id);
    }

    @RequestMapping(value = "/name/{name}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a city resource.", notes = "You have to provide a valid name in the URL. Once deleted the resource can not be recovered.")
    public void deleteCityByName(@ApiParam(value = "The name of the existing city resource.", required = true)
                                   @PathVariable("name") String name, HttpServletRequest request,
                               HttpServletResponse response){
        checkResourceFound(this.cityService.getCity(name));
        this.cityService.deleteCityByName(name);
    }

}

