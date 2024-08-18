package com.github.standardsolutions.communication.rest.fetching;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<FlightsEntity, Long>, JpaSpecificationExecutor<FlightsEntity> {
}
