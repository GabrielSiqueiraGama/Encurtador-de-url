package zhant.reduzurl.controllers;

import java.net.URI;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import zhant.reduzurl.dto.ShortenUrlRequest;
import zhant.reduzurl.dto.ShortenUrlResponse;
import zhant.reduzurl.entities.UrlEntity;
import zhant.reduzurl.repositories.UrlRepository;

@RestController
public class UrlController {

	@Autowired
	private UrlRepository urlRepository;
	
	@PostMapping(value ="/shorten-url")
	public ResponseEntity<ShortenUrlResponse> shorturl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest){
		String id;
		
		do {
			id = RandomStringUtils.randomAlphanumeric(5, 10);
		}while(urlRepository.existsById(id));
		
		urlRepository.save(new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1)));
		
		var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);
		
		return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Void> redirect(@PathVariable("id") String id){
		
		var url = urlRepository.findById(id);
		
		if(url.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(url.get().getFullUrl()));
		
		return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
	}
}
