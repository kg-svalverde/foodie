package com.konrad.intership12026.data

import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.user1
import org.jetbrains.compose.resources.DrawableResource

object AppData {

   val users: MutableList<UserModel> = mutableListOf(
       UserModel (
           username = "user1",
           password = "password1",
           firstName = "John",
           lastName = "Doe",
            profilePic = Res.drawable.user1,
           attributes = UserAttributes
           (
               age = 28,
               height = 180,
               weight = 7f,
               activityLevel = "Active",
               healthGoal = "Maintain Weight",
               dailyCalories = 2400,
               proteinGrams = 130,
               carbGrams = 300,
               fatGrams = 60,
           )
       )
   )

    fun addUser(userModel: UserModel) {
        users.add(userModel)
    }

    fun removeUser(userModel: UserModel) {
        users.remove(userModel)
    }
}

data class UserModel(

    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val attributes: UserAttributes,
    val profilePic: DrawableResource
)

data class UserAttributes(

    val age: Int,
    val height: Int,
    val weight: Float,
    val activityLevel: String,
    val healthGoal: String,
    val dailyCalories: Int,
    val proteinGrams: Int,
    val carbGrams: Int,
    val fatGrams: Int,

)