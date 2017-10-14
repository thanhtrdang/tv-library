package io.i101.library.tv

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object TransformerTests: Spek({
    describe(Transformer::class.java.simpleName) {
        it("chain of transformers") {
//            val transformer = Transformer.normalizeSpace(" Hello,  hallo,    ciao éclair   ")
//                    .flatMap {Transformer.stripAccents(it)}
//            transformer.test()
//                    .expectNext("Hello, hallo, ciao eclair")
//                    .verifyComplete()
        }
    }
})