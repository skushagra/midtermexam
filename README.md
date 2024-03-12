# API Documentation for Backend Midterm Exam

To run the application server clone the Github repo and run the `MidtermexamApplication` file or use `./gradlew build` command to build
the project and run it.

### API Call to get all products
`GET http://localhost:8080/carts`

Returns a list of Carts
```
[
  {
    "id": 1,
    "userId": 1,
    "products": [
      {
        "productId": 1,
        "quantity": 4
      },
      {
        "productId": 2,
        "quantity": 1
      },
      {
        "productId": 3,
        "quantity": 6
      }
    ],
    "date": "2020-03-02T00:00:00.000Z"
  },
  {
    "id": 2,
    "userId": 1,
    "products": [
      {
        "productId": 2,
        "quantity": 4
      },
      {
        "productId": 1,
        "quantity": 10
      },
      {
        "productId": 5,
        "quantity": 2
      }
    ],
    "date": "2020-01-02T00:00:00.000Z"
  },
  {
    "id": 3,
    "userId": 2,
    "products": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 9,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 4,
    "userId": 3,
    "products": [
      {
        "productId": 1,
        "quantity": 4
      }
    ],
    "date": "2020-01-01T00:00:00.000Z"
  },
  {
    "id": 5,
    "userId": 3,
    "products": [
      {
        "productId": 7,
        "quantity": 1
      },
      {
        "productId": 8,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 6,
    "userId": 4,
    "products": [
      {
        "productId": 10,
        "quantity": 2
      },
      {
        "productId": 12,
        "quantity": 3
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 7,
    "userId": 8,
    "products": [
      {
        "productId": 18,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  }
]
```

### API call to get single product with id 1
`GET http://localhost:8080/carts/1`

Returns a single cart
```
{
  "id": 1,
  "userId": 1,
  "products": [
    {
      "productId": 1,
      "quantity": 4
    },
    {
      "productId": 2,
      "quantity": 1
    },
    {
      "productId": 3,
      "quantity": 6
    }
  ],
  "date": "2020-03-02T00:00:00.000Z"
}
```

### API call to get carts in date range
`GET http://localhost:8080/carts?startdate=2016-10-10&enddate=2020-10-10`

Return all carts in the range of date startdate and enddate

```
[
  {
    "id": 1,
    "userId": 1,
    "products": [
      {
        "productId": 1,
        "quantity": 4
      },
      {
        "productId": 2,
        "quantity": 1
      },
      {
        "productId": 3,
        "quantity": 6
      }
    ],
    "date": "2020-03-02T00:00:00.000Z"
  },
  {
    "id": 2,
    "userId": 1,
    "products": [
      {
        "productId": 2,
        "quantity": 4
      },
      {
        "productId": 1,
        "quantity": 10
      },
      {
        "productId": 5,
        "quantity": 2
      }
    ],
    "date": "2020-01-02T00:00:00.000Z"
  },
  {
    "id": 3,
    "userId": 2,
    "products": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 9,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 4,
    "userId": 3,
    "products": [
      {
        "productId": 1,
        "quantity": 4
      }
    ],
    "date": "2020-01-01T00:00:00.000Z"
  },
  {
    "id": 5,
    "userId": 3,
    "products": [
      {
        "productId": 7,
        "quantity": 1
      },
      {
        "productId": 8,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 6,
    "userId": 4,
    "products": [
      {
        "productId": 10,
        "quantity": 2
      },
      {
        "productId": 12,
        "quantity": 3
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  },
  {
    "id": 7,
    "userId": 8,
    "products": [
      {
        "productId": 18,
        "quantity": 1
      }
    ],
    "date": "2020-03-01T00:00:00.000Z"
  }
]
```

### API call to get user cart with userId 1
`GET http://localhost:8080/carts/user/1`

Returns list of all carts with user id 1

```
[
  {
    "id": 1,
    "userId": 1,
    "products": [
      {
        "productId": 1,
        "quantity": 4
      },
      {
        "productId": 2,
        "quantity": 1
      },
      {
        "productId": 3,
        "quantity": 6
      }
    ],
    "date": "2020-03-02T00:00:00.000Z"
  },
  {
    "id": 2,
    "userId": 1,
    "products": [
      {
        "productId": 2,
        "quantity": 4
      },
      {
        "productId": 1,
        "quantity": 10
      },
      {
        "productId": 5,
        "quantity": 2
      }
    ],
    "date": "2020-01-02T00:00:00.000Z"
  }
]

```

### API call to add a new cart for user with id 1
```
POST http://localhost:8080/carts
Content-Type: application/json

{
    "userId": 1,
    "date": "2024-03-12",
    "products": [
        {
            "productId": 1,
            "quantity": 10
        },
        {
            "productId": 2,
            "quantity": 20
        }
    ]
}
```

Add a new cart for user with id 1 and returns it

```
{
  "id": 11,
  "userId": 1,
  "products": [
    {
      "productId": 1,
      "quantity": 10
    },
    {
      "productId": 2,
      "quantity": 20
    }
  ],
  "date": "2024-03-12"
}
```

### API call to update a product with id 1 using PUT request
```
PUT http://localhost:8080/carts/1
Content-Type: application/json

{
    "userId": 1,
    "date": "2020-03-02T00:00:00.000Z"
    "products": [
        {
            "productId": 1,
            "quantity": 40
        },
        {
            "productId": 2,
            "quantity": 10
        },
        {
            "productId": 3,
            "quantity": 60
        }
    ],
}
```

updates a cart with new data and returns new cart
```
{
  "id": 1,
  "userId": 1,
  "products": [
    {
      "productId": 1,
      "quantity": 40
    },
    {
      "productId": 2,
      "quantity": 10
    },
    {
      "productId": 3,
      "quantity": 60
    }
  ],
  "date": "2020-03-02T00:00:00.000Z"
}
```

### API call to delete a cart with id 1
`DELETE http://localhost:8080/carts/1`

Deletes a cart from DB and returns deleted cart

```
{
  "id": 1,
  "userId": 1,
  "products": [
    {
      "productId": 1,
      "quantity": 40
    },
    {
      "productId": 2,
      "quantity": 10
    },
    {
      "productId": 3,
      "quantity": 60
    }
  ],
  "date": "2020-03-02T00:00:00.000Z"
}
```