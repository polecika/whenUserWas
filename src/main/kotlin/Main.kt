import java.lang.Exception

fun main() {
    while(true) {
        println("Добрый день. Введите количество секунд, отсутсвия пользователя. (Нажмите на любую букву, не цифру, для выхода)")
        try {
            val seconds: Int = readLine()?.toInt() ?: 0
            agoToText(seconds)
        } catch (e: Exception) {
            break
        }
    }
}

fun agoToText(seconds: Int) {
    val days = seconds / (24 * 3600)
    val hours = (seconds % (24 * 3600)) / 3600
    val minutes = (seconds % 3600) / 60
    val sec = seconds % 60



    println("Калькулятор времени (для более удобной проверки): $days дней, $hours ${hoursCount(hours)}, $minutes ${minutesCount(minutes)}, $sec сек")
    println("--------------------------------------------------------------------------")
    when {
        ((seconds > 0) && (seconds <= 60)) -> println("Пользователь был только что")
        ((seconds > 60) && (seconds <= 60 * 60)) -> println("Пользователь был $minutes ${minutesCount(minutes)} назад")
        ((seconds > 60 * 60) && (seconds <= 24 * 60 * 60)) -> println("Пользователь был $hours ${hoursCount(hours)} назад")
        ((seconds > 24 * 60 * 60) && (seconds <= 2 * 24 * 60 * 60)) -> println("Пользователь был сегодня")
        ((seconds > 2 * 24 * 60 * 60) && (seconds <= 3 * 24 * 60 * 60)) -> println("Пользователь был вчера")
        (seconds > 3 * 24 * 60 * 60) -> println("Пользователь был давно")
        else -> println("Согласно теории отностительности, секунды не могут быть отрицательными :)")
    }
    println("--------------------------------------------------------------------------")
}


fun minutesCount(minuteQuantity: Int): String {
    val minutu: String = "минуту"
    val minuti: String = "минуты"
    val minut: String = "минут"

    if (minuteQuantity == 11 || minuteQuantity == 12 || minuteQuantity == 13 || minuteQuantity == 14) {
        return minut
    }
    return when (minuteQuantity % 10) {
        1 -> minutu
        2, 3, 4 -> minuti
        else -> minut
    }
}

fun hoursCount(hourQuantity: Int): String {
    val hour: String = "час"
    val hours: String = "часа"
    val moreHours: String = "часов"
    if (hourQuantity == 11 || hourQuantity == 12 || hourQuantity == 13 || hourQuantity == 14) {
        return moreHours
    }
    return when (hourQuantity % 10) {
        1 -> hour
        2, 3, 4 -> hours
        else -> moreHours
    }
}