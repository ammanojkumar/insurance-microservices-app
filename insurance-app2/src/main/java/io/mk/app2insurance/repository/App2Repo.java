package io.mk.app2insurance.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.mk.app2insurance.model.Insurance;

public interface App2Repo extends MongoRepository<Insurance, Integer> {

	Optional<Insurance> findByBrand(String brand);

	Optional<Insurance> findByBrandAndModel(String brand, String model);

}