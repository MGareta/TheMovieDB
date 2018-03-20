package mgareta.themoviedb.base

import junit.framework.Assert.fail

/**
 * Created by marc on 19/03/18.
 */

open class BaseTest {

    private fun waitFor(time: Int) {
        try {
            Thread.sleep(time.toLong())
        } catch (e: Exception) {
            fail()
        }
    }

    protected fun waitForCondition(condition: Condition, time: Int) {
        var timeWaited = 0

        while (timeWaited < time) {
            if (condition.isSatisfied)
                return

            waitFor(200)
            timeWaited += 200
        }
    }
}