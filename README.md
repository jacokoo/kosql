# KoSQL - 写类型安全的SQL语句

`KoSQL`是一个直接在`Kotlin`代码中写带有`类型检查`, `对象映射`等功能的`"原生SQL语句"`的框架

# 功能

* 类型安全, 包括`SQL`包括语法, 表名, 列名, 列数据类型
* 简单, 语法基本接近`原生SQL`
* 没有反射
* 代码生成, 直接从数据库生成代码
* 简洁, 把逻辑写在代码中, 避免太过复杂的 SQL 语句. 如果需要扩展也很容易
    * 语句: `SELECT`, `UPDATE`, `INSERT`, `DELETE`
    * 函数: `count`, `distinct`, `sum`, `avg`, `min`, `max`
* 简化查询语句拼接, 可能为`null`的条件查询跟写正常的查询方式一样
* DAO 支持

# 示例

* 直接写`SQL`

    ```kotlin
    // insert into t_order(f_customer_id, f_order_number) values(?, ?)
    val (id, rows) = execute( // returns generated id and rows effected
        INSERT INTO ORDER(ORDER.CUSTOMER_ID, ORDER.ORDER_NUMBER) VALUES V(100, "order_number")
    )

    // update t_order set f_customer_id = ?, f_order_number = ? where f_id = ?
    val rows = execute(UPDATE(ORDER) SET { // returns rows effected
        it[ORDER.CUSTOMER_ID] = 100
        it[ORDER.ORDER_NUMBER] = "abc"
    } WHERE ORDER.ID EQ 1)

    // delete from t_order where f_id = ?
    val rows = execute(DELETE FROM ORDER WHERE ORDER.ID EQ 1) // returns rows effected

    // select * from t_order where f_id = ?
    val list: List<Order> = SELECT(-ORDER) {
        FROM(ORDER) WHERE ORDER.ID EQ 1
    }.fetch(Order::class)

    val optionalId: Int? = 100
    val optionalAmount: BigDecimal? = null
    // select f_id, f_total_amount from t_order where f_id = 100
    // ORDER.TOTAL_AMOUNT GT optionalAmount is ignored because optionalAmount is null
    SELECT(ORDER.ID, ORDER.TOTAL_AMOUNT) {
        FROM(ORDER) WHERE ORDER.ID EQ optionalId AND ORDER.TOTAL_AMOUNT GT optionalAmount
    }.fetch().map { (id: Int, amount: BigDecimal) ->
        println(id.inc())
        println(amount.divide(10.toBigDecimal()))
    }
    ```

* 使用`DAO`

    ```kotlin
    val order = Order().also {
        it.customerId = 100
        it.orderNumber = "order_number"
    }
    // insert into t_order(f_customer_id, f_order_number) values(?, ?)
    val id: Int? = order.save() // returns generated id
    assert(id == order.id) // true

    // select * from t_order where f_id = ?
    val order: Order = ORDER.byId(100)

    // delete from t_order where f_id = ?
    val success: Boolean = ORDER.delete(100)

    // select * from t_order where f_id = 100
    // ORDER.TOTAL_AMOUNT GT optionalAmount is ignored because optionalAmount is null
    val orders: List<Order> = ORDER.fetch(ORDER.ID EQ optionalId AND (ORDER.TOTAL_AMOUNT GT optionalAmount))
    ```
