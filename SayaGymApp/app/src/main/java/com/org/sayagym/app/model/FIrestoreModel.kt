package com.org.sayagym.app.model

import com.org.sayagym.app.domain.FirebaseCaseUse

class FIrestoreModel {
val firebaseCaseUse = FirebaseCaseUse()
    fun createUser(name:String, lastName:String, age:String, size:String, finalSize:String, arms:String,
                   legs:String,shoulders:String,chest:String,finalArms:String,finalLegs:String,
                   finalShoulders:String, finalChest:String, email:String){
        firebaseCaseUse.setUserData(name, lastName, age, size, finalSize, arms, legs, shoulders, chest,
                                    finalArms, finalLegs, finalShoulders, finalChest, email)

    }
}