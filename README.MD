# BookStore back-end
This project is a demo for Nickel
 
## Used librairies

### Liquibase
It's a tool to migrate data. In this project, there are 3 main files :

- **db.changelog-master.xml** contains links to other changelogs.
- **db.changelog-init.xml** create tables used for the actual project version.
- **db.changelog-data.xml** contains data used to play with, must be disable for production use.

# Webservices
There are 3 webservices

## 1. Find books from IDs

Return books from a set of ids(ISBN). If some or all are not found, no books returned for these ids.

For example, this request :

    POST localhost:8080/book/find
    {
        "isbnList": [
            "9782070584628",
            "9782070368228",
            "9782370490001"
        ]
    }
return :

    [
        {
            "isbn": "9782070368228",
            "title": "1984",
            "price": 9.20
        },
        {
            "isbn": "9782070584628",
            "title": "Harry Potter à l'école des sorciers",
            "price": 5.60
        },
        {
            "isbn": "9782370490001",
            "title": "La horde du Contrevent",
            "price": 25.00
        }
    ]
    

## 2. Find order from ID
Return the order corresponding id number in parameter

For example :

    GET localhost:8080/order/2

return :

    {
        "orderNumber": 2,
        "dateTime": "2021-04-17T08:05:41",
        "orderDetails": [
            {
                "book": {
                    "isbn": "9782070360284",
                    "title": "Voyage au bout de la nuit",
                    "price": 10.30
                },
                "quantity": 2
            },
            {
                "book": {
                    "isbn": "9782070754922",
                    "title": "A la recherche du temps perdu",
                    "price": 35.00
                },
                "quantity": 1
            }
        ],
        "price": 55.60
    }