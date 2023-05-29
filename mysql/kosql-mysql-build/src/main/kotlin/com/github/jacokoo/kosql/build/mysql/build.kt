package com.github.jacokoo.kosql.build.mysql

import com.github.jacokoo.kosql.build.DefaultBuilder
import com.github.jacokoo.kosql.build.DefaultContext
import com.github.jacokoo.kosql.build.DefaultPart

class MySQLPart: DefaultPart()

class MySQLBuilder(part: MySQLPart = MySQLPart()): DefaultBuilder(part)

class MySQLContext(builder: MySQLBuilder = MySQLBuilder()): DefaultContext(builder)
