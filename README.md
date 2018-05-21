# KoSQL - 写类型安全的SQL语句

`KoSQL`是一个直接在`Kotlin`代码中写带有`类型检查`, `对象映射`等功能的`"原生SQL语句"`的框架

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
    ```
