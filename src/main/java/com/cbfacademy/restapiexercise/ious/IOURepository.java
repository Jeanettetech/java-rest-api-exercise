package com.cbfacademy.restapiexercise.ious;// darta acess layer

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IOURepository extends ListCrudRepository<IOU, UUID>{
}
