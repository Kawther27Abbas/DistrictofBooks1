import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet
import java.sql.SQLException

import kotlin.jvm.JvmStatic;

object connection {

    @JvmStatic
    fun connectionToDB() {
        try {
            val c = DriverManager.getConnection(
                "jdbc:mysql://localhost?serverTimezone=UTC",
                "dob",
                "dob1234"
            )
            println("connected")
            //val s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
            //val r = s.executeQuery("select")
        }
        catch (e: SQLException){
            e.printStackTrace()
        }

    }

}
