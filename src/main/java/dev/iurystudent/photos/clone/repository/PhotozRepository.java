package dev.iurystudent.photos.clone.repository;

import dev.iurystudent.photos.clone.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
