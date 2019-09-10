## mybatis-plus generator demo

1. 参数都写死在`cc.sitec.generator.GeneratorServiceEntity`了，根据库和表改改.
2. 分库分表的表名由于带了编号。建议在本地数据库弄个没编号的来执行映射。

### 替换
```
com.baomidou.mybatisplus.annotation.IdType
替换成
com.baomidou.mybatisplus.enums.IdType

com.baomidou.mybatisplus.annotation.TableId
替换成
com.baomidou.mybatisplus.annotations.TableId
```