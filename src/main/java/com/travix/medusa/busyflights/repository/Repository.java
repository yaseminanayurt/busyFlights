package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.AbstractRequest;
import com.travix.medusa.busyflights.domain.AbstractResponse;

import java.util.List;

/**
 * Created by eanayas on 07.02.2018.
 */
public interface Repository<T extends AbstractRequest, R extends AbstractResponse> {

    List<R> getFlights(T supplierRequest);
}
