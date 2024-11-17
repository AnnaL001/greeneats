package com.anna.greeneats.data.auth.user

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.main.User
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import java.sql.Time
import javax.inject.Inject

class FirestoreUserRepository @Inject constructor(
  private val _db: FirebaseFirestore
): UserRepository {
  override suspend fun addUserDetails(user: User): Resource<Boolean> {
    return try {
      this._db.collection("users").document(user.id)
        .set(user)
        .await()
      Timber.d("[SUCCESS] - User details of user ${user.id} successfully added")
      Resource.Success(true)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Error adding user ${user.id}: ${e.message}")
      Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchUserDetails(userId: String): Resource<User> {
    return try {
      val user = this._db.collection("users").document(userId)
        .get()
        .await()
        .toObject<User>()
      Timber.d("[SUCCESS] - Details of user $userId successfully fetched")
      Resource.Success(user)
    } catch (e: FirebaseException){
      Timber.d("[FAIL] - Error fetching details of user $userId: ${e.message}")
      Resource.Failure(exception = e)
    }
  }
}