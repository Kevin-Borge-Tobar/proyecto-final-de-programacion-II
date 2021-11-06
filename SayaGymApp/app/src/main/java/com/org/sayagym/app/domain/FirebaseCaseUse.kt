package com.org.sayagym.app.domain

import com.org.sayagym.app.data.repo.FirebaseRepo


class FirebaseCaseUse {
    val repo = FirebaseRepo()

    fun setUserData(name:String, lastName:String, age:String, size:String, finalSize:String, arms:String,
                    legs:String,shoulders:String,chest:String,finalArms:String,finalLegs:String,
                    finalShoulders:String, finalChest:String, email:String){
        repo.setDataUser(name, lastName, age, size, finalSize, arms, legs, shoulders, chest,
            finalArms, finalLegs, finalShoulders, finalChest, email)

    }
}