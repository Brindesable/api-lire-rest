# Lire Api REST

Launch the server
```bash
./gradlew bootRun
```

Build a docker
```
./gradlew build buildDocker
```

## Index Image

Endpoint :
```bash
GET/POST http://localhost:8080/indeximg?img=<path/to/img.jpg>
```

Result :
```json
{
    "status": 200,
    "message": "Image <path/to/img.jpg> has been indexed"
}
```

## Index Directory

Endpoint :
```bash
GET/POST localhost:8080/indexdir?dir=<path/to/dir>
```
Result :
```json
{
    "status": 200,
    "message": "Directory <path/to/dir> has been indexed"
}
```

## Search Similar Images

Endpoint :
```bash
# nb default value is 10
GET/POST localhost:8080/search?img=<path/to/img.jpg>?n=3
```

Result :
```json
{
    "status": 200,
    "message": "Searched images similar to <path/to/img.jpg>",
    "res": [
        {
            "imgPath": "<path/to/img1.jpg>",
            "score": 0
        },
        {
            "imgPath": "<path/to/img2.jpg>",
            "score": 15.457514828574318
        },
        {
            "imgPath": "<path/to/img3.jpg>",
            "score": 17.415587763750523
        }
    ]
}
```

## Errors

Error example :
```json
{
    "timestamp": 1499085970588,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "java.io.IOException",
    "message": "No message available",
    "path": "/search"
}
```
