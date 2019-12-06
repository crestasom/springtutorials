package com.crestasom.multidb.dynamic;

import org.springframework.data.repository.CrudRepository;

import com.crestasom.multidb.dynamic.model.Advertiser;

public interface AdvertiserDAO extends CrudRepository<Advertiser, Integer> {

}
