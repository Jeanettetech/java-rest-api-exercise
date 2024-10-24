package com.cbfacademy.restapiexercise.ious;// business level

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class IOUService {

    private IOURepository iouRepository;

    public IOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    public List<IOU> getAllIOUs() {
        return this.iouRepository.findAll();
    }

    public IOU getIOU(UUID id) throws NoSuchElementException {
        return this.iouRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("IOU not found with id: " + id));
    }

    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        return this.iouRepository.save(iou);
    }



    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException {
        IOU existingIOU = this.iouRepository.findById(id).orElseThrow();
        new NoSuchElementException("IOU not found with id: " + id);

        // Update fields
        existingIOU.setBorrower(updatedIOU.getBorrower());
        existingIOU.setLender(updatedIOU.getLender());
        existingIOU.setAmount(updatedIOU.getAmount());

        return this.iouRepository.save(existingIOU);
    }

    public void deleteIOU(UUID id) throws NoSuchElementException{
        if(!iouRepository.existsById(id)) {
            throw new NoSuchElementException("IOU not found with id: " + id);

        }
        this.iouRepository.deleteById(id);

    }

}