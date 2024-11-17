package com.anna.greeneats.data.auth.user

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.main.User

interface UserRepository {
  suspend fun addUserDetails(user: User): Resource<Boolean>
  suspend fun fetchUserDetails(userId: String): Resource<User>
}