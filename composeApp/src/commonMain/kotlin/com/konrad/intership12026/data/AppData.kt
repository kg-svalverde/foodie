package com.konrad.intership12026.data

import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.user1
import intership12026.composeapp.generated.resources.user2
import intership12026.composeapp.generated.resources.user3
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.compose.resources.DrawableResource

object AppData {

    private val _currentUser = MutableStateFlow<UserModel?>(null)
    val currentUser = _currentUser.asStateFlow()

    fun setCurrentUser(user: UserModel?) {
        _currentUser.value = user
    }
    val users: MutableList<UserModel> = mutableListOf(
       UserModel (
           username = "user1",
           password = "1234",
           firstName = "Alex",
           lastName = "Collins",
            profilePic = Res.drawable.user1,
           attributes = UserAttributes
           (
               age = 28,
               height = 180,
               weight = 75f,
               activityLevel = "Active",
               healthGoal = "Maintain Weight",
               dailyCalories = 2400,
               proteinGrams = 130,
               carbGrams = 300,
               fatGrams = 60,
           )
       ),
       UserModel (
           username = "user2",
           password = "1234",
           firstName = "Lily",
           lastName = "Jacobs",
           profilePic = Res.drawable.user2,
           attributes = UserAttributes
               (
               age = 23,
               height = 135,
               weight = 55f,
               activityLevel = "Moderately Active",
               healthGoal = "Gain Weight",
               dailyCalories = 2300,
               proteinGrams = 115,
               carbGrams = 320,
               fatGrams = 65,
           )
       ),
       UserModel (
           username = "user3",
           password = "1234",
           firstName = "Samuel",
           lastName = "Valverde",
           profilePic = Res.drawable.user3,
           attributes = UserAttributes
               (
               age = 22,
               height = 186,
               weight = 72f,
               activityLevel = "Very Active",
               healthGoal = "Gain Weight",
               dailyCalories = 2800,
               proteinGrams = 150,
               carbGrams = 350,
               fatGrams = 80,
           )
       )/*,
       UserModel (
           username = "user4",
           password = "1234",
           firstName = "John",
           lastName = "Doe",
           profilePic = Res.drawable.user4,
           attributes = UserAttributes
               (
               age = 30,
               height = 172,
                       weight = 76f,
               activityLevel = "Sedentary",
               healthGoal = "Lose Weight",
               dailyCalories = 1900,
               proteinGrams = 120,
               carbGrams = 270,
               fatGrams = 50,
           )
       )*/
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