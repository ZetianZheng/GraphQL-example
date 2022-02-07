package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.exception.DogNotFoundException;
import com.udacity.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    /**
     * TODO: 这里的dogRepository findALl()的详细定义？
     * @return
     */
    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    /**
     * optional Dog 资料 解释
     * @param id
     * @return
     */
    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found",id);
        }
    }
}
