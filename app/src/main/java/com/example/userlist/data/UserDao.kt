package com.example.userlist.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userlist.model.UserList

interface UserDao {
    // Insert a user into the database
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserList)
    // Retrieve all users from the database
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserList>
    // Retrieve a specific user from the database
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUser(userId: Int): UserList
    // Delete all users from the database
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

}