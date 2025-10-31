package com.back.domain.wiseSaying.service

import com.back.domain.wiseSaying.entity.WiseSaying

class WiseSayingService {

    var lastId = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    fun write(content: String, author: String): WiseSaying {
        val id = ++lastId

        return WiseSaying(id, content, author).also {
            wiseSayings.add(it)
        }
    }

    fun findAll() = wiseSayings.toList()

    fun findById(id: Int): WiseSaying? =
        wiseSayings.firstOrNull { it.id == id }

    fun delete(wiseSaying: WiseSaying) = wiseSayings.remove(wiseSaying)


}