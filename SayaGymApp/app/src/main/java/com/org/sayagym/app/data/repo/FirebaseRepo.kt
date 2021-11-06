package com.org.sayagym.app.data.repo

import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepo {
    private val db = FirebaseFirestore.getInstance()



    fun setDataUser (name:String, lastName:String, age:String, size:String, finalSize:String, arms:String,
                     legs:String,shoulders:String,chest:String,finalArms:String,finalLegs:String,
                     finalShoulders:String, finalChest:String, email:String){

        db.collection("users_information").document(email)
            .get().addOnSuccessListener {
                if(it.exists() ){
                    db.collection("users_information").document(email)
                        .update(mapOf(
                            "name" to name,
                            "last name" to lastName,
                            "age" to age,
                            "size" to size,
                            "finalSize" to finalSize,
                            "arms" to arms,
                            "legs" to legs,
                            "shoulders" to shoulders,
                            "chest" to chest,
                            "finalArmas" to finalArms,
                            "finalLegs" to finalLegs,
                            "finalShoulders" to finalShoulders,
                            "finalChest" to finalChest
                        ))
                }else{
                    val  userHasMap = hashMapOf(
                        "name" to name,
                        "last name" to lastName,
                        "age" to age,
                        "size" to size,
                        "finalSize" to finalSize,
                        "arms" to arms,
                        "legs" to legs,
                        "shoulders" to shoulders,
                        "chest" to chest,
                        "finalArmas" to finalArms,
                        "finalLegs" to finalLegs,
                        "finalShoulders" to finalShoulders,
                        "finalChest" to finalChest
                    )
                    db.collection("users_information").document(email).set(userHasMap)
                }
            }
    }

    fun deleteDataUser(email:String){
        db.collection("users_information").document(email).delete()
    }
     fun dataCoach(email:String, coach:String){
         val userHashMap = hashMapOf(
             "coach" to coach
         )
        val save = db.collection("users_information").document(email)
         save.update("coach", coach)
     }
    }

