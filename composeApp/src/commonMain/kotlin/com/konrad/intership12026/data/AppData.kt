package com.konrad.intership12026.data

import intership12026.composeapp.generated.resources.Res
import intership12026.composeapp.generated.resources.apple_slices
import intership12026.composeapp.generated.resources.avocado_toast
import intership12026.composeapp.generated.resources.beef_stir_fry
import intership12026.composeapp.generated.resources.beef_tacos
import intership12026.composeapp.generated.resources.caesar_salad
import intership12026.composeapp.generated.resources.chicken_alfredo
import intership12026.composeapp.generated.resources.cottage_cheese
import intership12026.composeapp.generated.resources.fruit_salad
import intership12026.composeapp.generated.resources.greek_yogurt
import intership12026.composeapp.generated.resources.grilled_chicken
import intership12026.composeapp.generated.resources.hummus_carrots
import intership12026.composeapp.generated.resources.lentil_soup
import intership12026.composeapp.generated.resources.mixed_nuts
import intership12026.composeapp.generated.resources.oatmeal
import intership12026.composeapp.generated.resources.pancakes
import intership12026.composeapp.generated.resources.pasta_primavera
import intership12026.composeapp.generated.resources.pork_tenderloin
import intership12026.composeapp.generated.resources.protein_bar
import intership12026.composeapp.generated.resources.quinoa_bowl
import intership12026.composeapp.generated.resources.rice_cakes
import intership12026.composeapp.generated.resources.salmon_asparagus
import intership12026.composeapp.generated.resources.scrambled_eggs
import intership12026.composeapp.generated.resources.shrimp_scampi
import intership12026.composeapp.generated.resources.smoothie_bowl
import intership12026.composeapp.generated.resources.steak_and_veggies
import intership12026.composeapp.generated.resources.turkey_sandwich
import intership12026.composeapp.generated.resources.user1
import intership12026.composeapp.generated.resources.user2
import intership12026.composeapp.generated.resources.user3
import intership12026.composeapp.generated.resources.user4
import intership12026.composeapp.generated.resources.vegetarian_lasagna
import intership12026.composeapp.generated.resources.veggie_wrap
import intership12026.composeapp.generated.resources.yogurt_parfait
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.compose.resources.DrawableResource

object AppData {

    private val _currentUser = MutableStateFlow<UserModel?>(null)
    val currentUser = _currentUser.asStateFlow()

    fun setCurrentUser(user: UserModel) {
        _currentUser.value = user
    }

    val users = mutableListOf(
        UserModel(
            email = "user1@example.com",
            password = "password123",
            firstName = "John",
            lastName = "Doe",
            attributes = UserAttributes(
                age = 25,
                height = 175,
                weight = 70f,
                activityLevel = "Moderate",
                healthGoal = "Maintenance",
                dailyCalories = 2000,
                proteinGrams = 150,
                carbGrams = 250,
                fatGrams = 60,
                consumedCalories = 1200,
                consumedProtein = 80,
                consumedCarbs = 150,
                consumedFats = 40
            ),
            profilePic = Res.drawable.user1,
            allergies = mutableListOf("Peanuts"),
            restrictions = mutableListOf("None")
        ),
        UserModel(
            email = "user2@example.com",
            password = "password456",
            firstName = "Jane",
            lastName = "Smith",
            attributes = UserAttributes(
                age = 30,
                height = 165,
                weight = 60f,
                activityLevel = "Active",
                healthGoal = "Weight Loss",
                dailyCalories = 2400,
                proteinGrams = 130,
                carbGrams = 300,
                fatGrams = 60,
                consumedCalories = 2100,
                consumedProtein = 120,
                consumedCarbs = 280,
                consumedFats = 70
            ),
            profilePic = Res.drawable.user2,
            allergies = mutableListOf("None"),
            restrictions = mutableListOf("Vegetarian")
        ),
        UserModel(
            email = "user3@example.com",
            password = "password789",
            firstName = "Bob",
            lastName = "Johnson",
            attributes = UserAttributes(
                age = 40,
                height = 180,
                weight = 85f,
                activityLevel = "Sedentary",
                healthGoal = "Muscle Gain",
                dailyCalories = 2400,
                proteinGrams = 130,
                carbGrams = 300,
                fatGrams = 60,
                consumedCalories = 1750,
                consumedProtein = 120,
                consumedCarbs = 280,
                consumedFats = 70
            ),
            profilePic = Res.drawable.user3,
            allergies = mutableListOf("Dairy"),
            restrictions = mutableListOf("Keto")
        ),
        UserModel(
            email = "user4@example.com",
            password = "password321",
            firstName = "Charlie",
            lastName = "Williams",
            attributes = UserAttributes(
                age = 22,
                height = 160,
                weight = 55f,
                activityLevel = "Very Active",
                healthGoal = "Endurance",
                dailyCalories = 2400,
                proteinGrams = 130,
                carbGrams = 300,
                fatGrams = 60,
                consumedCalories = 2100,
                consumedProtein = 120,
                consumedCarbs = 280,
                consumedFats = 70
            ),
            profilePic = Res.drawable.user4,
            allergies = mutableListOf("Shellfish"),
            restrictions = mutableListOf("Paleo")
        )
    )

