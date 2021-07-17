package com.github.jacokoo.kosql.mysql.spring

import com.github.jacokoo.kosql.build.mysql.MySQLBuilder
import com.github.jacokoo.kosql.build.mysql.MySQLContext
import com.github.jacokoo.kosql.execute.spring.jdbc.KoSQL
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.PlatformTransactionManager

class MySQLKoSQL(jdbc: JdbcTemplate, tx: PlatformTransactionManager):
    KoSQL(jdbc, tx, MySQLBuilder(), {MySQLContext(it as MySQLBuilder)})
