package com.doggy;

import com.doggy.mapper.PlaceHolderGrep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    private PlaceHolderGrep placeHolderGrep;

    public HomeController(PlaceHolderGrep placeHolderGrep) {
        this.placeHolderGrep = placeHolderGrep;
    }

    @GetMapping
    public ResponseEntity<String> homeView(){
        String storeAsString = placeHolderGrep.getStoreAsString();
        return new ResponseEntity<>("result : " + storeAsString, HttpStatus.OK);
    }
}