    val recipes = listOf(
        RecipeModel(
            category = "Breakfast",
            title = "Pancakes",
            image = Res.drawable.pancakes,
            description = "Fluffy homemade pancakes",
            ingredients = listOf("Flour", "Milk", "Eggs", "Sugar"),
            steps = listOf("Mix dry ingredients", "Add wet ingredients", "Cook on griddle"),
            macros = listOf(10, 45, 12),
            calories = "320 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Greek Yogurt",
            image = Res.drawable.greek_yogurt,
            description = "Creamy Greek yogurt with honey",
            ingredients = listOf("Greek yogurt", "Honey", "Berries"),
            steps = listOf("Serve yogurt", "Add toppings"),
            macros = listOf(15, 10, 5),
            calories = "210 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Avocado Toast",
            image = Res.drawable.avocado_toast,
            description = "Classic avocado toast with egg",
            ingredients = listOf("Bread", "Avocado", "Egg"),
            steps = listOf("Toast bread", "Mash avocado", "Fry egg"),
            macros = listOf(12, 15, 20),
            calories = "350 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Oatmeal",
            image = Res.drawable.oatmeal,
            description = "Warm oatmeal with banana",
            ingredients = listOf("Oats", "Milk", "Banana"),
            steps = listOf("Boil oats", "Slice banana"),
            macros = listOf(8, 40, 6),
            calories = "280 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Smoothie Bowl",
            image = Res.drawable.smoothie_bowl,
            description = "Refreshing tropical smoothie bowl",
            ingredients = listOf("Mango", "Spinach", "Chia seeds"),
            steps = listOf("Blend fruits", "Pour into bowl"),
            macros = listOf(5, 35, 4),
            calories = "220 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Scrambled Eggs",
            image = Res.drawable.scrambled_eggs,
            description = "Fluffy scrambled eggs with toast",
            ingredients = listOf("Eggs", "Butter", "Bread"),
            steps = listOf("Whisk eggs", "Cook in pan"),
            macros = listOf(18, 15, 22),
            calories = "310 kcal"
        ),
        RecipeModel(
            category = "Breakfast",
            title = "Fruit Salad",
            image = Res.drawable.fruit_salad,
            description = "Fresh seasonal fruit mix",
            ingredients = listOf("Apple", "Orange", "Grapes"),
            steps = listOf("Chop fruit", "Mix together"),
            macros = listOf(2, 30, 1),
            calories = "150 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Chicken Alfredo",
            image = Res.drawable.chicken_alfredo,
            description = "Creamy pasta with grilled chicken",
            ingredients = listOf("Pasta", "Chicken breast", "Cream"),
            steps = listOf("Boil pasta", "Cook chicken", "Make sauce"),
            macros = listOf(35, 50, 25),
            calories = "620 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Caesar Salad",
            image = Res.drawable.caesar_salad,
            description = "Crispy salad with caesar dressing",
            ingredients = listOf("Lettuce", "Croutons", "Parmesan"),
            steps = listOf("Toss salad", "Add dressing"),
            macros = listOf(10, 15, 18),
            calories = "290 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Quinoa Bowl",
            image = Res.drawable.quinoa_bowl,
            description = "Nutritious bowl with roasted veggies",
            ingredients = listOf("Quinoa", "Zucchini", "Bell pepper"),
            steps = listOf("Cook quinoa", "Roast veggies"),
            macros = listOf(12, 45, 10),
            calories = "340 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Beef Tacos",
            image = Res.drawable.beef_tacos,
            description = "Spicy ground beef tacos",
            ingredients = listOf("Tortillas", "Ground beef", "Salsa"),
            steps = listOf("Cook beef", "Assemble tacos"),
            macros = listOf(25, 30, 18),
            calories = "410 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Lentil Soup",
            image = Res.drawable.lentil_soup,
            description = "Hearty homemade lentil soup",
            ingredients = listOf("Lentils", "Carrots", "Onion"),
            steps = listOf("Sauté veg", "Simmer lentils"),
            macros = listOf(15, 35, 4),
            calories = "260 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Turkey Sandwich",
            image = Res.drawable.turkey_sandwich,
            description = "Fresh turkey breast sandwich",
            ingredients = listOf("Whole wheat bread", "Turkey", "Lettuce"),
            steps = listOf("Spread mayo", "Layer sandwich"),
            macros = listOf(28, 32, 10),
            calories = "330 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Pasta Primavera",
            image = Res.drawable.pasta_primavera,
            description = "Pasta with fresh spring vegetables",
            ingredients = listOf("Pasta", "Broccoli", "Cherry tomatoes"),
            steps = listOf("Boil pasta", "Sauté vegetables"),
            macros = listOf(14, 55, 12),
            calories = "380 kcal"
        ),
        RecipeModel(
            category = "Lunch",
            title = "Veggie Wrap",
            image = Res.drawable.veggie_wrap,
            description = "Healthy wrap with hummus",
            ingredients = listOf("Tortilla", "Hummus", "Spinach"),
            steps = listOf("Spread hummus", "Roll wrap"),
            macros = listOf(10, 40, 12),
            calories = "310 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Steak & Veggies",
            image = Res.drawable.steak_and_veggies,
            description = "Juicy steak with roasted broccoli",
            ingredients = listOf("Beef steak", "Broccoli", "Garlic butter"),
            steps = listOf("Sear steak", "Roast broccoli"),
            macros = listOf(45, 10, 30),
            calories = "550 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Salmon & Asparagus",
            image = Res.drawable.salmon_asparagus,
            description = "Baked salmon with lemon",
            ingredients = listOf("Salmon fillet", "Asparagus", "Lemon"),
            steps = listOf("Season fish", "Bake at 200C"),
            macros = listOf(35, 5, 22),
            calories = "390 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Beef Stir-fry",
            image = Res.drawable.beef_stir_fry,
            description = "Quick stir-fry with soy sauce",
            ingredients = listOf("Beef strips", "Snap peas", "Soy sauce"),
            steps = listOf("Wok beef", "Add vegetables"),
            macros = listOf(32, 15, 18),
            calories = "360 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Grilled Chicken",
            image = Res.drawable.grilled_chicken,
            description = "Simple grilled chicken breast",
            ingredients = listOf("Chicken", "Rice", "Salad"),
            steps = listOf("Grill chicken", "Boil rice"),
            macros = listOf(40, 45, 8),
            calories = "420 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Shrimp Scampi",
            image = Res.drawable.shrimp_scampi,
            description = "Garlic butter shrimp over pasta",
            ingredients = listOf("Shrimp", "Garlic", "Linguine"),
            steps = listOf("Cook pasta", "Sauté shrimp"),
            macros = listOf(28, 48, 15),
            calories = "450 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Pork Tenderloin",
            image = Res.drawable.pork_tenderloin,
            description = "Roasted pork with herbs",
            ingredients = listOf("Pork", "Rosemary", "Potatoes"),
            steps = listOf("Sear meat", "Bake in oven"),
            macros = listOf(38, 30, 14),
            calories = "410 kcal"
        ),
        RecipeModel(
            category = "Dinner",
            title = "Vegetarian Lasagna",
            image = Res.drawable.vegetarian_lasagna,
            description = "Cheesy eggplant lasagna",
            ingredients = listOf("Eggplant", "Cheese", "Tomato sauce"),
            steps = listOf("Layer ingredients", "Bake till golden"),
            macros = listOf(22, 40, 20),
            calories = "440 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Yogurt Parfait",
            image = Res.drawable.yogurt_parfait,
            description = "Yogurt with granola and honey",
            ingredients = listOf("Yogurt", "Granola", "Honey"),
            steps = listOf("Layer yogurt", "Top with granola"),
            macros = listOf(12, 25, 6),
            calories = "210 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Mixed Nuts",
            image = Res.drawable.mixed_nuts,
            description = "Handful of roasted nuts",
            ingredients = listOf("Almonds", "Walnuts", "Cashews"),
            steps = listOf("Roast nuts", "Enjoy"),
            macros = listOf(6, 5, 18),
            calories = "180 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Apple Slices",
            image = Res.drawable.apple_slices,
            description = "Apple slices with peanut butter",
            ingredients = listOf("Apple", "Peanut butter"),
            steps = listOf("Slice apple", "Spread butter"),
            macros = listOf(4, 20, 10),
            calories = "190 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Hummus & Carrots",
            image = Res.drawable.hummus_carrots,
            description = "Crunchy carrots with hummus",
            ingredients = listOf("Carrots", "Hummus"),
            steps = listOf("Peel carrots", "Dip in hummus"),
            macros = listOf(5, 12, 8),
            calories = "140 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Protein Bar",
            image = Res.drawable.protein_bar,
            description = "Quick post-workout snack",
            ingredients = listOf("Protein blend", "Dark chocolate"),
            steps = listOf("Unwrap", "Eat"),
            macros = listOf(20, 25, 8),
            calories = "250 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Cottage Cheese",
            image = Res.drawable.cottage_cheese,
            description = "High-protein cottage cheese",
            ingredients = listOf("Cottage cheese", "Pineapple"),
            steps = listOf("Serve cold"),
            macros = listOf(14, 12, 3),
            calories = "130 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Rice Cakes",
            image = Res.drawable.rice_cakes,
            description = "Light snacks with rice cakes",
            ingredients = listOf("Rice cakes", "Cream cheese"),
            steps = listOf("Spread cheese"),
            macros = listOf(3, 15, 4),
            calories = "110 kcal"
        ),
        RecipeModel(
            category = "Snack",
            title = "Hard-boiled Eggs",
            image = Res.drawable.scrambled_eggs,
            description = "Simple protein snack",
            ingredients = listOf("Eggs"),
            steps = listOf("Boil eggs", "Peel shell"),
            macros = listOf(12, 1, 10),
            calories = "140 kcal"
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
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val attributes: UserAttributes,
    val profilePic: DrawableResource,
    val allergies: MutableList<String>,
    val restrictions: MutableList<String>
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
    val consumedCalories: Int,
    val consumedProtein: Int,
    val consumedCarbs: Int,
    val consumedFats: Int
)

data class RecipeModel(
    val category: String,   // "Breakfast", "Lunch", "Dinner", "Snack"
    val title: String,
    val image: DrawableResource,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val macros: List<Int>,
    val calories: String,
)

data class DailyPlan(
    val dayName: String, // e.g., "Monday"
    val meals: List<RecipeModel> = emptyList()
)

data class WeeklyPlan(
    val plans: List<DailyPlan>
)
