# 전사 Coding Convention : 명명규칙, Java
> Java 명명규칙 총 33종

### 1. 파일명
- CamelCase
- Class명, Interface명과 동일

### 2. Package명
- 모두 소문자로
- `.*` 지양
    - bad example : java.awt.*
    - good example : java.awt.image

### 3. Class / Interface명
- CamelCase
- 31문자 이내
- 명사형
- Interface의 경우 I로 시작. ex.IFigureDrawer

### 4. Instance
- 첫글자 소문자
- 3 <= 길이 < 31

### 5. 상수
- 모두 영문 대문자, _로 구분
- MAX_EQUIPMENT_COUNT

### 6. 필드 / 매개변수
- 첫글자 소문자
- 3 <= 길이 < 31
- l(el)지양. 1(숫자)과 혼동되기 때문
- 약어 지양 

### 7. 메소드
- 첫글자 소문자
- 동사 + 명사
- boolean : 동사 + 형용사 (isResizable)
- 3 <= 길이 < 31
- 이벤트리스너 : 명사 + 동사(ing, p.p)
    - ex. mouseClicked()

### 8. 배열
- bad example : int[] values
- good example : int values[]

