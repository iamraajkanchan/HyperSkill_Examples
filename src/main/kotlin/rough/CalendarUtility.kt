package rough

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale

class CalendarUtility {
    companion object {
        // Note: HashMap is replaced with LinkedHashMap to maintain the consistency of key-values inserted.
        private val dateMaps: LinkedHashMap<String, List<String>> = LinkedHashMap()

        @JvmStatic
        fun main(args: Array<String>) {
            repeat(100) { print("=") }.also { println() }
            println("Get value of Months")
            repeat(100) { print("=") }.also { println() }
            val months = arrayListOf(getMonthString(0), getMonthString(-1), getMonthString(-2))
            months.forEach { println(it) }
            repeat(100) { print("=") }.also { println() }
            println("Get keys from Date Maps")
            repeat(100) { print("=") }.also { println() }
            for (key in dateMaps.keys) {
                println(key)
            }
            repeat(100) { print("=") }.also { println() }
            println("Get values from Date Maps")
            repeat(100) { print("=") }.also { println() }
            for (value in dateMaps.values) {
                println(value)
            }
            repeat(100) { print("=") }.also { println() }
        }

        private fun getMonthString(amount: Int): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MONTH, amount)
            val monthString = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).format(calendar.time)
            val tempMonthValue = calendar.get(Calendar.MONTH + 1)
            val tempYearValue = calendar.get(Calendar.YEAR)
            dateMaps[monthString] = listOf(
                getFirstDate(tempMonthValue, tempYearValue),
                getLastDate(tempMonthValue, tempYearValue)
            )
            return SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).format(calendar.time)
        }

        private fun getFirstDate(month: Int, year: Int): String = "01-${convertMonthString(month)}-$year"

        private fun getLastDate(month: Int, year: Int): String {
            val calendar = GregorianCalendar(year, month, 0)
            val lastDate = SimpleDateFormat("dd", Locale.ENGLISH).format(calendar.time)
            return "$lastDate-${convertMonthString(month)}-$year"
        }

        private fun convertMonthString(month: Int): String = if (month < 10) "0$month" else "$month"
    }
}