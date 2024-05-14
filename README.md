![](https://github.com/Iuryppedrosa/API-JavaSpring-JDBC-h2-MarcoCodes/blob/main/322526982-c4813d23-da03-4db4-a5a7-9230115363d5.png?raw=true)
# Photos-Clone Spring Project

This project is a Spring Boot application that allows users to import a file through the browser and send it to the H2 database, as well as download it. It utilizes Java, Spring Boot, JPA, and H2 database and supports all CRUD operations.

## Features

- File import through the browser
- File upload to H2 database
- File download from H2 database
- Supports all CRUD operations

## Technologies Used

- Java
- Spring Boot
- JPA 
- H2 Database 

## Code Snippets 

### Service Class 

```java 
@Service 
public class PhotozService { 
    private final PhotozRepository photozRepository; 
    
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
```
## Controller
@RestController 
public class PhotzController { 
    @Autowired private final PhotozService photozService; 
    
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
# Project Structure

The project follows a standard structure with separate packages for models, repositories, services, and web controllers. The main components include:

- **Photo** model class for handling photos.
- **PhotoRepository** repository interface for CRUD operations.
- **PhotoService** service class that contains business logic.
- **PhotoController** web controller class for handling HTTP requests.

For more details on the project structure and code implementation, refer to the source code hosted on this repository.

## Getting Started

To get started with this project:

1. Clone the repository to your local machine.
2. Navigate to the root directory of the project.
3. Run `mvnw spring-boot:run` command to start the application.
4. Open your browser and navigate to `localhost:8080`.
5. Enjoy uploading, storing, and downloading your files with ease!

Feel free to copy and use this README for your GitHub repository. If you have any further questions or need additional assistance, feel free to ask! 😊
---

Feel free to adjust the formatting or add any additional information as needed. If you have any other requests, feel free to ask! 🚀

![](https://private-user-images.githubusercontent.com/89420889/322526959-dc0d698f-58f2-4dd9-9e21-c19b8a4281b8.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MTMxOTMyODksIm5iZiI6MTcxMzE5Mjk4OSwicGF0aCI6Ii84OTQyMDg4OS8zMjI1MjY5NTktZGMwZDY5OGYtNThmMi00ZGQ5LTllMjEtYzE5YjhhNDI4MWI4LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDA0MTUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwNDE1VDE0NTYyOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQ5NjdkNThmYjRmNzVjMzBmNThmMzk5NWRmNmMxMmEzZGY3Mzc5NDZhMGZmOWRjOWUzYzgyZTk2MTVhYTI3ZGYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.0wQSYouc4QN1C9_F9LTBSNqZS22OrDAmbYn6iNl7Sjs)
