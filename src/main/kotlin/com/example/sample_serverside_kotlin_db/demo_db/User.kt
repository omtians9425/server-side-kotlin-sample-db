package com.example.sample_serverside_kotlin_db.demo_db

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) // corresponds to "AUTO_INCREMENT"
        var id: Int = 0,
        var name: String = ""
)