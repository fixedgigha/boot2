package fixedgigha.boot2

import com.google.common.collect.Iterables.concat
import com.google.common.collect.Iterables.toArray
import com.google.common.collect.Lists
import org.junit.Test

class GuavaTest {

    @Test
    fun test1() {
        val l1 = Lists.newArrayList("Hello", "How", "Are")
        val l2 = Lists.newArrayList("You", "Today")

        val arr = toArray(concat(l1, l2), String::class.java)
        println(varg(*arr))
    }

    fun varg(vararg s: String) : String =  s.asList().toString()

}
