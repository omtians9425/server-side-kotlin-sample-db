package com.example.sample_serverside_kotlin_db.demo_db

import org.springframework.data.repository.CrudRepository

/**
 * DAO.
 */
interface UserRepository : CrudRepository<User, Int>