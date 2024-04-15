package dev.iurystudent.photos.clone.service;

import dev.iurystudent.photos.clone.model.Photo;
import dev.iurystudent.photos.clone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotozService {

    private final PhotozRepository  photozRepository;

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
