package net.cyancj.sistemae_cepuns.service;

import java.util.List;

public interface IGenericService<Entity, Id> {
    Entity add(Entity entity);

    List<Entity> listAll();

    Entity search(Id id);

    boolean update(Entity entity);

    boolean delete(Id id);

    boolean searchByName(Entity entity);
}
