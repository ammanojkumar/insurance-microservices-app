package io.mk.app1insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.app1insurance.model.Insurance;

public interface App1Repo extends JpaRepository<Insurance, Integer> {

	Optional<Insurance> findByBrand(String brand);

	Optional<Insurance> findByBrandAndModel(String brand, String model);

}