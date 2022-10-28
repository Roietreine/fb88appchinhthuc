package project.rr.fb88appchnhthc.common

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DbFirebase {
    lateinit var databaseReference: DatabaseReference
    fun getDatabase(): DatabaseReference {
        val database = FirebaseDatabase.getInstance()
        databaseReference = database.getReference("jumpcode")
        return databaseReference
    }
}