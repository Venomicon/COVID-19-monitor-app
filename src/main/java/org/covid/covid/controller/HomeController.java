package org.covid.covid.controller;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.covid.covid.domain.Country;
import org.covid.covid.domain.SearchForm;
import org.covid.covid.domain.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("countryStatus")
public class HomeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @ModelAttribute("worldStatus")
    public Status getCurrentWorldStatus() throws Exception {
        Gson gson = new Gson();
        Status[] worldStatus = gson.fromJson(getWorldResponse(), Status[].class);
        return worldStatus[0];
    }

    @RequestMapping("/")
    public String home(@ModelAttribute("searchForm") SearchForm searchForm) {
        return "homePage";
    }

    @RequestMapping("/country")
    public ModelAndView country(@ModelAttribute("searchForm") SearchForm searchForm) throws Exception {
        ModelAndView modelAndView = new ModelAndView("countryPage");
        Country country = getCountryStatus(searchForm.getSearch());
        modelAndView.addObject("countryStatus", country);
        return modelAndView;
    }

    private Country getCountryStatus(String searched) throws UnirestException {
        Gson gson = new Gson();
        Country[] country = gson.fromJson(getCountryResponse(searched), Country[].class);
        return country[0];
    }

    private String getWorldResponse() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://covid-19-data.p.rapidapi.com/totals?format=json")
                .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .header("x-rapidapi-key", "6667b94227msh95a45c53a6137a5p150debjsndcf93662c2b7")
                .asString();
        return response.getBody();
    }

    private String getCountryResponse(String searched) throws UnirestException {
        String url = new StringBuilder("https://covid-19-data.p.rapidapi.com/country?format=json&name=")
                .append(searched)
                .toString();
        HttpResponse<String> response = Unirest.get(url)
                .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .header("x-rapidapi-key", "6667b94227msh95a45c53a6137a5p150debjsndcf93662c2b7")
                .asString();
        return response.getBody();
    }
}
