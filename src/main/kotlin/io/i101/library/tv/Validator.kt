package io.i101.library.tv

import reactor.core.publisher.Mono
import reactor.core.publisher.MonoSink

typealias ValidatorFactory = Validator.Factory

/**
 * Custom validator guideline:
 *
 * Step 1: Create custom validator
 *      private object CustomValidator: Validator<String> {
 *          override fun doValidate(value: String, sink: MonoSink<String>) {
 *              code implemented in here
 *          }
 *      }
 *
 * Step 2: Register custom validator
 *      fun ValidatorFactory.custom(value: String) = CustomValidator.validate(value)
 *
 * Step 3: Use custom validator
 *      Validator.custom("value to validate")
 *
 * @param V Value type to validate
 */
interface Validator<V> {
    /**
     * Implement this fun directly in case of full customization.
     */
    fun validate(value: V): Mono<V> = Mono.create<V> { sink -> doValidate(value, sink) }

    /**
     * By default, use Mono.create to implement validation.
     * Almost of subclasses should implement this fun first,
     * before consider fun validate(V) directly.
     */
    fun doValidate(value: V, sink: MonoSink<V>) {
        println("${javaClass.simpleName}($value) is NOT implemented yet")
    }

    companion object Factory
}