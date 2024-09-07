---
title: forum
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.23"

---

# forum接口文档

Base URLs:

* <a href="http://localhost">测试环境: http://localhost</a>

# Authentication

# StickController控制器

## GET test

GET /stick/test

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": "测试",
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 获取所有帖子（包含用户部分信息

POST /stick/getSticks

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {},
  "msg": ""
}
```

```json
{
  "code": 0,
  "data": {
    "sticks": [
      {
        "mstars": 0,
        "mreplies": 0,
        "mid": 94,
        "uid": 1,
        "mcontent": "",
        "mtitle": "111",
        "uname": "yangming",
        "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
        "mlike": 8
      },
      {
        "mstars": 0,
        "mreplies": 2,
        "mid": 92,
        "uid": 2,
        "mcontent": "数组指针是指向数组的指针，但是数组指针数组是一个数组里面包含若干个数组指针，但是疑问点来了，数组指针是一个地址指向数组，可数组指针数组里面一个数组包含若干个指针去指向那个数组，这个叫数组指针数组。但是数组里面包含指针，不应该是指针数组吗？为什么我看教学上都是叫数组指针数组？真的学蒙了。",
        "mtitle": "求救！这个数组指针真是给我学蒙了。",
        "uname": "Mr.B",
        "uavatar": "/uploadFile/2/a5533032-9b4d-422a-a8ab-a487c367da64.jpg",
        "mlike": 1
      },
      {
        "mstars": 0,
        "mreplies": 1,
        "mid": 88,
        "uid": 1,
        "mcontent": "记录！！\n这是本项目的第一个帖子。\n",
        "mtitle": "hello world",
        "uname": "yangming",
        "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
        "mlike": 1
      }
    ],
    "pictures": [
      {
        "mid": 94,
        "uid": 1,
        "pname": "/uploadFile/1/5dafb2aa-346d-4720-a1fe-d82c3acd3696.jpg",
        "pid": 75
      },
      {
        "mid": 95,
        "uid": 2,
        "pname": "/uploadFile/2/fa8a5406-3a2b-4b22-98cb-82df456c8a3a.jpg",
        "pid": 76
      },
      {
        "mid": 96,
        "uid": 2,
        "pname": "/uploadFile/2/86b7dd08-c4d8-4564-a71a-1da3b217748e.jpg",
        "pid": 77
      },
      {
        "mid": 97,
        "uid": 1,
        "pname": "/uploadFile/1/64474578-6ce2-4d0b-a271-e067e819e428.jpg",
        "pid": 78
      }
    ]
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 按mID获得主贴信息（包含用户部分信息

GET /stick/getStick/{mID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "stickVo": {
      "mstars": 0,
      "mreplies": 1,
      "mid": 88,
      "uid": 1,
      "mcontent": "记录！！\n这是本项目的第一个帖子。\n",
      "mtitle": "hello world",
      "uname": "yangming",
      "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
      "mlike": 1
    },
    "pictures": []
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» stickVo|object|true|none||none|
|»»» mstars|integer|true|none||none|
|»»» mreplies|integer|true|none||none|
|»»» mid|integer|true|none||none|
|»»» uid|integer|true|none||none|
|»»» mcontent|string|true|none||none|
|»»» mtitle|string|true|none||none|
|»»» uname|string|true|none||none|
|»»» uavatar|string|true|none||none|
|»»» mlike|integer|true|none||none|
|»» pictures|[string]|true|none||none|
|» msg|string|true|none||none|

## GET 按uID获取该用户的主贴

GET /stick/getUserSticks/{uid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": [
    {
      "mstars": 0,
      "mreplies": 1,
      "mid": 88,
      "uid": 1,
      "mcontent": "记录！！\n这是本项目的第一个帖子。\n",
      "mtitle": "hello world",
      "uname": "yangming",
      "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
      "mlike": 1
    },
    {
      "mstars": 0,
      "mreplies": 0,
      "mid": 94,
      "uid": 1,
      "mcontent": "",
      "mtitle": "111",
      "uname": "yangming",
      "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
      "mlike": 8
    }
  ],
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 按uid获取收藏帖

GET /stick/getStarSticks/{uid}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uid|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": [
    {
      "mstars": 0,
      "mreplies": 0,
      "mid": 94,
      "uid": 2,
      "mcontent": "",
      "mtitle": "111",
      "uname": "Mr.B",
      "uavatar": "/uploadFile/2/a5533032-9b4d-422a-a8ab-a487c367da64.jpg",
      "mlike": 8
    },
    {
      "mstars": 0,
      "mreplies": 2,
      "mid": 92,
      "uid": 2,
      "mcontent": "数组指针是指向数组的指针，但是数组指针数组是一个数组里面包含若干个数组指针，但是疑问点来了，数组指针是一个地址指向数组，可数组指针数组里面一个数组包含若干个指针去指向那个数组，这个叫数组指针数组。但是数组里面包含指针，不应该是指针数组吗？为什么我看教学上都是叫数组指针数组？真的学蒙了。",
      "mtitle": "求救！这个数组指针真是给我学蒙了。",
      "uname": "Mr.B",
      "uavatar": "/uploadFile/2/a5533032-9b4d-422a-a8ab-a487c367da64.jpg",
      "mlike": 1
    }
  ],
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 添加帖子文本内容

POST /stick/addStickContent

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uID|query|integer| 是 |none|
|mTitle|query|string| 是 |none|
|mContent|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "vStick": true,
    "mID": 98
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 修改帖子

POST /stick/updateStick

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|query|integer| 是 |none|
|mTitle|query|string| 是 |none|
|mContent|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": true,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 删除帖子（只删除数据库信息

POST /stick/delStickBymID

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": true,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 判断该用户是否已收藏该贴

GET /stick/checkStarred/{mID}/{uID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|path|string| 是 |none|
|uID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": true,
  "msg": "执行成功"
}
```

```json
{
  "code": -1,
  "data": false,
  "msg": "操作失败"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 收藏贴子

GET /stick/addStarStick/{uID}/{mID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uID|path|string| 是 |none|
|mID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": true,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

# UserController

## POST getUsers

POST /user/getUsers

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 账号密码验证

POST /user/getLogin

> Body 请求参数

```json
{
  "text": "ym@outlook.com",
  "pwd": "a"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": 1,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 验证email是否被注册(已注册返回F，未注册返回T)

POST /user/isEmail

> Body 请求参数

```json
{
  "email": "ym@outlook.com"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
false
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|boolean|

## POST 验证邮箱并注册用户

POST /user/getNewUser

> Body 请求参数

```json
{
  "newUser": {
    "uName": "John Doe",
    "uSex": 1,
    "uEmail": "john.doe@example.com",
    "uPwd": "password123"
  }
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": 53,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST newUser2

POST /user/getNewUser2

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uName|query|string| 是 |none|
|uSex|query|string| 是 |“男”1，“女“2|
|uEmail|query|string| 是 |none|
|uPwd|query|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": 54,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 按id查找用户

GET /user/getUser/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |用户uID|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "grade": 0,
    "autograph": "This's demo",
    "uid": 1,
    "upwd": "a",
    "uname": "yangming",
    "usex": 2,
    "uemail": "ym@outlook.com",
    "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
    "ucreateTime": "2023-08-09 17:27:17",
    "uphone": "5232511166"
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 更改用户头像图片，将图片保存到指定位置

POST /user/updateAvatar

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uID|query|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## POST 更改用户消息

POST /user/updateUser

> Body 请求参数

```json
{
  "key": {}
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|any| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {},
  "msg": ""
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

# AdminController

## GET 登录验证

GET /admin/login

> 返回示例

> 成功

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|string|

## POST login

POST /admin/login

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|aName|query|string| 是 |none|
|aPwd|query|string| 是 |none|

> 返回示例

> 成功

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|string|

# ReplyController

## GET 根据主贴ID获取回复贴（里面包含回复贴用户信息

GET /reply/getReplies/{mID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "replies": [
      {
        "rcontent": "数组指针，数组的指针，他是指针。 指针数组，指针的数组，他是数组。",
        "mid": 92,
        "uid": 47,
        "uname": "demo",
        "uavatar": "/uploadFile/47/1fd94663-b41d-4923-99ad-5b758294d3cf.jpeg",
        "rlike": 0,
        "rcreateTime": "2024-06-23 22:59:23",
        "rid": 29
      },
      {
        "rcontent": "1",
        "mid": 92,
        "uid": 1,
        "uname": "yangming",
        "uavatar": "/uploadFile/1/6408d1d8-e94e-4ca4-8975-9552534f5e67.jpg",
        "rlike": 0,
        "rcreateTime": "2024-06-25 22:45:37",
        "rid": 30
      }
    ]
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 根据主贴ID获取回复贴数量（并且保存记录到主贴

GET /reply/getReplyCountAsMID/{mID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|mID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": 2,
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

## GET 获取该用户主贴的回复帖（里面包含回复贴用户信息

GET /reply/getUMReplies/{uID}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|uID|path|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 0,
  "data": {
    "uReplies": [
      {
        "rcontent": "1",
        "mid": 88,
        "uid": 2,
        "uname": "Mr.B",
        "uavatar": "/uploadFile/2/a5533032-9b4d-422a-a8ab-a487c367da64.jpg",
        "rlike": 0,
        "rcreateTime": "2024-06-23 22:40:44",
        "rid": 28
      }
    ]
  },
  "msg": "执行成功"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[R](#schemar)|

# 数据模型

<h2 id="tocS_Map«Object»">Map«Object»</h2>

<a id="schemamap«object»"></a>
<a id="schema_Map«Object»"></a>
<a id="tocSmap«object»"></a>
<a id="tocsmap«object»"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|object¦null|false|none||none|

<h2 id="tocS_HashMap«Object»">HashMap«Object»</h2>

<a id="schemahashmap«object»"></a>
<a id="schema_HashMap«Object»"></a>
<a id="tocShashmap«object»"></a>
<a id="tocshashmap«object»"></a>

```json
{
  "key": {}
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|key|object¦null|false|none||none|

<h2 id="tocS_R">R</h2>

<a id="schemar"></a>
<a id="schema_R"></a>
<a id="tocSr"></a>
<a id="tocsr"></a>

```json
{
  "code": 0,
  "data": {},
  "msg": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|code|integer¦null|false|none||none|
|data|[Object](#schemaobject)|false|none||none|
|msg|string¦null|false|none||none|

<h2 id="tocS_Object">Object</h2>

<a id="schemaobject"></a>
<a id="schema_Object"></a>
<a id="tocSobject"></a>
<a id="tocsobject"></a>

```json
{}

```

### 属性

*None*

