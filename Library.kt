import java.util.*

data class Book(
    val id: Int,
    val name: String,
    val author: String,
    var isIssued: Boolean = false
)

fun main() {

    val scanner = Scanner(System.`in`)
    val library = mutableListOf<Book>()

    while (true) {
        println("\n===== LIBRARY MANAGEMENT SYSTEM =====")
        println("1. Add Book")
        println("2. View Books")
        println("3. Issue Book")
        println("4. Return Book")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {

            1 -> {
                print("Enter Book ID: ")
                val id = scanner.nextInt()
                scanner.nextLine()

                print("Enter Book Name: ")
                val name = scanner.nextLine()

                print("Enter Author Name: ")
                val author = scanner.nextLine()

                library.add(Book(id, name, author))
                println("Book Added Successfully!")
            }

            2 -> {
                if (library.isEmpty()) {
                    println("No books available.")
                } else {
                    println("\nAvailable Books:")
                    for (book in library) {
                        println("ID: ${book.id}, Name: ${book.name}, Author: ${book.author}, Issued: ${book.isIssued}")
                    }
                }
            }

            3 -> {
                print("Enter Book ID to Issue: ")
                val id = scanner.nextInt()
                val book = library.find { it.id == id }

                if (book != null && !book.isIssued) {
                    book.isIssued = true
                    println("Book Issued Successfully!")
                } else {
                    println("Book not available or already issued.")
                }
            }

            4 -> {
                print("Enter Book ID to Return: ")
                val id = scanner.nextInt()
                val book = library.find { it.id == id }

                if (book != null && book.isIssued) {
                    book.isIssued = false
                    println("Book Returned Successfully!")
                } else {
                    println("Invalid Book ID or Book was not issued.")
                }
            }

            5 -> {
                println("Thank you for using Library Management System!")
                break
            }

            else -> println("Invalid Choice! Please try again.")
        }
    }
}
