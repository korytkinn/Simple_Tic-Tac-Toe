package tictactoe

var finalState: String = ""

fun main() {
    // Создаём двумерный массив
    var field = arrayOf<Array<String>>()

// заполняем нулями
    for (i in 0..2) {
        var array = arrayOf<String>()
        for (j in 0..2) {
            array += " "
        }
        field += array
    }

    //выводим пустое поле для игры
    outputState(field, 0, 0, null)


    var aIntFinal = 0
    var bIntFinal = 0

    var point = 1

    for (j in 0..1000) {

        for (i in 0..100) {
            print("Enter the coordinates: ")
            val (a, b) = readLine()!!.split(" ")


            val aInt = a.toIntOrNull()
            val bInt = b.toIntOrNull()
            if (aInt == null || bInt == null) {
                println("You should enter numbers!\n")
                continue
            }


            if ((aInt > 3 || aInt < 1) || (bInt > 3 || bInt < 1)) {
                println("Coordinates should be from 1 to 3!\n")
                continue
            }



            if (field[aInt - 1][bInt - 1] != " ") {
                println("This cell is occupied! Choose another one!\n")
                continue
            }

            aIntFinal = a.toInt()
            bIntFinal = b.toInt()

            break
        } //конец внутреннего FOR
        if (point % 2 == 0) {
            outputState(field, aIntFinal - 1, bIntFinal - 1, "O")
        } else {
            outputState(field, aIntFinal - 1, bIntFinal - 1, "X")
        }
        point++

        var counter = 0
        for (k in 0..2) {
            for (m in 0..2) {
                if (field[k][m] != " ") {
                    counter++
                }
            }
        }
        if (counter >= 5) {
            stateChecker(field)
            when (finalState) {
                "X wins" -> return
                "O wins" -> return
                "Impossible" -> if (counter == 9) {
                    return
                }
                "Game not finished" -> continue
                "Draw" -> if (counter == 9) {
                    return
                }
            }
        }

    }
    println("a=$aIntFinal, b=$bIntFinal")  // ЗАЧЕМ ЭТО?

}

fun outputState(field: Array<Array<String>>, n: Int, m: Int, number: String?) {
    if (number != null) {
        field[n][m] = number
    }

    // выводим данные массива
    println("---------")
    for (i in 0..2) {
        for (j in 0..2) {
            if (j == 0) {
                print("| ")
            }

            print("${field[i][j]} ")

            if (j == 2) {
                print("|")
            }
        }
        println()
    }
    println("---------")

}

fun stateChecker(field: Array<Array<String>>) {
    var xP1 = 0
    var xP2 = 0


// дубовый вариант проверки невозможности столбцы
    //Столбцы первый X и второй O
    for (i in 0..2) {
        if (field[i][0] == "X") {
            xP1++
        }
        if (field[i][1] == "O") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Столбцы первый O и второй X
    xP1 = 0
    xP2 = 0
    for (i in 0..2) {
        if (field[i][0] == "O") {
            xP1++
        }
        if (field[i][1] == "X") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Столбцы первый X и третий O
    xP1 = 0
    xP2 = 0
    for (i in 0..2) {
        if (field[i][0] == "X") {
            xP1++
        }
        if (field[i][2] == "O") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Столбцы первый O и третий X
    xP1 = 0
    xP2 = 0
    for (i in 0..2) {
        if (field[i][0] == "O") {
            xP1++
        }
        if (field[i][2] == "X") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Столбцы второй X и третий O
    xP1 = 0
    xP2 = 0
    for (i in 0..2) {
        if (field[i][1] == "X") {
            xP1++
        }
        if (field[i][2] == "O") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Столбцы второй O и третий X
    xP1 = 0
    xP2 = 0
    for (i in 0..2) {
        if (field[i][1] == "O") {
            xP1++
        }
        if (field[i][2] == "X") {
            xP2++
        }
    }
    if (xP1 == 3 && xP2 == 3) {
        finalState = "Impossible"
        println("Impossible")
        return
    }


    var xPoints = 0
    var oPoints = 0

    //по строкам

    for (i in 0..2) {
        for (j in 0..2) {
            if (field[i][j] == "X") {
                xPoints++
            } else if (field[i][j] == "O") {
                oPoints++
            }
        }
        if (xPoints == 3) {
            finalState = "X wins"
            println("X wins")
            return
        }
        if (oPoints == 3) {
            finalState = "O wins"
            println("O wins")
            return
        }
        xPoints = 0
        oPoints = 0
    }

    xPoints = 0
    oPoints = 0
//по столбцам
    for (j in 0..2) {
        for (i in 0..2) {
            if (field[i][j] == "X") {
                xPoints++
            } else if (field[i][j] == "O") {
                oPoints++
            }
        }

        /*
        if (xPoints == 3 && oPoints == 3) {
            println("Impossible")
            return
        }
         */

        if (xPoints == 3) {
            finalState = "X wins"
            println("X wins")
            return
        }
        if (oPoints == 3) {
            finalState = "O wins"
            println("O wins")
            return
        }
        xPoints = 0
        oPoints = 0
    }
    xPoints = 0
    oPoints = 0

    //диагональ главная
    for (i in 0..2) {
        if (field[i][i] == "X") {
            xPoints++
        } else if (field[i][i] == "O") {
            oPoints++
        }
    }
    if (xPoints == 3) {
        finalState = "X wins"
        println("X wins")
        return
    }
    if (oPoints == 3) {
        finalState = "O wins"
        println("O wins")
        return
    }

    xPoints = 0
    oPoints = 0

    //диагональ побочная
    for (i in 0..2) {
        if (field[i][2 - i] == "X") {
            xPoints++
        } else if (field[i][2 - i] == "O") {
            oPoints++
        }
    }
    if (xPoints == 3) {
        finalState = "X wins"
        println("X wins")
        return
    }
    if (oPoints == 3) {
        finalState = "O wins"
        println("O wins")
        return
    }

    // Подсчет числа крестиков и ноликов
    var krestik = 0
    var nolik = 0

    for (i in 0..2) {
        for (j in 0..2) {
            if (field[i][j] == "X") {
                krestik++
            } else if (field[i][j] == "O") {
                nolik++
            }
        }
    }
    if (krestik - nolik != 0 && krestik - nolik != 1) {
        finalState = "Impossible"
        println("Impossible")
        return
    }

    //Обработка новых состояний NEW - 1)
    var space = 0
    for (i in 0..2) {
        for (j in 0..2) {
            if (field[i][j] == "_")
                space++
        }
    }
    if (space != 0) {
        finalState = "Game not finished"
        println("Game not finished")
        return
    } else if (space == 0) {
        finalState = "Draw"
        println("Draw")
        return
    }

}