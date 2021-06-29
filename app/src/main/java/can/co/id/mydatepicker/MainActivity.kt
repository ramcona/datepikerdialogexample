package can.co.id.mydatepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var myCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTanggal = findViewById<TextView>(R.id.main_tv_tanggal)

        tvTanggal.setOnClickListener {
            DatePickerDialog(
               this,
                { datePicker, i, i1, i2 ->
                    myCalendar.set(Calendar.YEAR, i)
                    myCalendar.set(Calendar.MONTH, i1)
                    myCalendar.set(Calendar.DAY_OF_MONTH, i2)

                    val fromTanggal = "yyyy-MM-dd"
                    val dateFormat = SimpleDateFormat(fromTanggal)
                    tvTanggal.text = dateFormat.format(myCalendar.time)
                },
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}