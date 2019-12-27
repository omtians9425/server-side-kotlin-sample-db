package com.example.sample_serverside_kotlin_db.demo_db

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @Autowired // injection
    lateinit var userRepository: UserRepository

    @PostMapping("/add")
    fun addNewUser(@RequestParam name: String): String {
        userRepository.save(User(0, name)) // insert avoiding update
        return "Saved"
    }

    @GetMapping("/all")
    fun getAllUsers(): Iterable<User>? {
        return userRepository.findAll()
    }

    @PostMapping("/update")
    fun updateUser(@RequestParam id: Int, @RequestParam name: String): String {
        return if (userRepository.existsById(id)) {
            userRepository.save(User(id, name))
            "Updated"
        } else {
            "User does not exist."
        }
    }

    @PostMapping("/delete")
    fun deleteUser(@RequestParam id: Int): String {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            "Deleted"
        } else {
            "User does not exist"
        }
    }
}