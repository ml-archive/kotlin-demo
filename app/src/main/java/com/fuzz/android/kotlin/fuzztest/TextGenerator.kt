package com.fuzz.android.kotlin.fuzztest

/**
 * Created by cesaraguilar on 1/5/16.
 */
class TextGenerator {

    public fun generateText(): String {
        return "This text came from TextGenerator.kt"
    }

}

class SecondGenerator {
    public fun generateText(): String {
        return "Second generator also inside TextGenerator.kt"
    }
}
