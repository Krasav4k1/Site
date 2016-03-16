package com.controller;

import com.entity.City;
import com.repository.CityRepository;
import com.servise.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    @Autowired
    CityService cityService;
    @Autowired
    CityRepository cityRepository;

    @RequestMapping("/searchRegionyByIdCountry{index}/{id}")
    public String controlUrlCountry(Model model,@PathVariable String id,@PathVariable String index){
        model.addAttribute("index",index);


        if (index.equals("obl")) {
            int idCountry = Integer.parseInt(id);
            searchOblastByIdCountry(model,idCountry);
        }else
        if (index.equals("ray")){
            searchRegionByOblast(model,id);
        }else
        if (index.equals("city")){
            searchRegionByRegion(model,id);
        }else
        if (index.equals("cityId")){
            searchIdByCity(model, id);
        }

        return"searchOblastByIdCountry";
    }

    public void searchOblastByIdCountry(Model model,int id){
        model.addAttribute("oblastCountry",cityService.getOblast(id));

    }

    public void searchRegionByOblast(Model model,String id){
        model.addAttribute("ragionOblast", cityService.getRegion(id));

    }

    public void searchRegionByRegion(Model model, String id){
        model.addAttribute("cityRegion", cityService.getCity(id));
    }

    public void searchIdByCity(Model model, String id){
        model.addAttribute("IdCity", cityRepository.findByCity(id));
    }


}
