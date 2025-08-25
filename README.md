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
- **URL**: `POST http://localhost:8080/api/aasx/convert`
- **Content-Type**: `multipart/form-data`
- **Parameter**: `file` (AASX 파일)
- **Response**: JSON 형식의 AAS 데이터

### 2. Health Check
- **URL**: `GET http://localhost:8080/api/aasx/health`
- **Response**: 서버 상태 정보

## 사용 예시

```bash
curl -X POST -F "file=@example.aasx" http://localhost:8080/api/aasx/convert
```

## 주의사항

- 최대 파일 크기: 50MB
- 지원 파일 형식: .aasx
- CORS 허용 Origin: http://localhost:5173, http://localhost:5174