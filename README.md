# AASX Converter API

AASX 파일을 JSON으로 변환하는 Spring Boot API 서버입니다.

## 요구사항

- Java 17 이상
- Maven 3.6 이상

## 실행 방법

1. 프로젝트 디렉토리로 이동:
```bash
cd aasx-converter-api
```

2. Maven 의존성 설치 및 애플리케이션 실행:
```bash
mvn spring-boot:run
```

또는 JAR 파일로 빌드 후 실행:
```bash
mvn clean package
java -jar target/aasx-converter-api-0.0.1-SNAPSHOT.jar
```

## API 엔드포인트

### 1. AASX to JSON 변환
- **URL**: `POST http://localhost:8080`
- **Content-Type**: `multipart/form-data`
- **Parameter**: `file` (AASX 파일)
- **Response**: JSON 형식의 AAS 데이터
