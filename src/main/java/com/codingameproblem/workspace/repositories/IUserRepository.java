package com.codingameproblem.workspace.repositories;

import com.codingameproblem.workspace.entities.User;

import java.util.Optional;

public interface IUserRepository extends CRUDRepository<User,String> {
    public Optional<User> findByName(String name);
}