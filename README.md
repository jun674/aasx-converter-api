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

## Heroku 배포 방법 (수동)

이 프로젝트는 Heroku를 통해 웹에 배포할 수 있습니다.

### 1. 소스 코드 수정 및 GitHub에 업로드
로컬에서 소스 코드를 수정한 후, 다음 Git 명령어를 사용하여 변경사항을 GitHub 저장소에 업로드합니다.

```bash
# 1. 변경된 모든 파일을 스테이징
git add .

# 2. 변경사항에 대한 커밋 메시지 작성
git commit -m "수정한 내용에 대한 요약"

# 3. GitHub 원격 저장소(master 브랜치)로 푸시
git push origin master
```

### 2. Heroku 대시보드에서 수동 배포
1. [Heroku 대시보드](https://dashboard.heroku.com)에 로그인합니다.
2. 배포할 앱(예: `aasx-converter-api`)을 선택합니다.
3. **Deploy** 탭으로 이동합니다.
4. 페이지 하단의 **Manual deploy** 섹션으로 스크롤합니다.
5. 배포할 브랜치(`master`)가 선택되었는지 확인하고, **Deploy Branch** 버튼을 클릭합니다.
6. 빌드 및 배포 과정이 로그와 함께 표시되며, 완료되면 "Your app was successfully deployed." 메시지를 확인할 수 있습니다.
