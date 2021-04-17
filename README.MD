# BookStore back-end
This project is a demo for Nickel
 
## Used librairies


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
    
