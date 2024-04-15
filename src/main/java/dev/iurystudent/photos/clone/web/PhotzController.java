package dev.iurystudent.photos.clone.web;

import dev.iurystudent.photos.clone.model.Photo;
import dev.iurystudent.photos.clone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotzController {
    @Autowired
    private final PhotozService photozService;

    public PhotzController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/photoz")
    public Iterable<Photo> getPhoto() {
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo getPhotoById(@PathVariable Integer id){
        Photo photo = photozService.get(id);
        if(photo== null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }else{
            return photo;
        }
    }

    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photozService.remove(id);
    }

    @PostMapping("/photoz/create/")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
       return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
