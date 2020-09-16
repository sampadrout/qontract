package run.qontract.core.value

import run.qontract.core.ExampleDeclarations
import run.qontract.core.pattern.BooleanPattern
import run.qontract.core.pattern.ExactValuePattern
import run.qontract.core.pattern.Pattern

data class BooleanValue(val booleanValue: Boolean) : Value, ScalarValue {
    override val httpContentType = "text/plain"

    override fun displayableValue(): String = toStringValue()
    override fun toStringValue() = booleanValue.toString()
    override fun displayableType(): String = "boolean"
    override fun exactMatchElseType(): Pattern = ExactValuePattern(this)
    override fun type(): Pattern = BooleanPattern

    override fun typeDeclarationWithKey(key: String, types: Map<String, Pattern>, exampleDeclarations: ExampleDeclarations): Pair<TypeDeclaration, ExampleDeclarations> =
            primitiveTypeDeclarationWithKey(key, types, exampleDeclarations, displayableType(), booleanValue.toString())

    override fun listOf(valueList: List<Value>): Value {
        return JSONArrayValue(valueList)
    }

    override fun typeDeclarationWithoutKey(exampleKey: String, types: Map<String, Pattern>, exampleDeclarations: ExampleDeclarations): Pair<TypeDeclaration, ExampleDeclarations> =
            primitiveTypeDeclarationWithoutKey(exampleKey, types, exampleDeclarations, displayableType(), booleanValue.toString())

    override fun toString() = booleanValue.toString()
}

val True = BooleanValue(true)
