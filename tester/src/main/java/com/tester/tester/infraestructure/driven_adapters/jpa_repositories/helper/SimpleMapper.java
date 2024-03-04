package com.tester.tester.infraestructure.driven_adapters.jpa_repositories.helper;

public interface SimpleMapper <E, D> {
    D toData(E entity);
    E toEntity(D data);
}
