package br.com.nicemc.account

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("br.com.nicemc.account")
        .start()
}