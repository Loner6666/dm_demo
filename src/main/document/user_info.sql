
CREATE TABLE "temtest"."user_info"
(
"id" INT IDENTITY(1, 1) NOT NULL,
"name" VARCHAR(50),
"age" INT,
NOT CLUSTER PRIMARY KEY("id")) STORAGE(ON "SYSTEM", CLUSTERBTR) ;
COMMENT ON TABLE "temtest"."user_info" IS '用户表——临时测试';
COMMENT ON COLUMN "temtest"."user_info"."id" IS '用户id';
COMMENT ON COLUMN "temtest"."user_info"."name" IS '用户名';
COMMENT ON COLUMN "temtest"."user_info"."age" IS '年龄';

===============================================================

drop table "temtest"."user_info";

===============================================================

select "id","name","age"
from "temtest"."user_info";

===============================================================

insert into "temtest"."user_info"("id", "name", "age")
VALUES(<"id", INT>, <"name", VARCHAR(50)>, <"age", INT>);

===============================================================

update "temtest"."user_info"
set "id" = <"id", INT>, "name" = <"name", VARCHAR(50)>, "age" = <"age", INT>;

===============================================================

delete from "temtest"."user_info";
