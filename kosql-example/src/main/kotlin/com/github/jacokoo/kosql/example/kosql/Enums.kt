package com.github.jacokoo.kosql.example.kosql

import com.github.jacokoo.kosql.compose.IntEnumType
import com.github.jacokoo.kosql.compose.StringEnumType
import com.github.jacokoo.kosql.example.Color
import com.github.jacokoo.kosql.example.State

class AbcTableColorEnumType: IntEnumType<Color>() {
    override val clazz: Class<Color> = Color::class.java
    override val nullValue: Color = Color.RED
}

class AbcTableStateEnumType: StringEnumType<State>() {
    override val clazz: Class<State> = State::class.java
    override val nullValue: State = State.INIT
}
