package com.back

class App {
    fun run() {
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()

        println("== 명언 앱 ==")

        while (true) {
            print("명언) ")
            val input = readln().trim()

            val rq: Rq = Rq(input)

            when (rq.action) {
                "종료" -> {
                    break
                }

                "등록" -> {
                    print("명언: ")
                    val content = readln().trim()

                    print("작가: ")
                    val author = readln().trim()
                    val id = ++lastId

                    wiseSayings.add(WiseSaying(id, content, author))
                    println("${id}번 명언이 등록되었습니다.")
                }

                "목록" -> {
                    println("번호 / 작가 / 명언")
                    println("----------------------")

                    wiseSayings.reversed().forEach {
                        println("${it.id} / ${it.author} / ${it.content}")
                    }
                }

                "삭제" -> {
                    val id = rq.getParamValueAsInt("id", 0)

                    if (id == 0) {
                        println("id를 정확히 입력해주세요.")
                        continue
                    }

                    val wiseSaying = wiseSayings.firstOrNull {
                        it.id == id
                    }

                    if (wiseSaying == null) {
                        println("${id}번 명언은 존재하지 않습니다.")
                        continue
                    }

                    wiseSayings.remove(wiseSaying)
                    println("${id}번 명언이 삭제되었습니다.")
                }
            }
        }
    }
}