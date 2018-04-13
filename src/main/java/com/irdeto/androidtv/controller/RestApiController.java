package com.irdeto.androidtv.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.irdeto.androidtv.entity.Epg;
import com.irdeto.androidtv.entity.Live;
import com.irdeto.androidtv.entity.Vod;
import com.irdeto.androidtv.service.IEpgService;
import com.irdeto.androidtv.service.ILiveService;
import com.irdeto.androidtv.service.IVodService;
 
@RestController
@RequestMapping("/api")
public class RestApiController {
 
	@Autowired
	private ILiveService liveService;
	
	@Autowired
	private IEpgService epgService;
	
	@Autowired
	private IVodService vodService;
	
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
    @RequestMapping(value = "/test/", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("It Works!", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/live/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertLive(@RequestBody Live live, UriComponentsBuilder uri){
    	liveService.addLive(live);
    	return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/live/", method = RequestMethod.GET)
    public ResponseEntity<List<Live>> getLive(){
    	List<Live> live = liveService.getLive();
    	return new ResponseEntity<List<Live>>(live, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/epg/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertEpg(@RequestBody Epg epg, UriComponentsBuilder uri){
    	epgService.addEpg(epg);
    	return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/epg/", method = RequestMethod.GET)
    public ResponseEntity<List<Epg>> getEpg(){
    	List<Epg> epg = epgService.getEpg();
    	return new ResponseEntity<List<Epg>>(epg, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/epg/filter/{serviceId}", method = RequestMethod.GET)
    public ResponseEntity<List<Epg>> getEpgByServiceId(@PathVariable("serviceId") Integer serviceId){
    	List<Epg> epg = epgService.getEpgByServiceId(serviceId);
    	return new ResponseEntity<List<Epg>>(epg, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/vod/", method = RequestMethod.POST)
    public ResponseEntity<Void> insertVod(@RequestBody Vod vod, UriComponentsBuilder uri){
    	vodService.addVod(vod);
    	return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/vod/", method = RequestMethod.GET)
    public ResponseEntity<List<Vod>> getVod(){
    	List<Vod> vod = vodService.getVod();
    	return new ResponseEntity<List<Vod>>(vod, HttpStatus.OK);
    }
}
