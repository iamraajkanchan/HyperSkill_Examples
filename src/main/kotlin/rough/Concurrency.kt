package rough

fun main() {
    val thread = Thread {
        println("${Thread.currentThread().name} is running")
    }
    thread.start()

    val thread1 = Thread {
        println("${Thread.currentThread().name} is running")
    }
    thread1.start()

    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    repeat(3) {
        Thread {
            println("${Thread.currentThread().name} has started")
            for(item in states) {
                println("${Thread.currentThread()} - $item")
                Thread.sleep(500)
            }
        }.start()
    }
}