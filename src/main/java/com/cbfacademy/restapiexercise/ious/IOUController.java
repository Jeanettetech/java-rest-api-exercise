package com.cbfacademy.restapiexercise.ious;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/ious")
public class IOUController {

    private final IOUService iouService;

//        @Autowired
//Constructor injection for iou service
    public IOUController(IOUService iouService) {// constructor that takes iou service and sets it// dependency injection
        this.iouService = iouService;
    }

    @GetMapping
    public ResponseEntity<List<IOU>> getAllIOUs() {
        List<IOU> ious = iouService.getAllIOUs();
        return ResponseEntity.ok(ious);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IOU> getIOU(@PathVariable UUID id) {
        try {
            IOU iou = iouService.getIOU(id);
            return ResponseEntity.ok(iou);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IOU Not Found", exception);
        }
    }


    @PostMapping
    public ResponseEntity<IOU> createIOU(@RequestBody IOU iou) {
        IOU createdIOU = iouService.createIOU(iou);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIOU);

    }

    @PutMapping("/{id}")
    public ResponseEntity<IOU> updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
        try {
            IOU iou = iouService.updateIOU(id, updatedIOU);
            return ResponseEntity.ok(iou);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IOU Not Found", exception);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIOU(@PathVariable UUID id) {
        try {
            iouService.deleteIOU(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IOU Not Found", exception);
        }
    }
}
