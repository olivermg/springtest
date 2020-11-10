package ow.test.demo

import java.util.concurrent.atomic.AtomicLong

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController {

    private val template: String = "Hello %s!"
    private val counter: AtomicLong = new AtomicLong()

    @GetMapping(Array("/foo"))
    def foo(@RequestParam(value = "name", defaultValue = "World") name: String): Foo = {
        new Foo(
            counter.incrementAndGet(),
            String.format(template, name)
        )
    }
}
