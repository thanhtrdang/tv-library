package io.i101.library.tv

import reactor.core.publisher.Mono
import reactor.core.publisher.MonoSink

typealias TransformerFactory = Transformer.Factory

/**
 * Custom transformer guideline:
 *
 * Step 1: Create custom transformer
 *      private object CustomTransformer: Transformer<String, Date> {
 *          override fun doTransform(value: String, sink: MonoSink<Date>) {
 *              code implemented in here
 *          }
 *      }
 *
 * Step 2: Register custom transformer
 *      fun TransformerFactory.custom(value: String) = CustomTransformer.transform(value)
 *
 * Step 3: Use custom transformer
 *      Transformer.custom("value to transform")
 *
 * @param V Value type to transform
 * @param T Result type is transformed to
 */
interface Transformer<in V, T> {
    /**
     * Implement this fun directly in case of full customization.
     */
    fun transform(value: V): Mono<T> = Mono.create<T> { sink -> doTransform(value, sink) }

    /**
     * By default, use Mono.create to implement transformation.
     * Almost of subclasses should implement this fun first,
     * before consider fun transform(V) directly.
     */
    fun doTransform(value: V, sink: MonoSink<T>) {
        println("${javaClass.simpleName}($value) is NOT implemented yet")
    }

    companion object Factory
}